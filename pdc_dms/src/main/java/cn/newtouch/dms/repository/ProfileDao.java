package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.Profile;

public interface ProfileDao {
    int deleteById(Integer id);

    int insert(Profile record);

    int insertSelective(Profile record);

    Profile selectById(Integer id);

    int updateSelective(Profile record);

    int update(Profile record);
}