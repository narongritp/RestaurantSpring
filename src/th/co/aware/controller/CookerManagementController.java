package th.co.aware.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import th.co.aware.bean.OrderBean;
import th.co.aware.bean.OrderListBean;
import th.co.aware.bean.UserBean;
import th.co.aware.config.MYKEY;
import th.co.aware.config.MYLOG;
import th.co.aware.services.FoodService;
import th.co.aware.services.OrderListService;
import th.co.aware.services.OrderService;

@Controller
@RequestMapping("/cooker")
public class CookerManagementController {

	@Autowired
	OrderService orderService;
	@Autowired
	OrderListService orderListService;
	@Autowired
	FoodService foodService;
	
	@RequestMapping("view-orderlist")
	public ModelAndView viewOrderList(ModelMap model){
		List<OrderBean> allOrder = orderService.getAllOrder("Wait");
		Map<String,List<OrderListBean>> allItem = new HashMap<>();
		for(OrderBean ob : allOrder){
			List<OrderListBean> itemIn = orderListService.getAllItem(ob.getOrderId());
			for(int i=0;i<itemIn.size();i++){
				itemIn.get(i).setFoodName(foodService.getFoodById(itemIn.get(i).getFoodId()).getName());
			}
			allItem.put(ob.getOrderId(), itemIn);
		}
		model.addAttribute("allOrder", allOrder);
		model.addAttribute("allItem", allItem);
		return new ModelAndView("c_viewOrderDetail","model",model);
	}
	
	@RequestMapping("commit")
	public String commitOrder(
			@RequestParam("orderId")String orderId,
			HttpServletRequest request,
			ModelMap mm){
		Object obj = request.getSession().getAttribute(MYKEY.SES_USERLOGIN);
		if(obj!=null){
			UserBean user = (UserBean)obj;
			OrderBean ob = orderService.getOrderById(orderId);
			ob.setUserIdCommit(user.getUserId());
			ob.setStatus("In progress");
			orderService.updateOrder(ob);
			return "redirect:/cooker/view-orderlist";
		}else{
			MYLOG.printError("Error : user session failed!");
			mm.addAttribute("message", "Error : user session failed!");
			return "errorPage";
		}
	}
}
