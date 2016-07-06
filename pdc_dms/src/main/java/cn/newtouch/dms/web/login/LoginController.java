package cn.newtouch.dms.web.login;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 * 
 * 真正登录的POST请求由Filter完成,
 * 
 * @author JiaLong.Wang
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	/** logger. */
    private static final Log LOGGER = LogFactory.getLog(LoginController.class);
    
	@RequestMapping(method =  RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		LOGGER.info("用户[" + userName + "] 尝试登陆系统失败!");
		return "login";
	}
	
	@RequestMapping("/success")
	public String success() {
	    return "menu";
	}

}
