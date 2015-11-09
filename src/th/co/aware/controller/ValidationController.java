package th.co.aware.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import th.co.aware.bean.UserBean;
import th.co.aware.config.MYKEY;
import th.co.aware.config.MYLOG;
import th.co.aware.services.UserService;

@Controller
@RequestMapping("/validate")
public class ValidationController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(
			@ModelAttribute("username")UserBean user,
			HttpServletRequest request
			){
		MYLOG.print(user.getUsername()+" validating...");
		UserBean ub = userService.validate(user.getUsername(), user.getPassword());
		if(ub!=null){
			MYLOG.print(user.getUsername()+" validate success");
			request.getSession().setAttribute(MYKEY.SES_USERLOGIN,ub);
			return "redirect:/";
		}else{
			MYLOG.print(user.getUsername()+" validate fail");
			return "redirect:/login";
		}
	}
}
