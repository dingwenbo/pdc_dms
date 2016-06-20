package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.TaskStatus;

public interface TaskStatusDao {
    int deleteById(Integer id);

    int insert(TaskStatus record);

    int insertSelective(TaskStatus record);

    TaskStatus selectById(Integer id);

    int updateSelective(TaskStatus record);

    int update(TaskStatus record);
}