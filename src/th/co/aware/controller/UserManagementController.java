package th.co.aware.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import th.co.aware.bean.UserBean;
import th.co.aware.config.MYKEY;
import th.co.aware.services.UserService;

@Controller
@RequestMapping("/user-manage")
public class UserManagementController {
	
	@Autowired
	UserService userService;
	
	//View
	@RequestMapping(value="create-user")
	public ModelAndView createUserPage(@ModelAttribute("user") UserBean user,ModelMap mm){
		List<String> position = new ArrayList<String>();
		position.add("Select...");
		position.add("Waitress");
		position.add("Cooker");
		position.add("Recieve orders");
		position.add("Administrator");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("position", position);
		
		//--
		Object message = mm.get(MYKEY.MESSAGE);
		if(message!=null){
			map.put(MYKEY.MESSAGE, message);
		}else{
			map.put(MYKEY.MESSAGE, "");
		}
		//--
		return new ModelAndView("admin_createUser","map",map);
	}
	
	
	
//==//Process ============================================================================
	@RequestMapping(value="createUser",method=RequestMethod.POST)
	public String createUser(@ModelAttribute("user")UserBean user, ModelMap mm){
		if(userService.createUser(user)==1){
			mm.addAttribute("user", user);
			return "admin_resultNewUser";
		}else{
			mm.addAttribute(MYKEY.MESSAGE,"Error: try again!");
			return "redirect:/user-manage/create-user";
		}
	}

}
