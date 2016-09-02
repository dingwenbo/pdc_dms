package cn.newtouch.dms.web.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.newtouch.dms.entity.Project;
import cn.newtouch.dms.exception.ProjectServiceException;
import cn.newtouch.dms.json.JsonUtils;
import cn.newtouch.dms.service.ProjectService;
import cn.newtouch.dms.vo.MessageInfo;
import cn.newtouch.dms.vo.jqgrid.Model;
import cn.newtouch.dms.web.jqgrid.AbstractJqGridController;
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
public class ProjectManagementController extends AbstractJqGridController {
	
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
	
	@RequestMapping(value = "/addProjectData")
	@ResponseBody
	public String addProjectData(@ModelAttribute ProjectDetailVO projectDetail) {
		try {
			String code = projectDetail.getCode();
			if (!projectService.existProject(code)) {
				Project project = new Project();
				project.setCode(code);
				project.setFullName(projectDetail.getFullName());
				project.setLabel(projectDetail.getLabel());
				String projectCode = projectDetail.getParentCode();
				if (projectCode.equals("0")) {
					project.setParent(null);
				} else {
					Project parentProject = projectService.getProjectById(Integer.parseInt(projectDetail.getParentCode()));
					project.setParent(parentProject);
				}
				projectService.insertOrUpdateProject(project);
				logger.info("新增1条项目详细记录："+code);
			} else {
				logger.warn("项目已存在");
				return JsonUtils.writeObject(new MessageInfo("error", "项目已存在"));
			}
		} catch (ProjectServiceException e) {
			logger.error(e.getMessage());
		}
		return "success";
	}
	
	@RequestMapping(value = "/editProjectData")
	@ResponseBody
	public String editProjectData(@ModelAttribute ProjectDetailVO projectDetail) {
		try {
			Project project = new Project();
			project.setId(projectDetail.getIdValue());
			project.setCode(projectDetail.getCode());
			project.setFullName(projectDetail.getFullName());
			project.setLabel(projectDetail.getLabel());
			String projectCode = projectDetail.getParentCode();
			if (projectCode.equals("0")) {
				project.setParent(null);
			} else {
				Project parentProject = projectService.getProjectById(Integer.parseInt(projectDetail.getParentCode()));
				project.setParent(parentProject);
			}
			projectService.insertOrUpdateProject(project);
			logger.info("修改1条项目详细记录："+projectDetail.getCode());
		} catch (ProjectServiceException e) {
			logger.error(e.getMessage());
		}
		return "success";
	}
	
	@RequestMapping(value = "/deleteProjectData")
	@ResponseBody
	public String deleteProjectData(@ModelAttribute ProjectDetailVO projectDetail) {
		projectService.deleteProjectById(projectDetail.getIdValue());
		logger.info("删除1条项目详细记录");
		return "success";
	}
	
	@RequestMapping(value = "/getParentProject")
	@ResponseBody
	public String getParentProject(@ModelAttribute ProjectDetailVO projectDetail) {
		List<Project> lstProject = projectService.getProjects();
		if (projectDetail.getId() != null && !projectDetail.getId().equals("0")) {
			Project project = projectService.getProjectById(projectDetail.getIdValue());
			lstProject.remove(project);
		}
		return JsonUtils.writeObject(lstProject);
	}

    @Override
    public List<String> getColNames() {
        List<String> colNames = new ArrayList<>();
        colNames.add("No");
        colNames.add("Code");
        colNames.add("Full_Name");
        colNames.add("Label");
        colNames.add("父项目Code");
        return colNames;
    }

    @Override
    public List<Model> getColModel() {
        List<Model> colModel = new ArrayList<>();
        Model model = new Model("id", "id", Integer.valueOf("75"), null, null, Boolean.TRUE, null);
        colModel.add(model);
        model = new Model("code", "code", Integer.valueOf("350"), "left");
        colModel.add(model);
        model = new Model("fullName", null, Integer.valueOf("350"), "left");
        colModel.add(model);
        model = new Model("label", null, Integer.valueOf("400"), "left");
        colModel.add(model);
        model = new Model("parentCode", null, Integer.valueOf("350"), "left", "select");
        colModel.add(model);
        return colModel;
    }

    @Override
    public void init(HttpServletRequest request) {
        setUrl("/projectManagement/getProjectData.action");
        setWidth(Integer.valueOf("900"));
        setHeight(Integer.valueOf("250"));
        setRownumbers(Boolean.TRUE);
        setCaption("项目管理");
        setPager("pagerProject");
        setViewrecords(true);
        setRowNum(10);
        setLoadonce(true);
        setSortable(true);
    }
}
