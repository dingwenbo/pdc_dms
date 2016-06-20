package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.Task;

public interface TaskDao {
    int deleteById(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectById(Integer id);

    int updateSelective(Task record);

    int update(Task record);
}