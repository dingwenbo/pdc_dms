package cn.newtouch.dms.service;

import java.util.List;

import cn.newtouch.dms.entity.Project;

/**
 * 管理项目信息的Service。
 * 
 * @author JiaLong.Wang
 *	
 */
public interface ProjectService {

	/**
	 * 根据内置id得到Project对象
	 * @param id Integer
	 * @return Project
	 */
	Project getProjectById(Integer id);
	
	/**
	 * 根据项目code得到Project对象
	 * @param projectCode String
	 * @return Project
	 */
	Project getProjectByCode(String projectCode);
	
	/**
	 * 插入或更新一个Project对象
	 * @param project Project
	 */
	void insertOrUpdateProject(Project project);
	
	/**
	 * 删除一个Project对象
	 * @param id Integer
	 */
	void deleteProjectById(Integer id);
	
	/**
	 * 是否存在相应id的Project对象
	 * @param id Integer
	 * @return boolean
	 */
	boolean existProject(Integer id);
	
	/**
	 * 是否存在code一致的Project对象.
	 * @param projectCode String
	 * @return boolean
	 */
	boolean existProject(String projectCode);
	
	/**
	 * 得到与用户有关的项目集合
	 * @param pdcId String
	 * @return List&lt;Project&gt;
	 */
	List<Project> getProjectsByMemberPdcId(String pdcId);
	
	/**
	 * 得到所有的项目
	 * @return List&lt;Project&gt;
	 */
	List<Project> getProjects();
}
