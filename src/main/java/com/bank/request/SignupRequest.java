package com.bank.request;




public class SignupRequest {

	private String userId;

	private int accountNo;

	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SignupRequest(String userId, int accountNo, String password) {
		super();
		this.userId = userId;
		this.accountNo = accountNo;
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignupRequest [userId=" + userId + ", accountNo=" + accountNo + ", password=" + password + "]";
	}

	
}
