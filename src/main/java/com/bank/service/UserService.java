package com.bank.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.jwt.JwtUtil;
import com.bank.model.User;
import com.bank.model.UserPrimarykey;
import com.bank.model.UserResponse;
import com.bank.repository.UserRepository;
import com.bank.request.LoginRequest;
import com.bank.request.SignupRequest;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepostory;

	@Autowired
	private JwtUtil jwtUtil;

	public UserResponse signup(SignupRequest signuprequest) {

		UserResponse userresponse = new UserResponse();
		User user = new User();
		UserPrimarykey userprimarykey = new UserPrimarykey();
		userprimarykey.setUserId(signuprequest.getUserId());
		userprimarykey.setAccountNo(signuprequest.getAccountNo());

		user.setUserprimarykey(userprimarykey);
		user.setPassword(signuprequest.getPassword());

		user = userrepostory.save(user);

		userresponse.setData(user);
		return userresponse;
	}

	public UserResponse login(LoginRequest loginrequest) {
		UserResponse userresponse = new UserResponse();

		User user = userrepostory.findByuserprimarykeyUserIdAndPassword(loginrequest.getUserId(),
				loginrequest.getPassword());
		if (user == null) {
			userresponse.setData("logine failled");
			return userresponse;
		}

		String token = jwtUtil.generateJwt(user);
		Map<String, Object> data = new HashMap<>();
		data.put("accessToken", token);
		userresponse.setData(data);
		return userresponse;

	}

}
