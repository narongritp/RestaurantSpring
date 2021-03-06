package th.co.aware.bean;

import java.text.DecimalFormat;

public class OrderListBean {
	private String orderId;
	private int foodId;
	private int price;
	private int amount;
	private String foodName;
	
	public OrderListBean(){
		
	}
	//constructor
	public OrderListBean(String orderId, int foodId, int price, int amount,String foodName) {
		super();
		this.orderId = orderId;
		this.foodId = foodId;
		this.price = price;
		this.amount = amount;
		this.foodName = foodName;
	}
	//---- another function
	public int getTotalPrice(){
		return price*amount;
	}
	public String getTotalPriceFormat(){
		DecimalFormat df = new DecimalFormat("#,###.00");
		return df.format(price*amount);
	}
	public String getPriceFormat(){
		DecimalFormat df = new DecimalFormat("#,###.00");
		return df.format(price);
	}
	
	//---- setter getter
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
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
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
}
