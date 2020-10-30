package com.biddingplatform.biddingplatform.models;

public class Bid {
	
	private int bidId;
	private float bidValue;
	private int productId;
	private int customerId;
	private int bidStatus;
	public Bid() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bid(int bidId, float bidValue, int productId, int customerId, int bidStatus) {
		super();
		this.bidId = bidId;
		this.bidValue = bidValue;
		this.productId = productId;
		this.customerId = customerId;
		this.bidStatus = bidStatus;
	}
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public float getBidValue() {
		return bidValue;
	}
	public void setBidValue(float bidValue) {
		this.bidValue = bidValue;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(int bidStatus) {
		this.bidStatus = bidStatus;
	}
	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", bidValue=" + bidValue + ", productId=" + productId + ", customerId="
				+ customerId + ", bidStatus=" + bidStatus + "]";
	}
	
	
	
}
