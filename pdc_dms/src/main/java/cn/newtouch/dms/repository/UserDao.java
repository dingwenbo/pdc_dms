/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.newtouch.dms.repository;

import java.util.List;

import cn.newtouch.dms.entity.User;

public interface UserDao {
	
	User findByLoginName(String loginName);

	List<User> findAll();

	User findOne(Long id);

	/**
	 * 保存一个用户对象，
	 * @param user User
	 */
	void save(User user);

	int update(User user);
	
	int delete(Long id);

}
