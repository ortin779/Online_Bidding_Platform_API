package com.biddingplatform.biddingplatform.models;

public class Product {

	private int productId;
	private String productName;
	private String description;
	private float initialBid;
	private String image;
	private String category;
	private int sellerId;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, String description, float initialBid, String image,
			String category, int sellerId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.initialBid = initialBid;
		this.image = image;
		this.category = category;
		this.sellerId = sellerId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getInitialBid() {
		return initialBid;
	}

	public void setInitialBid(float initialBid) {
		this.initialBid = initialBid;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", initialBid=" + initialBid + ", image=" + image + ", category=" + category + ", sellerId="
				+ sellerId + "]";
	}
	
}
