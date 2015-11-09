package th.co.aware.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import th.co.aware.bean.FoodBean;
import th.co.aware.config.MYLOG;
import th.co.aware.services.FoodService;

@Controller
@RequestMapping("/food-manage")
public class FoodManagementController {
	
	@Autowired
	FoodService foodService;
	
	@RequestMapping("/list-food")
	public ModelAndView getListFoodPage(){
		List<FoodBean> listFood = foodService.getAllFood();
		MYLOG.print("list food size is "+listFood.size());
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("listFood", listFood);
		return new ModelAndView("ro_listFood", map);
	}
	
	@RequestMapping("/detail-food")
	public String getFoodPage(@RequestParam String foodId,Model mm){
		FoodBean fb = foodService.getFoodById(Integer.parseInt(foodId));
		mm.addAttribute("food", fb);
		MYLOG.print(fb.getFoodId()+" "+fb.getName());
		return "ro_detailFood";
	}
	
	
}
