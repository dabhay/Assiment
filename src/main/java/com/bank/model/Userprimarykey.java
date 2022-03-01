package com.bank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserPrimarykey implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;

	private int accountNo;

	public UserPrimarykey(String userId, int accountNo) {
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

	public UserPrimarykey() {

		// TODO Auto-generated constructor stub
	}

}
