package com.biddingplatform.biddingplatform.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.biddingplatform.biddingplatform.dao.OrderDAO;
import com.biddingplatform.biddingplatform.models.Order;

@Service
public class OrdersService {

	@Autowired
	private OrderDAO ordersDao;
	
	@Autowired
	private ProductService productsService;
	
	Logger log = LoggerFactory.getLogger(OrdersService.class);
	
	public ResponseEntity<Integer> addOrders(Order order) {
		try {
			int val = ordersDao.addOrder(order);
			log.info("Outside If : "+String.valueOf(val));
			if(val==1)
			{
				val = productsService.deleteProductById(order.getProductId()).getBody();
				log.info(String.valueOf(val));
			}
			return new ResponseEntity<Integer>(val,HttpStatus.OK);
		}catch (Exception e) {
			log.info(e.getMessage());
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<List<Order>> getPlacedOrders(int customerId){
		try{
			List<Order> orders = ordersDao.getPlacedOrders(customerId);
			return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<List<Order>> getReceivedOrders(int sellerId){
		try{
			List<Order> orders = ordersDao.getReceivedOrders(sellerId);
			return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<List<Order>> getSortedOrders(String sortType,int customerId){
		try{
			List<Order> orders = ordersDao.getSortedOrders(sortType, customerId);
			return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
		}
	}
}
