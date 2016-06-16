package cn.newtouch.dms.repository;

import cn.newtouch.dms.entity.Project;

public interface ProjectDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}