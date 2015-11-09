package th.co.aware.bean;

public class OrderListBean {
	private int orderId;
	private int foodId;
	private int price;
	private int amount;
	
	public OrderListBean(){
		
	}
	//constructor
	public OrderListBean(int orderId, int foodId, int price, int amount) {
		super();
		this.orderId = orderId;
		this.foodId = foodId;
		this.price = price;
		this.amount = amount;
	}
	//---- another function
	public int getTotalPrice(){
		return price*amount;
	}
	
	//---- setter getter
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
