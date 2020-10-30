package com.biddingplatform.biddingplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biddingplatform.biddingplatform.dao.CardDetailsDAO;
import com.biddingplatform.biddingplatform.models.CardDetails;

@Service
public class CardDetailsService {

	@Autowired
	private CardDetailsDAO cardDetailsDAO;
	
	public int addCardDetails(CardDetails cardDetails) {
		return cardDetailsDAO.addCardDetails(cardDetails);
	}
	
	public List<CardDetails> findCardDetailsByCustomer(int customerId){
		return cardDetailsDAO.findCardDetailsByCustomerId(customerId);
	}
}
