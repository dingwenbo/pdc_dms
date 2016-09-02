package cn.newtouch.dms.web.login;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.newtouch.dms.shiro.ShiroUser;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)， 真正登录的POST请求由Filter完成,
 * 
 * @author JiaLong.Wang
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    /** logger. */
    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    /**
     * 进入登陆页面. 如果已登陆，则进入主页.
     * 
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        Subject currentUser = SecurityUtils.getSubject();
        clearURL(currentUser);

        if (currentUser.isAuthenticated()) {
            return "redirect:/login/success";
        }
        return "login";
    }

    /**
     * Clear url.
     *
     * @param subject the subject
     */
    private void clearURL(Subject subject) {
        Session session = subject.getSession(false);
        if (session != null) {
            session.removeAttribute(WebUtils.SAVED_REQUEST_KEY);
        }
    }

    /**
     * 用户鉴权失败后，调用该方法。
     * 
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
        LOGGER.info("用户[" + userName + "] 尝试登陆系统失败!");
        return login();
    }

    /**
     * 鉴权成功，跳转到主页面
     * 
     * @return
     */
    @RequestMapping(value = "/success")
    public String success() {
        Subject currentUser = SecurityUtils.getSubject();
        ShiroUser userInfo = (ShiroUser) currentUser.getPrincipal();
        LOGGER.info("用户 " + userInfo.getPdcId() + "[" + userInfo.getName() + "]  登陆系统...");
        return "menu";
    }
}
