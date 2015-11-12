package th.co.aware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import th.co.aware.bean.FoodBean;
import th.co.aware.bean.UserBean;
import th.co.aware.config.MYLOG;
import th.co.aware.services.FoodService;
import th.co.aware.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	FoodService foodService;
	@Autowired
	UserService userService;
	
	
	@RequestMapping("manage-user")
	public ModelAndView viewListUser(ModelMap mm){
		List<UserBean> allUser = userService.getAll();
		mm.addAttribute("userList", allUser);
		return new ModelAndView("admin_listUser");
	}
	@RequestMapping("terminate-user")
	public String updateUserPage(
			@RequestParam("userId")String userId,
			ModelMap mm
			){
		userService.teminateUser(Integer.parseInt(userId));
		return "redirect:/admin/manage-user";
	}
	
	@RequestMapping("manage-foodmenu")
	public ModelAndView viewListFood(ModelMap mm){
		List<FoodBean> allFood = foodService.getAllFood();
		List<String> listType = foodService.getFoodType();
		mm.addAttribute("list", allFood);
		mm.addAttribute("type", listType);
		return new ModelAndView("admin_listFood",mm);
	}
	
	@RequestMapping("manage-foodmenu/search")
	public ModelAndView viewList(@RequestParam("type")String type,ModelMap mm){
		List<String> listType = foodService.getFoodType();
		List<FoodBean> foodByType = foodService.getFoodByType(type);
		mm.addAttribute("list", foodByType);
		mm.addAttribute("type", listType);
		mm.addAttribute("typeSelect", type);
		return new ModelAndView("admin_listFood",mm);
	}
	
	@RequestMapping("add-food")
	public ModelAndView addFoodPage(ModelMap mm){
		List<String> listType = foodService.getFoodType();
		mm.addAttribute("type", listType);
		mm.addAttribute("food", new FoodBean());
		return new ModelAndView("admin_addFood","model",mm);
	}
	
	@RequestMapping(value="addFood",method=RequestMethod.POST)
	public String addFood(@ModelAttribute("food")FoodBean food,ModelMap mm){
		if(foodService.addFood(food)==1){
			return "redirect:/admin/manage-foodmenu";
		}else{
			MYLOG.printError("Error : invalid order session!");
			mm.addAttribute("message", "Error : invalid order session!");
			return "errorPage";
		}
	}
	
	@RequestMapping(value="deleteFood")
	public String deleteFood(@RequestParam("foodId")String foodId,ModelMap mm){
		if(foodService.deleteFood(Integer.parseInt(foodId))==1){
			return "redirect:/manage-foodmenu";
		}else{
			MYLOG.printError("Error : invalid order session!");
			mm.addAttribute("message", "Error : invalid order session!");
			return "errorPage";
		}
	}
}
