package cn.newtouch.dms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.newtouch.dms.entity.Project;
import cn.newtouch.dms.repository.ProjectDao;
import cn.newtouch.dms.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	
	private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private ProjectDao projectDao;
	
	public ProjectServiceImpl() {
		logger.info("初始化Project Service...");
		// 不能直接调用projectDao.
	}
}
