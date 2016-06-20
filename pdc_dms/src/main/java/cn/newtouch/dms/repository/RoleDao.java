package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.Role;

public interface RoleDao {
    int deleteById(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectById(Integer id);

    int updateSelective(Role record);

    int update(Role record);
}