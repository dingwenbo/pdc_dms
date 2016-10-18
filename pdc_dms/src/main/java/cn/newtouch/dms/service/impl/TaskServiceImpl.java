package cn.newtouch.dms.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import cn.newtouch.dms.entity.Task;
import cn.newtouch.dms.entity.TaskStatus;
import cn.newtouch.dms.service.TaskService;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

	/** logger */
	private static Log logger = LogFactory.getLog(TaskServiceImpl.class);
	
	public TaskServiceImpl() {
		logger.info("初始化Task service...");
		
		logger.info("验证Task status在数据库的状态和EnumTaskStatus是否保持一致...");
		validateTaskStatus();
	}
	
	private void validateTaskStatus() {
		//TODO : 
	}

	@Override
	public void insertOrUpdateTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTaskById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Task> getTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasksByMemberPdcId(String pdcId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getTaskById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getTaskByCode(String codeTask) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskStatus> getAllTaskStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
