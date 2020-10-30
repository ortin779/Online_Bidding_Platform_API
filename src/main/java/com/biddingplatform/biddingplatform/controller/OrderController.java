package com.biddingplatform.biddingplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biddingplatform.biddingplatform.models.Order;
import com.biddingplatform.biddingplatform.service.OrdersService;

@RestController
@RequestMapping("order")
@CrossOrigin("*")
public class OrderController {
	
	@Autowired
	private OrdersService orderService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Integer> addOrder(@RequestBody Order order) {
		return orderService.addOrders(order);
	}
	
	@GetMapping("/placed/{id}")
	public ResponseEntity<List<Order>> getPlacedOrders(@PathVariable("id")int customerId){
		return orderService.getPlacedOrders(customerId);
	}
	
	@GetMapping("/received/{id}")
	public ResponseEntity<List<Order>> getReceivedOrders(@PathVariable("id")int sellerId){
		return orderService.getReceivedOrders(sellerId);
	}
	
	@GetMapping("/placed/{sortType}/{id}")
	public ResponseEntity<List<Order>> getSortedOrders(@PathVariable("id") int customerId,@PathVariable("sortType")String by){
		return orderService.getSortedOrders(by, customerId);
	}
}
