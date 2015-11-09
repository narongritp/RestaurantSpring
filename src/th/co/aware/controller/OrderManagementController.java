package th.co.aware.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import th.co.aware.bean.OrderBean;
import th.co.aware.bean.OrderListBean;
import th.co.aware.bean.UserBean;
import th.co.aware.config.MYKEY;
import th.co.aware.services.FoodService;
import th.co.aware.services.OrderListService;
import th.co.aware.services.OrderService;

@Controller
@RequestMapping("/order-manage")
public class OrderManagementController {

	@Autowired
	OrderService orderService;
	@Autowired
	OrderListService orderListService;
	@Autowired
	FoodService foodService;
	
	//view
	@RequestMapping(value="add-order")
	public ModelAndView addOrderPage(HttpServletRequest request,ModelMap mm){
		UserBean user = (UserBean)request.getSession().getAttribute(MYKEY.SES_USERLOGIN);
		if(user.getType().equalsIgnoreCase(MYKEY.USER_WAITRESS)
				||user.getType().equalsIgnoreCase(MYKEY.USER_ADMIN)){
			return new ModelAndView("ro_addOrder",mm);
		}else{
			mm.addAttribute("message", "Error : check permission!");
			return new ModelAndView("errorPage",mm);
		}
	}
	
	@RequestMapping(value="view-listorder")
	public String viewListOrderPage(Model model){
		List<OrderBean> listOrder = orderService.getAllOrder();
		model.addAttribute("listOrder",listOrder);
		return "ro_viewListOrder";
	}
	
	@RequestMapping(value="view-order")
	public ModelAndView viewOrderPage(@RequestParam("order_id")String orderId,ModelMap mm){
		OrderBean order = orderService.getOrderById(Integer.parseInt(orderId));
		mm.addAttribute("order", order);
		return new ModelAndView("ro_viewOrder",mm);
	}
	
	//process
	@RequestMapping(value="addOrder",method=RequestMethod.POST)
	public String addOrder(
			@RequestParam("table")String table,
			@RequestParam("detail")String detail,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		OrderBean order = new OrderBean();
		UserBean user = (UserBean)session.getAttribute(MYKEY.SES_USERLOGIN);
		order.setUserIdOrdering(Integer.parseInt(user.getUserId()+""));
		order.setStatus("W");
		order.setDetail(table+"&"+detail);
		session.setAttribute(MYKEY.SES_ORDER, order);
		
		return "redirect:/food-manage/list-food";
	}
	@RequestMapping(value="commitOrder")
	public String commitOrderDB(HttpServletRequest request,Model model){
		HttpSession session = request.getSession();
		OrderBean order = (OrderBean)session.getAttribute(MYKEY.SES_ORDER);
		Map<Integer,OrderListBean> orderList = (Map<Integer,OrderListBean>)session.getAttribute(MYKEY.SES_ORDERLIST);
		orderService.addOrder(order);
		orderListService.addItem(orderList);
		session.removeAttribute(MYKEY.SES_ORDER);
		session.removeAttribute(MYKEY.SES_ORDERLIST);
		model.addAttribute("order_id", order.getOrderId());
		return "view-order";
	}
	@RequestMapping(value="updateOrder")
	public String updateOrder(@ModelAttribute("order")OrderBean order,Model model){
		orderService.updateOrder(order);
		model.addAttribute("order_id", order.getOrderId());
		return "view-order";
	}
	
	@RequestMapping(value="addItem",method=RequestMethod.GET)
	public String addItem(@RequestParam("food_id")String food_id,
			@RequestParam("amount")String food_amount,
			HttpServletRequest request,ModelMap mm){
		HttpSession session = request.getSession();
		Object objOrder = session.getAttribute(MYKEY.SES_ORDER);
		if(objOrder!=null){
			OrderBean order = (OrderBean)objOrder;
			int foodId = Integer.parseInt(food_id);
			int amount = Integer.parseInt(food_amount);
			Object objItem = session.getAttribute(MYKEY.SES_ORDERLIST);
			if(objItem!=null){
				Map<Integer,OrderListBean> listItem = (Map<Integer,OrderListBean>)objItem;
				if(listItem.get(foodId)!=null){
					OrderListBean orderListBean = listItem.get(foodId);
					orderListBean.setAmount(amount);
					listItem.put(foodId,orderListBean);
				}else{
					int price = foodService.getFoodById(foodId).getPrice();
					listItem.put(foodId, new OrderListBean(-1,foodId,price,amount));
				}
				session.setAttribute(MYKEY.SES_ORDERLIST, listItem);
			}else{
				Map<Integer,OrderListBean> listItem = new HashMap<Integer,OrderListBean>();
				int price = foodService.getFoodById(foodId).getPrice();
				listItem.put(foodId, new OrderListBean(order.getOrderId(),foodId,price,amount));
				session.setAttribute(MYKEY.SES_ORDERLIST, listItem);
			}
			return "redirect:/food-manage/list-food";
		}else{
			mm.addAttribute("message", "Error : invalid order session!");
			return "errorPage";
		}
	}

	
	
}
