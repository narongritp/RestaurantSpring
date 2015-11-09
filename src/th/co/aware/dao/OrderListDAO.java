package th.co.aware.dao;

import java.util.List;

import th.co.aware.bean.OrderListBean;

public interface OrderListDAO {
	public List<OrderListBean> getAllItem();
	public OrderListBean getItem(OrderListBean olb);
	public int addItem(OrderListBean olb);
	public int updateItem(OrderListBean olb);
	public int deleteItem(OrderListBean olb);
	
}
