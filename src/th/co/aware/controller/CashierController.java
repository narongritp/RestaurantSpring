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
@RequestMapping("/cashier")
public class CashierController {
	
	@Autowired
	OrderService orderService;
	@Autowired
	OrderListService orderListService;
	@Autowired
	FoodService foodService;
	
	@RequestMapping("view-orderlist")
	public ModelAndView viewOrder(ModelMap model){
		List<OrderBean> allOrderServed = orderService.getAllOrder("Served");
		Map<String,List<OrderListBean>> allItemServed = new HashMap<>();
		for(OrderBean ob : allOrderServed){
			List<OrderListBean> itemIn = orderListService.getAllItem(ob.getOrderId());
			for(int i=0;i<itemIn.size();i++){
				itemIn.get(i).setFoodName(foodService.getFoodById(itemIn.get(i).getFoodId()).getName());
			}
			allItemServed.put(ob.getOrderId(), itemIn);
		}
		List<OrderBean> allOrderCheck = orderService.getAllOrder("Checked out");
		Map<String,List<OrderListBean>> allItemCheck = new HashMap<>();
		for(OrderBean ob : allOrderCheck){
			List<OrderListBean> itemIn = orderListService.getAllItem(ob.getOrderId());
			for(int i=0;i<itemIn.size();i++){
				itemIn.get(i).setFoodName(foodService.getFoodById(itemIn.get(i).getFoodId()).getName());
			}
			allItemCheck.put(ob.getOrderId(), itemIn);
		}
		model.addAttribute("allOrderServed", allOrderServed);
		model.addAttribute("allItemServed", allItemServed);
		model.addAttribute("allOrderCheck", allOrderCheck);
		model.addAttribute("allItemCheck", allItemCheck);
		return new ModelAndView("cash_viewOrderDetail","model",model);
	}
	
	@RequestMapping("checkout-detail")
	public String checkoutPage(@RequestParam("orderId")String orderId,ModelMap mm){
		OrderBean order = orderService.getOrderById(orderId);
		List<OrderListBean> allItem = orderListService.getAllItem(order.getOrderId());
		mm.put("order", order);
		mm.put("allItem", allItem);
		return "cash_prepareCheckout";
	}
	
	@RequestMapping("checkout")
	public String checkoutOrder(
			@RequestParam("orderId")String orderId,
			HttpServletRequest request,
			ModelMap mm){
		Object obj = request.getSession().getAttribute(MYKEY.SES_USERLOGIN);
		if(obj!=null){
			UserBean user = (UserBean)obj;
			OrderBean ob = orderService.getOrderById(orderId);
			ob.setUserIdCommit(user.getUserId());
			ob.setStatus("Checked out");
			orderService.updateOrder(ob);
			return "redirect:/cashier/view-orderlist";
		}else{
			MYLOG.printError("Error : user session failed!");
			mm.addAttribute("message", "Error : user session failed!");
			return "errorPage";
		}
	}

}
