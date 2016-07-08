package cn.newtouch.dms.service;

import java.util.List;

import cn.newtouch.dms.entity.Role;

/**
 * 角色管理的 service
 * 
 * @author DWB
 *
 */
public interface RoleService {

	Role getRoleById(Integer id);
	
	List<Role> getRoles();
	
	List<Role> getRolesPriorLowerThan(Role role);
}
