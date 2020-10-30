package com.biddingplatform.biddingplatform.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.biddingplatform.biddingplatform.dao.ProductDAO;
import com.biddingplatform.biddingplatform.models.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDao;
	
	Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	public ResponseEntity<Integer> addProduct(Product product){
		try {
			int val = productDao.saveProduct(product);
			return new ResponseEntity<Integer>(val,HttpStatus.OK);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<List<Product>> getAllProducts(int userId){
		try {
			List<Product> val = productDao.getAllAuctionProducts(userId);
			return new ResponseEntity<List<Product>>(val,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<List<Product>> getMyProducts(int userId){
		try {
			List<Product> val = productDao.getMyAuctionProducts(userId);
			return new ResponseEntity<List<Product>>(val,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Product> getProductById(int productId) {
		try {
			Product product = productDao.getProductById(productId);
			return ResponseEntity.ok(product);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Integer> deleteProductById(int productId) {
		try{
			int val = productDao.deleteProductById(productId);
			return ResponseEntity.ok(val);
		}catch (Exception e) {
			logger.info(e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
}
