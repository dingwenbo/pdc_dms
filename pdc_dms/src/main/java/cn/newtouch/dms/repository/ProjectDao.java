package cn.newtouch.dms.repository;

import java.util.List;

import cn.newtouch.dms.entity.Project;

/**
 * Dao interface for project.
 * 
 * @author JiaLong.Wang
 *
 */
public interface ProjectDao {

	List<Project> selectAll();
	
	List<Project> selectBy(Project project);
	
	Project selectById(Integer id);
	
    int deleteById(Integer id);

    int insert(Project record);

    int insertSelective(Project record);
    
    int updateSelective(Project record);

    int update(Project record);
    
}