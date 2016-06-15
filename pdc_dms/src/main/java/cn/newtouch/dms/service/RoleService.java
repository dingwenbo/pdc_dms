package cn.newtouch.dms.service;

import cn.newtouch.dms.entity.Role;

/**
 * 角色管理的 service
 * 
 * @author DWB
 *
 */
public interface RoleService {

	Role selectById(Integer id);
}
