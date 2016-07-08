package cn.newtouch.dms.service.impl;

import java.util.Collections;
import java.util.List;

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
	public Role getRoleById(Integer id) {
		return roleDao.findById(id);
	}
	
	@Override
	public List<Role> getRoles() {
		return roleDao.findAll();
	}

	/**
	 * 得到所有职级比给定角色低的角色.
	 * 
	 * @param role Role
	 * @return List&lt;Role&gt;
	 */
	@Override
	public List<Role> getRolesPriorLowerThan(Role role) {
		//TODO 
		return Collections.<Role> emptyList();
	}
	
}
