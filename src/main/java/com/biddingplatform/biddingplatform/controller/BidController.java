package com.biddingplatform.biddingplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biddingplatform.biddingplatform.models.Bid;
import com.biddingplatform.biddingplatform.models.Product;
import com.biddingplatform.biddingplatform.models.User;
import com.biddingplatform.biddingplatform.service.BidService;
import com.biddingplatform.biddingplatform.service.EmailService;
import com.biddingplatform.biddingplatform.service.ProductService;
import com.biddingplatform.biddingplatform.service.UserService;

@RestController
@RequestMapping("bid")
@CrossOrigin("*")
public class BidController {
	
	@Autowired
	private BidService bidsService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;	
	
	
	@PostMapping("/add")
	public ResponseEntity<Integer> addBid(@RequestBody Bid bid) {
		return bidsService.addBid(bid);
	}
	
	@GetMapping("/placed/{id}")
	public ResponseEntity<List<Bid>> getPlacedBids(@PathVariable("id") int id){
		return bidsService.getPlacedBids(id);
	}
	
	@GetMapping("/received/{id}")
	public ResponseEntity<List<Bid>> getReceivedBids(@PathVariable("id") int id){
		return bidsService.getReceivedBids(id);
	}
	
	@PostMapping("/accept/{id}")
	public ResponseEntity<Integer> acceptBid(@PathVariable("id") int bidId) {
		try{
			if(bidsService.acceptBid(bidId).getBody()==1) {
				try {
					Bid bid = bidsService.getBidByBidId(bidId).getBody();
					User user = userService.getUserDetails(bid.getCustomerId()).getBody();
					Product product = productService.getProductById(bid.getProductId()).getBody();
					emailService.sendEmail(user.getEmail(), product);
					return ResponseEntity.ok(1);
				}catch (Exception e) {
					return ResponseEntity.notFound().build();
				}
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Bid> getBidByBidId(@PathVariable("id") int id) {
		return bidsService.getBidByBidId(id);
	}
}
