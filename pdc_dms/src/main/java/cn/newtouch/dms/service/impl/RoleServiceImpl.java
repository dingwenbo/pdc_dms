package cn.newtouch.dms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.newtouch.dms.entity.Role;
import cn.newtouch.dms.repository.RoleDao;
import cn.newtouch.dms.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	@Override
	public Role selectById(Integer id) {
		return roleDao.selectByPrimaryKey(id);
	}

}
