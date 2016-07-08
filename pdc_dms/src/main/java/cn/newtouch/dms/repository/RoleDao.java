package cn.newtouch.dms.repository;

import java.util.List;

import cn.newtouch.dms.entity.Role;

public interface RoleDao {
	
    int insert(Role record);

    int insertSelective(Role record);

    int deleteById(Integer id);
    
    int updateSelective(Role record);

    int update(Role record);
    
    Role findById(Integer id);
    
    List<Role> findAll();
}