package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.Rights;

public interface RightsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Rights record);

    int insertSelective(Rights record);

    Rights selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rights record);

    int updateByPrimaryKey(Rights record);
}