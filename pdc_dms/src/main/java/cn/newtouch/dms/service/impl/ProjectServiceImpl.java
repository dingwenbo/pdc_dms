package cn.newtouch.dms.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.newtouch.dms.entity.Project;
import cn.newtouch.dms.exception.ProjectServiceException;
import cn.newtouch.dms.repository.ProjectDao;
import cn.newtouch.dms.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	
	/** LOGGER */
	private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private ProjectDao projectDao;
	
	public ProjectServiceImpl() {
		logger.info("初始化Project Service...");
		init();
	}
	
	@PostConstruct
	public void init() {
		logger.info("正在执行Project Service的初始化方法init()");
	}

	@Override
	public Project getProjectById(Integer id) {
		return projectDao.selectById(id);
	}

	@Override
	public Project getProjectByCode(String projectCode) {
		return projectDao.selectByCode(projectCode);
	}
	
	@Override
	public void insertOrUpdateProject(Project project) throws ProjectServiceException {
		if (project == null || StringUtils.isEmpty(project.getCode())) {
			throw new ProjectServiceException("不能创建空项目");
		}
		
		if (existProject(project.getCode())) {
			projectDao.update(project);
		} else {
			projectDao.insertSelective(project);
		}
	}
	
	@Override
	public void deleteProjectById(Integer id) {
		projectDao.deleteById(id);
	}

	@Override
	public boolean existProject(Integer id) {
		if (id == null) {
			return false;
		}
		return getProjectById(id) != null;
	}

	@Override
	public boolean existProject(String projectCode) {
		//TODO 
		if (StringUtils.isEmpty(projectCode)) {
			return false;
		}
		
		return getProjectByCode(projectCode) != null;
	}

	@Override
	public List<Project> getProjectsByMemberPdcId(String pdcId) {
		return null;
	}

	@Override
	public List<Project> getProjects() {
		return projectDao.selectAll();
	}

	@Override
	public List<Project> getProjectsBy(Project projectFilter) {
		return projectDao.selectBy(projectFilter);
	}
	
}
