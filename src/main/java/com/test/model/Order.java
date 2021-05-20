package com.test.model;

public class Order {
	
	private int customerId;
	private int productId;
	private int orderId;
	private int qty;
	private int amount;
	public Order(int customerId, int productId, int orderId, int qty, int amount) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.orderId = orderId;
		this.qty = qty;
		this.amount = amount;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
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
	
	

}
