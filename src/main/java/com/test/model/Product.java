package com.test.model;

public class Product {
	private String proName;
	private String proCategory;
	private String proColor;
	private String proId;
	private String proImg;
	private String proRate;
	private String proDes;
	private int proQty;
	public Product(String proName, String proCategory, String proColor, String proId, String proImg, String proRate,
			String proDes, int proQty) {
		super();
		this.proName = proName;
		this.proCategory = proCategory;
		this.proColor = proColor;
		this.proId = proId;
		this.proImg = proImg;
		this.proRate = proRate;
		this.proDes = proDes;
		this.proQty = proQty;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProCategory() {
		return proCategory;
	}
	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}
	public String getProColor() {
		return proColor;
	}
	public void setProColor(String proColor) {
		this.proColor = proColor;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProImg() {
		return proImg;
	}
	public void setProImg(String proImg) {
		this.proImg = proImg;
	}
	public String getProRate() {
		return proRate;
	}
	public void setProRate(String proRate) {
		this.proRate = proRate;
	}
	public String getProDes() {
		return proDes;
	}
	public void setProDes(String proDes) {
		this.proDes = proDes;
	}
	public int getProQty() {
		return proQty;
	}
	public void setProQty(int proQty) {
		this.proQty = proQty;
	}
	
	


}
