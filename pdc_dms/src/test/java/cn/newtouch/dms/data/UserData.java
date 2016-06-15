/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.newtouch.dms.data;

import org.springside.modules.test.data.RandomData;

import cn.newtouch.dms.entity.Member;

public class UserData {

	public static Member randomNewUser() {
		Member user = new Member();
		user.setPdcId(RandomData.randomName("user"));
		user.setName(RandomData.randomName("User"));
		user.setPlainPassword(RandomData.randomName("password"));

		return user;
	}
}
