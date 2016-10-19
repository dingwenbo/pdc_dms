package cn.newtouch.dms.web.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {
	
	@RequestMapping(value = "showAbout", method = RequestMethod.GET)
	public String showAbout() {
		return "about";
	}
	
	@RequestMapping(value = "showHomePage", method = RequestMethod.GET)
	public String showHomePage() {
		return "homePage";
	}
}
