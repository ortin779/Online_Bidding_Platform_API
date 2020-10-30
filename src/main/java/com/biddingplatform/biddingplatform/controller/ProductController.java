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

import com.biddingplatform.biddingplatform.models.Product;
import com.biddingplatform.biddingplatform.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productsService;
	
	@PostMapping("/add")
	public ResponseEntity<Integer> addProduct(@RequestBody Product product) {
		return productsService.addProduct(product);
	}
	
	@GetMapping("/all/{userid}")
	public ResponseEntity<List<Product>> getAllAuctionedProducts(@PathVariable("userid") int userId){
		return productsService.getAllProducts(userId);
	}
	
	
	@GetMapping("/my/{userid}")
	public ResponseEntity<List<Product>> getMyProducts(@PathVariable("userid") int userId){
		return productsService.getMyProducts(userId);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductByProductId(@PathVariable("id") int productId) {
		return productsService.getProductById(productId);
	}
}
