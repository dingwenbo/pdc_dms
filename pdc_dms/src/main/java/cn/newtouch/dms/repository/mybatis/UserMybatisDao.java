/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.newtouch.dms.repository.mybatis;

import cn.newtouch.dms.entity.User;

public interface UserMybatisDao {
	void save(User user);
}
