package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.Right;

public interface RightDao {
    int deleteById(Integer id);

    int insert(Right record);

    int insertSelective(Right record);

    Right selectById(Integer id);

    int updateSelective(Right record);

    int update(Right record);
}