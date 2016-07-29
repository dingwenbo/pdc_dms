package cn.newtouch.dms.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
@ContextConfiguration(locations = { "/applicationContext.xml" })
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
		Project test = projectDao.selectById(1);
		System.out.println(test.getCode());
	}
	
	@Test
	public void testSelectAll() {
		List<Project> tps = projectDao.selectAll();
		assertEquals(7, tps.size());
		
		Project fp = tps.get(0);
		assertEquals("GPRO_Pyramide", fp.getCode());
		assertEquals("FJV2", fp.getParent().getCode());
		assertEquals("GPRO and Pyramide Group", fp.getFullName());
		assertEquals("GPRO_Pyramide Group label.", fp.getLabel());
	}
}
