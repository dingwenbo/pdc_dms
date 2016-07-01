package cn.newtouch.dms.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TaskServiceImpl {

	private static Log logger = LogFactory.getLog(TaskServiceImpl.class);
	
	public TaskServiceImpl() {
		logger.info("初始化Task service...");
		
		logger.info("验证Task status在数据库的状态和EnumTaskStatus是否保持一致...");
		validateTaskStatus();
	}
	
	private void validateTaskStatus() {
		
	}
}
