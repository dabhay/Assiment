package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bank.model.UserResponse;
import com.bank.request.LoginRequest;
import com.bank.request.SignupRequest;
import com.bank.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/signup")
	public ResponseEntity<UserResponse> sigUp(@RequestBody SignupRequest signUpRequest)
	
	{
		UserResponse userResponse=userservice.signup(signUpRequest);
		
	    return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
	    
	    
	}
	
	@PostMapping("/get")
	public SignupRequest get()
	{
		System.out.println("++++");
		SignupRequest s=new SignupRequest("XYZ",12123,"pass");
		      
		return s;
	}
	
	@PostMapping("/sigin")
	public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginrequest)
	{
		UserResponse userResponse=userservice.login(loginrequest);
		
		return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
	}
	

	

}
