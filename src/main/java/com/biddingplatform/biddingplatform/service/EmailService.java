package com.biddingplatform.biddingplatform.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.biddingplatform.biddingplatform.models.Product;

@Service
public class EmailService{
	@Autowired
	private JavaMailSender mailSender;
	public void sendEmail(String to,Product product) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
		    message.setSubject("Bid Accepted");
		    message.setFrom("rdjnaresh779@gmail.com	");
		    message.setTo(to);
		    String htmlContent = "<body>";
		    htmlContent+="<div style=\"text-align:center\">\n<h1> Your Bid Accepted</h1>";
		    htmlContent+= "<p>Product Name :"+product.getProductName()+"</p>";
		    htmlContent+= "<p>Description :"+product.getDescription()+"</p>";
		    htmlContent+= "<p>Category :"+product.getCategory()+"</p>";
		    htmlContent+="</div>";
		    htmlContent+="</body>";
		    message.setText(htmlContent, true);
		    mailSender.send(mimeMessage);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public ResponseEntity<Integer> sendEmail(String to,String password) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(to);
		    message.setFrom("rdjnaresh779@gmail.com");
		    message.setSubject("Forgot Password");
		    message.setText("Hey,Thanks for reaching out Us.This is Your password : "+"' "+password+" '");
		    mailSender.send(message);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(1);
	    
	}
}
