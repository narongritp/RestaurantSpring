package th.co.aware.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import th.co.aware.bean.OrderBean;
import th.co.aware.dao.OrderDAO;

public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public OrderBean addOrder(OrderBean order) {
		return orderDAO.addOrder(order);
	}

	@Override
	public int updateOrder(OrderBean order) {
		return orderDAO.updateOrder(order);
	}

	@Override
	public int cancelOrder(int orderId) {
		return orderDAO.cancelOrder(orderId);
	}

	@Override
	public OrderBean getOrderById(String orderId) {
		return orderDAO.getOrderById(orderId);
	}

	@Override
	public List<OrderBean> getAllOrder() {
		return orderDAO.getAllOrder();
	}

	@Override
	public List<OrderBean> getAllOrderW() {
		return orderDAO.getAllOrderW();
	}

}
