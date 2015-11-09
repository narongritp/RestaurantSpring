package th.co.aware.services;

import java.util.List;
import java.util.Map;

import th.co.aware.bean.OrderListBean;

public interface OrderListService {
	public List<OrderListBean> getAllItem();
	public OrderListBean getItem(OrderListBean olb);
	public int addItem(Map<Integer,OrderListBean> listItem);
	public int updateItem(OrderListBean olb);
	public int deleteItem(OrderListBean olb);
}
