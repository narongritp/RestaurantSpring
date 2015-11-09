package th.co.aware.services;

import java.util.List;

import th.co.aware.bean.OrderBean;

public interface OrderService {
	public OrderBean addOrder(OrderBean order);
	public int updateOrder(OrderBean order);
	public int cancelOrder(int orderId);
	
	public OrderBean getOrderById(int orderId);
	public List<OrderBean> getAllOrder();
}
