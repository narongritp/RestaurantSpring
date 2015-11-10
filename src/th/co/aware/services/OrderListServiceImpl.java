package th.co.aware.services;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import th.co.aware.bean.OrderListBean;
import th.co.aware.dao.OrderListDAO;

public class OrderListServiceImpl implements OrderListService{
	
	@Autowired
	OrderListDAO orderListDAO;

	@Override
	public List<OrderListBean> getAllItem(String orderId) {
		return orderListDAO.getAllItem(orderId);
	}

	@Override
	public OrderListBean getItem(OrderListBean olb) {
		return orderListDAO.getItem(olb);
	}

	@Override
	public int addItem(Map<Integer, OrderListBean> listItem,String orderId) {
		
		
		Set<Integer> foodIds = listItem.keySet();
		for (Iterator iterator = foodIds.iterator(); iterator.hasNext();) {
			Integer foodId = (Integer) iterator.next();
			OrderListBean orderListBean = listItem.get(foodId);
			orderListBean.setOrderId(orderId);
			orderListDAO.addItem(orderListBean);
		}
		return 1;
	}
	
	@Override
	public int updateItem(OrderListBean olb) {
		return orderListDAO.updateItem(olb);
	}

	@Override
	public int deleteItem(OrderListBean olb) {
		return orderListDAO.deleteItem(olb);
	}

	
	
	
}
