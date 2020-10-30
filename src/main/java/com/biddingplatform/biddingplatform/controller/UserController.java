package com.biddingplatform.biddingplatform.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biddingplatform.biddingplatform.models.User;
import com.biddingplatform.biddingplatform.service.EmailService;
import com.biddingplatform.biddingplatform.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private EmailService emailService;
    
    Logger log = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/register")
    public ResponseEntity<Boolean> registerUser(@RequestBody User user){
        return userService.insertUser(user);
    }
    
    @GetMapping("/login")
    public void loginUser(){
    	
    }

    @GetMapping("/{uname}")
    public ResponseEntity<Integer> getUserId(@PathVariable("uname") String username) {
    	return userService.getUserIdByUserName(username);
    }
    
	
	  @GetMapping("/username/{uid}") 
	public ResponseEntity<String> getUsername(@PathVariable("uid") int uid) {
		  return userService.getUsername(uid);
	}
	  
	@GetMapping("/forgot/{username}")
	public ResponseEntity<Integer> forgotPassword(@PathVariable("username") String username) {
		User user = userService.forgotPassword(username).getBody();
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		log.info(user.getEmail());
		return emailService.sendEmail(user.getEmail(), user.getPassword());
	}
	
	@GetMapping("/details/{id}")
	public ResponseEntity<User> getUserDetails(@PathVariable("id") int id) {
		return userService.getUserDetails(id);
	}
}

