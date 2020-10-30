package com.biddingplatform.biddingplatform.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.biddingplatform.biddingplatform.dao.BidDAO;
import com.biddingplatform.biddingplatform.models.Bid;

@Service
public class BidService {
	@Autowired
	private BidDAO bidsDao;
	
	Logger logger = LoggerFactory.getLogger(BidService.class);
	
	public ResponseEntity<Integer> addBid(Bid bid) {
//		try {
//			int returnVal = bidsDao.addBid(bid);
//			return ResponseEntity.ok(returnVal);
//		}catch (Exception e) {
//			logger.error(e.getLocalizedMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
		bidsDao.addBid(bid);
		return ResponseEntity.ok(1);
	}
	
	public ResponseEntity<List<Bid>> getPlacedBids(int id){
		try{
			List<Bid> bids = bidsDao.getPlacedBids(id);
			return ResponseEntity.ok(bids);
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<List<Bid>> getReceivedBids(int id){
		try{
			List<Bid> bids = bidsDao.getReceivedBids(id);
			return ResponseEntity.ok(bids);
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Integer> acceptBid(int bidId) {
		try {
			int returnVal = bidsDao.acceptBid(bidId);
			return ResponseEntity.ok(returnVal);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	public ResponseEntity<Bid> getBidByBidId(int bidId) {
		try {
			Bid bid = bidsDao.getBidByBidId(bidId);
			return ResponseEntity.ok(bid);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
