package com.bank.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bank.jwt.JwtUtil;
import com.bank.model.AccountDetails;
import com.bank.model.FundTransfer;
import com.bank.model.Transaction;
import com.bank.model.UserResponse;
import com.bank.repository.UserRepository;
import com.bank.request.LoginRequest;
import com.bank.request.SignupRequest;
import com.bank.service.AccountService;
import com.bank.service.TransactionService;
import com.bank.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionService transactionservice;
	
	@Autowired
	private AccountService accountService;
	

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/signup")
	public ResponseEntity<UserResponse> sigUp(@RequestBody SignupRequest signUpRequest)

	{
		UserResponse userResponse = userservice.signup(signUpRequest);

		return ResponseEntity.status(userResponse.getStatus()).body(userResponse);

	}

	@PostMapping("/signin")
	public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginrequest) {
		UserResponse userResponse = userservice.login(loginrequest);

		return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
	}

	@GetMapping("/api")
	public ResponseEntity<UserResponse> Api(@RequestHeader(value = "Authorization", defaultValue = "") String auth)
			throws Exception {
		UserResponse userResponse = new UserResponse();
		jwtUtil.verify(auth);
		userResponse.setData("api");
		return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
	}

	@PostMapping("/fundtransfer")
	public ResponseEntity<UserResponse> fundTransfer(HttpServletRequest req,@RequestBody FundTransfer fundTrasfer) {

		Transaction transactionDetails;
		
		UserResponse userResponse;
		String value = req.getHeader("Authorization");
		
		boolean check = false;
		try {
			check = jwtUtil.verify(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (check) {
			transactionDetails = new Transaction();
			transactionDetails = transactionservice.fundTransfer(fundTrasfer);
			
			userResponse = new UserResponse();
			userResponse.setData(transactionDetails);
			return ResponseEntity.status(HttpStatus.OK).body(userResponse);
		} else {
			System.out.println("unauth");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}
		
	@PostMapping("/balance/{accountNo}")
	public ResponseEntity<UserResponse> balance(HttpServletRequest req ,@PathVariable int accountNo) {

		String value = req.getHeader("Authorization");
	   AccountDetails accountDetails;
		UserResponse userResponse;
		boolean check = false;
		try {
			check = jwtUtil.verify(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (check) {
			 accountDetails=new AccountDetails();
			 accountDetails=accountService.getBalance(accountNo);
			
			userResponse = new UserResponse();
			userResponse.setData(accountDetails);
			return ResponseEntity.status(HttpStatus.OK).body(userResponse);
		} else {
			System.out.println("unauth");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}
	
	@PostMapping("/transactionhistory/{accountNo}")
	public ResponseEntity<UserResponse> transactionhistory(HttpServletRequest req,@PathVariable int accountNo) {

		String value = req.getHeader("Authorization");
		
		List<Transaction> transactionDetails;
		UserResponse userResponse;
		boolean check = false;
		try {
			check = jwtUtil.verify(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (check) {
			
			transactionDetails=new ArrayList<Transaction>();
			transactionDetails=transactionservice.getTransactionDetails(accountNo);
		
			userResponse = new UserResponse();
			userResponse.setData(transactionDetails);
			return ResponseEntity.status(HttpStatus.OK).body(userResponse);
		} else {
			System.out.println("unauth");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}

	
	
	
}
