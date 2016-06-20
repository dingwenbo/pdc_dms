/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.newtouch.dms.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springside.modules.test.security.shiro.ShiroTestUtils;

import cn.newtouch.dms.data.UserData;
import cn.newtouch.dms.entity.Member;
import cn.newtouch.dms.repository.MemberDao;
import cn.newtouch.dms.service.MemberService;
import cn.newtouch.dms.service.ServiceException;
import cn.newtouch.dms.service.impl.ShiroDbRealm.ShiroUser;

/**
 */
public class MemberServiceTest {

	@InjectMocks
	private MemberService memberService;

	@Mock
	private MemberDao mockMemberDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ShiroTestUtils.mockSubject(new ShiroUser(3, "foo", "Foo"));
	}

	@Test
	public void registerUser() {
		Member user = UserData.randomNewUser();
//		Date currentTime = new Date();
//		memberService.setClock(new MockClock(currentTime));

		memberService.insertMember(user);

		// 验证user的角色，注册日期和加密后的密码都被自动更新了。
//		assertThat(user.getRoles()).isEqualTo("user");
//		assertThat(user.getRegisterDate()).isEqualTo(currentTime);
		assertThat(user.getPassword()).isNotNull();
		assertThat(user.getSalt()).isNotNull();
	}

	@Test
	public void updateUser() {
		// 如果明文密码不为空，加密密码会被更新.
		Member user = UserData.randomNewUser();
		memberService.updateMember(user);
		assertThat(user.getSalt()).isNotNull();

		// 如果明文密码为空，加密密码无变化。
		Member user2 = UserData.randomNewUser();
		user2.setPlainPassword(null);
		memberService.updateMember(user2);
		assertThat(user2.getSalt()).isNull();
	}

	@Test
	public void deleteUser() {
		// 正常删除用户.
		memberService.deleteMember(3);
		Mockito.verify(mockMemberDao).deleteById(3);

		// 删除超级管理用户抛出异常, userDao没有被执行
		try {
			memberService.deleteMember(1);
			failBecauseExceptionWasNotThrown(ServiceException.class);
		} catch (ServiceException e) {
			// expected exception
		}
		Mockito.verify(mockMemberDao, Mockito.never()).deleteById(1);
	}

}
