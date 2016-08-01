package cn.newtouch.dms.web.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "timesheet")
	public String toTimesheet() {
		return "log/timesheet";
	}
	
	@RequestMapping(value = "getTimeSheetData")
	@ResponseBody
	public String getTimeSheetData() {
		// 得到当前用户的pdc_id.
		return "";
	}
}
