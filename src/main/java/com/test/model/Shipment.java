package com.test.model;

import java.sql.Date;

public class Shipment {
	private int shipmentId;
	private int orderId;
	private Date date;
	private String customerMobile;
	private String productId;
	private int qty;
	private int amount;
	private Date shipmentDate;
	
	
	public Shipment(int shipment_id, int orderId, Date date, String customer_mobile, String product_id, int qty,
			int amount, Date shipped_date) {
		// TODO Auto-generated constructor stub
		this.shipmentId = shipment_id;
		this.orderId = orderId;
		this.date = date;
		this.customerMobile = customer_mobile;
		this.productId = product_id;
		this.qty = qty;
		this.amount = amount;
		this.shipmentDate = shipped_date;
	}

	public int getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
	public Date getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	

}
