package cn.newtouch.dms.web.project;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.newtouch.dms.entity.Project;
import cn.newtouch.dms.json.JsonUtils;
import cn.newtouch.dms.service.ProjectService;
import cn.newtouch.dms.web.project.bean.ProjectDetailVO;

/**
 * Project Management Controller
 * 项目管理模块的控制器，其中包括项目管理和任务管理。
 * 
 * @author JiaLong.Wang
 *
 */
@Controller
@RequestMapping(value = "/projectManagement")
public class ProjectManagementController {
	
	/** logger. */
	private static Log logger = LogFactory.getLog(ProjectManagementController.class);
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/project")
	public String viewProject() {
		return "projectManagement/project";
	}
	
	@RequestMapping(value = "/task")
	public String viewTask() {
		return "projectManagement/task";
	}
	
	@RequestMapping(value = "/getProjectData")
	@ResponseBody
	public String getProjectData() {
		List<ProjectDetailVO> results = new ArrayList<>();
		
		List<Project> projects = projectService.getProjects();
		for (Project project : projects) {
			ProjectDetailVO pdvo = new ProjectDetailVO();
			pdvo.accept(project);
			results.add(pdvo);
		}
		
		logger.info("得到" + results.size() + "条项目详细记录。");
		return JsonUtils.writeObject(results);
	}
	
	@RequestMapping(value = "/editProjectData")
	@ResponseBody
	public String editProjectData(HttpServletRequest request) {
		String code = request.getParameter("code");
		String oper = request.getParameter("oper");
		
		Project project = new Project();
		project.setCode(code);
		project.setFullName(request.getParameter("fullName"));
		project.setLabel(request.getParameter("lable"));
		project.setParent(null);
		
//		if (oper !=null && oper.equals("add")) {
//			if (projectServiceImpl.existProject(code)) {
//				projectServiceImpl.insertOrUpdateProject(project);
//			} else {
//				logger.warn("项目已存在");
//			}
//		} else if (oper != null && oper.equals("edit")) {
//			projectServiceImpl.insertOrUpdateProject(project);
//		}

		System.out.println(oper + "--------test oper");
		return "";
	}
	
	@RequestMapping(value = "/deleteProjectData")
	@ResponseBody
	public String deleteProjectData(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		projectService.deleteProjectById(id);
		System.out.println(id + "----------delete project");
		return "project";
	}
	
	@RequestMapping(value = "/getParentProject")
	@ResponseBody
	public String getParentProject() {
		Project project1 = new Project();
		project1.setId(1);
		project1.setCode("Test 01");
		
		Project project2 = new Project();
		project2.setId(2);
		project2.setCode("Test 02");
		
		List<Project> lstProject = new ArrayList<Project>();
		lstProject.add(project1);
		lstProject.add(project2);
		lstProject = projectService.getProjects();
		
		return JsonUtils.writeObject(lstProject);
	}
}
