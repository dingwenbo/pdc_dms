package cn.newtouch.dms.repository;

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
	
	
}
