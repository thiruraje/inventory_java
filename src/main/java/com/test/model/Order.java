package com.test.model;

import java.sql.Date;

public class Order {
	
	private String customerMobile;
	private String productId;
	private int orderId;
	private int qty;
	private int amount;
	private Date date;
	public Order(String customerMobile, String productId, int orderId, int qty, int amount, Date date) {
		super();
		this.customerMobile = customerMobile;
		this.productId = productId;
		this.orderId = orderId;
		this.qty = qty;
		this.amount = amount;
		this.date = date;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	
	

}
