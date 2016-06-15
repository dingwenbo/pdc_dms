package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.ProfileRightsKey;

public interface ProfileRightsDao {
    int deleteByPrimaryKey(ProfileRightsKey key);

    int insert(ProfileRightsKey record);

    int insertSelective(ProfileRightsKey record);
}