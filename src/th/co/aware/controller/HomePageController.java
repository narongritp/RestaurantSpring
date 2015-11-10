package th.co.aware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import th.co.aware.bean.UserBean;

@Controller
public class HomePageController {
	
	@RequestMapping("/")
	public ModelAndView indexPage(){
		return new ModelAndView("index");
	}
	
	@RequestMapping("/login")
	public ModelAndView loginPage(ModelMap mm){
		UserBean user = new UserBean();
		user.setUsername("cooker");
		user.setPassword("8608");
		mm.addAttribute("user", user);
		return new ModelAndView("login",mm);
	}
}
