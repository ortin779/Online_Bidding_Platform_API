package com.biddingplatform.biddingplatform.models;

public class CardDetails {

	private int cardId;
	private String cardHolder;
	private long cardNumber;
	private int month;
	private int year;
	private int customerId;
	private int cvv;
	public CardDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardDetails(int cardId, String cardHolder, long cardNumber, int month, int year, int customerId, int cvv) {
		super();
		this.cardId = cardId;
		this.cardHolder = cardHolder;
		this.cardNumber = cardNumber;
		this.month = month;
		this.year = year;
		this.customerId = customerId;
		this.cvv = cvv;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "CardDetails [cardId=" + cardId + ", cardHolder=" + cardHolder + ", cardNumber=" + cardNumber
				+ ", month=" + month + ", year=" + year + ", customerId=" + customerId + ", cvv=" + cvv + "]";
	}
	
}
