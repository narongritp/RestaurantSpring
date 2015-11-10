package th.co.aware.services;

import java.util.List;

import th.co.aware.bean.OrderBean;

public interface OrderService {
	public OrderBean addOrder(OrderBean order);
	public int updateOrder(OrderBean order);
	public int cancelOrder(int orderId);
	
	public OrderBean getOrderById(String orderId);
	public List<OrderBean> getAllOrder();
	public List<OrderBean> getAllOrderW();
}
