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
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;
import org.springside.modules.utils.Clock.MockClock;

import cn.newtouch.dms.data.UserData;
import cn.newtouch.dms.entity.User;
import cn.newtouch.dms.service.impl.AccountService;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UserTest extends SpringTransactionalTestCase {

	private static Logger logger = LoggerFactory.getLogger(UserTest.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private AccountService accountService;
	
	@Test
	public void testGetUsers() {
		List<User> users = userDao.findAll();
		
		for (User user : users) {
			logger.info(user.toString());
		}
	}
	
	@Test
	public void registerUser() {
		User user = UserData.randomNewUser();
		Date currentTime = new Date();
		accountService.setClock(new MockClock(currentTime));

		accountService.insertUser(user);

		// 验证user的角色，注册日期和加密后的密码都被自动更新了。
		assertThat(user.getRoles()).isEqualTo("user");
		assertThat(user.getRegisterDate()).isEqualTo(currentTime);
		assertThat(user.getPassword()).isNotNull();
		assertThat(user.getSalt()).isNotNull();
	}
}
