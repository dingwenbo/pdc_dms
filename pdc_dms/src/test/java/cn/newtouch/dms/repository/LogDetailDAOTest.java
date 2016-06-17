package cn.newtouch.dms.repository;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;
import org.springside.modules.utils.Clock;

import cn.newtouch.dms.constants.EnumTaskStatus;
import cn.newtouch.dms.entity.LogDetail;
import cn.newtouch.dms.entity.Member;
import cn.newtouch.dms.entity.Task;

/**
 * ProjectDAO Junit test.
 * 
 * @author JiaLong.Wang
 *
 */
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class LogDetailDAOTest extends SpringTransactionalTestCase {
	
	private static Log logger = LogFactory.getLog(LogDetailDAOTest.class);
	
	@Autowired
	private LogDetailDao logDetailDao;
	
	@Before
	public void initDatabaseContent() {
		logger.info("测试LogDetailDao, 初始化数据库...");
	}
	
	@Test
	public void testSelectByCondition() {
		LogDetail logDetail = new LogDetail();
		
		logger.info("select all");
		List<LogDetail> logDetails = logDetailDao.selectByCondition(logDetail);
		for (LogDetail logDetail2 : logDetails) {
			System.out.println(logDetail2);
		}
		
		logger.info("select by day");
		logDetail.setDay(Clock.DEFAULT.getCurrentDate());
		logDetails = logDetailDao.selectByCondition(logDetail);
		for (LogDetail logDetail2 : logDetails) {
			System.out.println(logDetail2);
		}
		
		logger.info("select by member id, day");
		Member member = new Member();
		member.setId(9002);
		logDetail.setMember(member);
		
		logDetails = logDetailDao.selectByCondition(logDetail);
		for (LogDetail logDetail2 : logDetails) {
			System.out.println(logDetail2);
		}
		
		logger.info("select by member id, day, task id");
		Task task = new Task();
		task.setId(1);
		logDetail.setTask(task);
		logDetails = logDetailDao.selectByCondition(logDetail);
		for (LogDetail logDetail2 : logDetails) {
			System.out.println(logDetail2);
		}
		
	}
	@Test
	public void testInsert() {
		LogDetail logDetail = new LogDetail();
		logDetail.setDay(Clock.DEFAULT.getCurrentDate());
		Member member = new Member();
		member.setId(9003);
		logDetail.setMember(member);
		Task task = new Task();
		task.setId(2);
		logDetail.setTask(task);
		logDetail.setWorkTime(BigDecimal.ONE);
		logDetailDao.insert(logDetail);
		
		List<LogDetail> logDetails = logDetailDao.selectByCondition(logDetail);
		for (LogDetail logDetail2 : logDetails) {
			System.out.println(logDetail2);
		}
		
	}
}
