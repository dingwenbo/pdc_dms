package cn.newtouch.dms.service;

import java.util.List;

import cn.newtouch.dms.entity.Task;

/**
 * 管理任务的Service.
 * 
 * @author JiaLong.Wang
 *
 */
public interface TaskService {
	
	void insertOrUpdateTask(Task task);
	
	void deleteTask(Task task);
	
	void deleteTaskById(Integer id);
	
	List<Task> getTasks();
	
	List<Task> getTasksByMemberPdcId(String pdcId);
	
	Task getTaskById(Integer id);
	
	Task getTaskByCode(String codeTask);
}
