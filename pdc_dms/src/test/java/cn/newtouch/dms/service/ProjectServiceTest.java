package cn.newtouch.dms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import cn.newtouch.dms.entity.Project;

/**
 * Project Service的单元测试
 * @author JiaLong.Wang
 *
 */
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class ProjectServiceTest extends SpringTransactionalTestCase{
	
	/** logger. */
	private static Log logger = LogFactory.getLog(ProjectServiceTest.class);
	
	/** projectService. */
	@Autowired
	private ProjectService projectService;
	
	@Before
	public void setUp() {
		logger.info("初始化ProjectServiceTest..");
//		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetProjects() {
		Project nullProject = null;
		List<Project> nullProjects = null;
		
		// Test for getProjects().
		logger.info("测试方法：cn.newtouch.dms.service.ProjectService.getProjects()");
		List<Project> projects = projectService.getProjects();
		assertNotNull(projects);
		assertEquals(7, projects.size());
		
		// Test for getProjectsByMemberPdcId(String).
		logger.info("测试方法：cn.newtouch.dms.service.ProjectService.getProjectsByMemberPdcId(String)");
		nullProjects = projectService.getProjectsByMemberPdcId(null);
		assertNull(nullProjects);
		nullProjects = projectService.getProjectsByMemberPdcId("");
		assertNull(nullProjects);
		projects = projectService.getProjectsByMemberPdcId("9002");
		assertEquals(3, projects.size());
		
		// Test for getProjectById(Integer).
		logger.info("测试方法：cn.newtouch.dms.service.ProjectService.getProjectById(Integer)");
		nullProject = projectService.getProjectById(1000);
		assertNull(nullProject);
		Project project = projectService.getProjectById(1);
		assertProject(project, "GPRO_Pyramide", "GPRO_Pyramide Group label.", "GPRO and Pyramide Group", 7);
		
		// Test for getProjectByCode(String).
		logger.info("测试方法：cn.newtouch.dms.service.ProjectService.getProjectByCode(String)");
		nullProject = projectService.getProjectByCode("");
		assertNull(nullProject);
		nullProject = projectService.getProjectByCode(null);
		assertNull(nullProject);
		project = projectService.getProjectByCode("FJV2");
		assertProject(project, "FJV2", "FJV2 Label", "PDC FJV2 Team", null);
	}
	
	@Test
	public void testInsertOrUpdateProject() throws Exception {
		logger.info("测试方法：cn.newtouch.dms.service.ProjectService.insertOrUpdateProject(Project)");
		
		final String PARENT_CODE = "Parent Test1";
		final String PARENT_LABEL = "Parent project label";
		final String PARENT_FULL_NAME = "Parent project full name";
		
		final String TEST_CODE = "Test1";
		final String TEST_LABEL = "Test label1";
		final String TEST_FULL_NAME = "Test Full Name";
		
		Project parent = new Project(PARENT_CODE, PARENT_LABEL);
		parent.setFullName(PARENT_FULL_NAME);
		
		Project project = new Project(TEST_CODE, TEST_LABEL);
		project.setFullName(TEST_FULL_NAME);
		project.setParent(parent);
		
		projectService.insertOrUpdateProject(project);
		
		project = projectService.getProjectByCode(TEST_CODE);
		// pProject 不存在于数据库中，所有project不会有parent project的信息。
		assertProject(project, TEST_CODE, TEST_LABEL, TEST_FULL_NAME, null);
		
		projectService.insertOrUpdateProject(parent);
		parent = projectService.getProjectByCode(PARENT_CODE);
		
		project.setLabel("Modif Label1");
		project.setFullName("Modif full name");
		project.setParent(parent);
		projectService.insertOrUpdateProject(project);
		
		project = projectService.getProjectByCode(TEST_CODE);
		assertProject(project, TEST_CODE, "Modif Label1", "Modif full name", parent.getId());
		
		//更新project使其父项目是一个不存在的id.
		parent.setId(1000);
		project.setParent(parent);
		projectService.insertOrUpdateProject(project);
		project = projectService.getProjectByCode(TEST_CODE);
		
		assertNull(project.getParent());
	}
	
	@Test
	public void testDeleteProject() {
		logger.info("测试方法：cn.newtouch.dms.service.ProjectService.deleteProjectById(Integer)");
		final Integer deleteId = 1;
		final Integer deleteNonExistenceElementId = 1000;
		
		projectService.deleteProjectById(1);
		Project project = projectService.getProjectById(1);
		assertNull(project);
		
		projectService.deleteProjectById(deleteNonExistenceElementId);
		assertEquals(6, projectService.getProjects().size());
	}
	
	@Test
	public void testExistProject() {
		Integer nullInteger = null;
		String nullString = null;
		
		// 测试id 项目
		logger.info("测试方法：cn.newtouch.dms.service.ProjectService.existProject(Integer)");
		assertTrue(projectService.existProject(1));
		assertFalse(projectService.existProject(1000));
		assertFalse(projectService.existProject(nullInteger));
		
		// 测试code 项目
		logger.info("测试方法：cn.newtouch.dms.service.ProjectService.existProject(String)");
		assertTrue(projectService.existProject("FJV2"));
		assertTrue(projectService.existProject("Pyramide"));
		assertFalse(projectService.existProject("Test1234"));
		assertFalse(projectService.existProject(""));
		assertFalse(projectService.existProject(nullString));
	}
	
	@Test
	public void testSelectBy() {
		// Project的条件过滤查询测试
		
	}
	
	private void assertProject(Project project, String pCode, String pLabel, String pFullName, Integer pParentId) {
		assertEquals(pCode, project.getCode());
		assertEquals(pLabel, project.getLabel());
		assertEquals(pFullName, project.getFullName());
		if (project.getParent() == null) {
			assertNull(pParentId);
		} else {
			assertEquals(pParentId, project.getParent().getId());
		}
	}
}
