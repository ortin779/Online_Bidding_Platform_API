package com.biddingplatform.biddingplatform.models;

import java.sql.Date;

public class Order {
	private int orderId;
	private Date orderDate;
	private int productId;
	private String productName;
	private String productImage;
	private String category;
	private float price;
	private int customerId;
	private int sellerId;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, Date orderDate, int productId, String productName, String productImage, String category,
			float price, int customerId, int sellerId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.category = category;
		this.price = price;
		this.customerId = customerId;
		this.sellerId = sellerId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
	
	
}
