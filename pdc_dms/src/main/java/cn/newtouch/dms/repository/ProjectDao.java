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
	
	/**
	 * 项目的条件查询
	 * @param record Project
	 * @return
	 */
	List<Project> selectBy(Project record);
	
	List<Project> selectByMemberPdcId(String pdcId);
	
	Project selectById(Integer id);
	
	Project selectByCode(String code);
	
    int deleteById(Integer id);

//    int insert(Project record);

    int insertSelective(Project record);
    
    int updateSelective(Project record);

//    int update(Project record);
    
}