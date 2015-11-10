package th.co.aware.services;

import java.util.List;
import java.util.Map;

import th.co.aware.bean.OrderListBean;

public interface OrderListService {
	public List<OrderListBean> getAllItem(String orderId);
	public OrderListBean getItem(OrderListBean olb);
	public int addItem(Map<Integer,OrderListBean> listItem,String orderId);
	public int updateItem(OrderListBean olb);
	public int deleteItem(OrderListBean olb);
}
