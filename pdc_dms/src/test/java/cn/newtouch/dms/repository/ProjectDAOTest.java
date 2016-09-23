package cn.newtouch.dms.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import cn.newtouch.dms.entity.Project;


/**
 * ProjectDAO Junit test. 
 * 
 * @author JiaLong.Wang
 *
 */
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@FixMethodOrder(MethodSorters.DEFAULT)
public class ProjectDAOTest extends SpringTransactionalTestCase {
	
	private static Log logger = LogFactory.getLog(ProjectDAOTest.class);
	
	@Autowired
	private ProjectDao projectDao;
	
	@Before
	public void initDatabaseContent() {
		logger.info("测试ProjectDao, 初始化数据库...");
	}
	
	@After
	public void cleanDatabaseContent() {
		
	}
	
	@Test
	public void testSelectById() {
		logger.info("测试selectById()方法：");
		Project tp1 = projectDao.selectById(1);
		assertProject(tp1, "GPRO_Pyramide", "GPRO and Pyramide Group", "GPRO_Pyramide Group label.", "FJV2", "测试PM1");
	}
	
	@Test
	public void testSelectAll() {
		logger.info("测试selectAll()方法：");
		List<Project> tps = projectDao.selectAll();
		assertEquals(7, tps.size());
		
		Project fp = tps.get(0);
		assertProject(fp, "GPRO_Pyramide", "GPRO and Pyramide Group", "GPRO_Pyramide Group label.", "FJV2", "测试PM1");
	}
	
	/**
	 * 断言一个Project对象是否正确
	 * @param toAssert
	 * @param code
	 * @param fullName
	 * @param label
	 * @param parentCode
	 */
	public void assertProject(Project toAssert, String code, String fullName, String label, String parentCode, String managerCode) {
		assertNotNull(toAssert);
		assertEquals(code, toAssert.getCode());
		assertEquals(fullName, toAssert.getFullName());
		assertEquals(label, toAssert.getLabel());
		if (StringUtils.isNotEmpty(parentCode)) {
			assertNotNull(toAssert.getParent());
			assertEquals(parentCode, toAssert.getParent().getCode());
		} else {
			assertNull(toAssert.getParent());
		}
		
		if (StringUtils.isNotEmpty(managerCode)) {
			assertNotNull(toAssert.getManager());
			assertEquals(managerCode, toAssert.getManager().getName());
		} else {
			assertNull(toAssert.getManager());
		}
		
	}
}
