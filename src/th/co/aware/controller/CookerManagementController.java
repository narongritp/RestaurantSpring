package th.co.aware.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import th.co.aware.bean.OrderBean;
import th.co.aware.bean.OrderListBean;
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
		List<OrderBean> allOrder = orderService.getAllOrderW();
		Map<String,List<OrderListBean>> allItem = new HashMap<>();
		for(OrderBean ob : allOrder){
			List<OrderListBean> itemIn = orderListService.getAllItem(ob.getOrderId());
			allItem.put(ob.getOrderId(), itemIn);
		}
		model.addAttribute("allOrder", allOrder);
		model.addAttribute("allItem", allItem);
		return new ModelAndView("c_viewOrderDetail","data",model);
	}
}
