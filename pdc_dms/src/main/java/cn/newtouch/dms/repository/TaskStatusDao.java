package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.TaskStatus;

public interface TaskStatusDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskStatus record);

    int insertSelective(TaskStatus record);

    TaskStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskStatus record);

    int updateByPrimaryKey(TaskStatus record);
}