package cn.newtouch.dms.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.newtouch.dms.entity.Project;
import cn.newtouch.dms.repository.ProjectDao;
import cn.newtouch.dms.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	
	/** LOGGER */
	private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private ProjectDao projectDao;
	
	public ProjectServiceImpl() {
		logger.info("构造Project Service...");
	}
	
	@PostConstruct
	public void init() {
		logger.info("正在执行Project Service的初始化方法init()");
	}

	@Override
	public Project getProjectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrUpdateProject(Project project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProjectById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Project getProjectByCode(String projectCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existProject(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existProject(String projectCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Project> getProjectsByMemberPdcId(String pdcId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
