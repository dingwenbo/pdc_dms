package cn.newtouch.dms.service;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cn.newtouch.dms.repository.ProjectDao;

/**
 * Project Service的单元测试
 * @author JiaLong.Wang
 *
 */
public class ProjectServiceTest {
	
	@InjectMocks
	private ProjectService projectService;

	@Mock
	private ProjectDao projectDao;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
}
