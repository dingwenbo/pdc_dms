package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.Profile;

public interface ProfileDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Profile record);

    int insertSelective(Profile record);

    Profile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Profile record);

    int updateByPrimaryKey(Profile record);
}