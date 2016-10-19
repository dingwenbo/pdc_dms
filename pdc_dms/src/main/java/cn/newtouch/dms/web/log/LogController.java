package cn.newtouch.dms.web.log;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.newtouch.dms.json.JsonUtils;
import cn.newtouch.dms.vo.log.TimeSheetVO;

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
    private static Log logger = LogFactory.getLog(LogController.class);
	
	@RequestMapping(value = "timesheet")
	public String toTimesheet() {
		return "log/timesheet";
	}
	
	@RequestMapping(value = "getTimeSheetData")
	@ResponseBody
	public String getTimeSheetData() {
		// 得到当前用户的pdc_id.
		
		//TODO: 测试数据，to Delete.
		TimeSheetVO ts1 = new TimeSheetVO();
		ts1.setId(1);
		ts1.setTask("Test 01");
		ts1.setTue("1");
		ts1.setWed("0.5");
		ts1.setThu("1");
		
		TimeSheetVO ts2 = new TimeSheetVO();
		ts2.setId(2);
		ts2.setTask("Test 02");
		ts2.setMon("1");
		ts2.setWed("0.5");
		ts2.setFri("0.5");
	
		List<TimeSheetVO> result = new ArrayList<TimeSheetVO>();
		result.add(ts1);
		result.add(ts2);
		logger.debug(result);
		return JsonUtils.writeObject(result);
	}
	
	public String refresh() {
		//TODO:
		return null;
	}
}
