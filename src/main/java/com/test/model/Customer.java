package com.test.model;

public class Customer {
	private String cusName;
	private String cusAddress;
	private String cusMobile;
	private String cusPass;
	public Customer(String cusName, String cusAddress, String cusMobile, String cusPass) {
		super();
		this.cusName = cusName;
		this.cusAddress = cusAddress;
		this.cusMobile = cusMobile;
		this.cusPass = cusPass;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	public String getCusMobile() {
		return cusMobile;
	}
	public void setCusMobile(String cusMobile) {
		this.cusMobile = cusMobile;
	}
	public String getCusPass() {
		return cusPass;
	}
	public void setCusPass(String cusPass) {
		this.cusPass = cusPass;
	}
	
	

}
