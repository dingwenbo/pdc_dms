package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.RoleProfileKey;

public interface RoleProfileDao {
    int deleteByPrimaryKey(RoleProfileKey key);

    int insert(RoleProfileKey record);

    int insertSelective(RoleProfileKey record);
}