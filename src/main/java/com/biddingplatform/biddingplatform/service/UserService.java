package com.biddingplatform.biddingplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.biddingplatform.biddingplatform.dao.UserDAO;
import com.biddingplatform.biddingplatform.models.User;

@Service
public class UserService{

    @Autowired
    private UserDAO userRepository;
    

    public ResponseEntity<Boolean> insertUser(User user) {
        if(userRepository.findUserByUsername(user.getUserName())==null && userRepository.findUserByEmail(user.getEmail())==null){
            try {
            	userRepository.registerUser(user);
                return ResponseEntity.ok(true);
            }catch(Exception e) {
            	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        };
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    
    public ResponseEntity<Integer> getUserIdByUserName(String username) {
    	try{
    		int returnVal = userRepository.findUserIdByUserName(username);
    		return new ResponseEntity<Integer>(returnVal,HttpStatus.OK);    	
    	}catch(Exception e) {
    			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    }
    
	 public ResponseEntity<String> getUsername(int uid) { 
		 try{
			 String name = userRepository.getUserName(uid);
			 return ResponseEntity.ok(name);
		 }catch(Exception e) {
			 return ResponseEntity.notFound().build();
		 }
	}
	 
	public ResponseEntity<User> forgotPassword(String username) {
		try{
    		User user = userRepository.findUserByUsername(username);
    		return new ResponseEntity<User>(user,HttpStatus.OK);    	
    	}catch(Exception e) {
    			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
	}
	
	public ResponseEntity<String> getEmailById(int id) {
		try{
			 String email = userRepository.getEmailById(id);
			 return ResponseEntity.ok(email);
		 }catch(Exception e) {
			 return ResponseEntity.notFound().build();
		 }
	}
	 
	public ResponseEntity<User> getUserDetails(int id) {
		try{
			User user = userRepository.getUserDetails(id);
			return ResponseEntity.ok(user);
		 }catch(Exception e) {
			 return ResponseEntity.notFound().build();
		 }
	}
	
	public ResponseEntity<User> findUserByUsername(String username) {
		try{
			User user = userRepository.findUserByUsername(username);
			return ResponseEntity.ok(user);
		 }catch(Exception e) {
			 return ResponseEntity.notFound().build();
		 }
	}
}
