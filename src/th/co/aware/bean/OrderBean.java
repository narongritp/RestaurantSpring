package th.co.aware.bean;

import java.sql.Date;

public class OrderBean {
	private int orderId;
	private int userIdOrdering;
	private int userIdCommit;
	private String detail;
	private String status;
	private Date orderDate;
	private Date commitDate;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserIdOrdering() {
		return userIdOrdering;
	}
	public void setUserIdOrdering(int userIdOrdering) {
		this.userIdOrdering = userIdOrdering;
	}
	public int getUserIdCommit() {
		return userIdCommit;
	}
	public void setUserIdCommit(int userIdCommit) {
		this.userIdCommit = userIdCommit;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getCommitDate() {
		return commitDate;
	}
	public void setCommitDate(Date checkDate) {
		this.commitDate = checkDate;
	}
	
}
