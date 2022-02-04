package com.bank.model;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class Userprimarykey implements Serializable {
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * *
	 * 
	 *
	 *
	 * /
	 */

	private String userId;

	
	private int accountNo;


	public Userprimarykey(String userId, int accountNo) {
		super();
		this.userId = userId;
		this.accountNo = accountNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}


	@Override
	public String toString() {
		return "Userprimarykey [userId=" + userId + ", accountNo=" + accountNo + "]";
	}


	public Userprimarykey() {
	
		// TODO Auto-generated constructor stub
	}

	

}
