package cn.newtouch.dms.web.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * 日志管理控制器
 * 
 * @author JiaLong Wang
 *
 */
@Controller
@RequestMapping(value = "/log")
public class LogController {
	
	/** logger. */
    private static final Log LOGGER = LogFactory.getLog(LogController.class);
	
	@RequestMapping(value="timesheet")
	public String toTimesheet() {
		return "log/timesheet";
	}
}
