package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.Right;

public interface RightDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Right record);

    int insertSelective(Right record);

    Right selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Right record);

    int updateByPrimaryKey(Right record);
}