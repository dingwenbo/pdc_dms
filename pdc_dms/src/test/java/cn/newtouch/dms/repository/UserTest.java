/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.newtouch.dms.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import cn.newtouch.dms.data.UserData;
import cn.newtouch.dms.entity.Member;
import cn.newtouch.dms.service.MemberService;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UserTest extends SpringTransactionalTestCase {

	private static Logger logger = LoggerFactory.getLogger(UserTest.class);

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private MemberService memberService;
	
	@Test
	public void testGetMembers() {
		List<Member> members = memberDao.selectAll();
		
		for (Member member : members) {
			logger.info(member.toString());
		}
	}
	
	@Test
	public void registerMember() {
		Member member = UserData.randomNewUser();
		Date currentTime = new Date();

		memberService.insertMember(member);

		// 验证user的角色，注册日期和加密后的密码都被自动更新了。
//		assertThat(user.getRoles()).isEqualTo("user");
		assertThat(member.getRegisterDate()).isNotNull();
		assertThat(member.getPassword()).isNotNull();
		assertThat(member.getSalt()).isNotNull();
	}
}
