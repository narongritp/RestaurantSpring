package th.co.aware.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("print")
	public String printHello(ModelMap model){
		model.addAttribute("message","Hello Spring MVC Framework!");
		return "testpage";
	}
	
	@RequestMapping("remove-session")
	public String removeAllSession(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:/";
	}
}
