package com.bank.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.model.User;
import com.bank.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtUtil {
	@Autowired
	private UserRepository urRepository;
	

	private static String secret = "this is secret";
	private static long expiryduration = 60 * 60;

public String generateJwt(User user) {

		
		long millitime = System.currentTimeMillis();
		long expireTime = millitime * expiryduration * 1000;
		Date issuedAt = new Date(millitime);
		Date expireAt = new Date(expireTime);
		
	
		
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("user", user.getUserprimarykey().getUserId());
		
		
	
		return Jwts.builder().setClaims(claims).setId("Mayur").setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 18000000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();

	}
		

	public boolean verify(String authorization) throws Exception {
		try {

			Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
			
			claims.getId();
			claims.get("user");
			Integer usercount=urRepository.findByuserprimarykeyUserId(claims.get("user").toString());
			
			if(usercount > 0)
		   {
			   return true;
		   }
		   else
		   {
				return false;
		   }
		   
			
		} catch (Exception e) {

			throw new Exception(e);

		}
		
	}

}
		
	


