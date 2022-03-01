package com.bank.model;

public class FundTransfer {
	private Double amount;
	private int fromAccount;
	private int toAccount;
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public int getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public FundTransfer(Double amount, int fromAccount, int toAccount) {
		super();
		this.amount = amount;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
	}
	@Override
	public String toString() {
		return "Fundtransfer [amount=" + amount + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + "]";
	}
	
	
	
	

}



