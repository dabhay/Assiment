package com.bank.request;

import java.math.BigInteger;

public class FundTransperRequst {private Long fromAccount;
private Long toAccount;
private Double transactionAmount;
public Long getFromAccount() {
	return fromAccount;
}
public void setFromAccount(Long fromAccount) {
	this.fromAccount = fromAccount;
}
public Long getToAccount() {
	return toAccount;
}
public void setToAccount(Long toAccount) {
	this.toAccount = toAccount;
}
public Double getTransactionAmount() {
	return transactionAmount;
}
public void setTransactionAmount(Double transactionAmount) {
	this.transactionAmount = transactionAmount;
}
public FundTransperRequst(Long fromAccount, Long toAccount, Double transactionAmount) {
	super();
	this.fromAccount = fromAccount;
	this.toAccount = toAccount;
	this.transactionAmount = transactionAmount;
}
@Override
public String toString() {
	return "FundTransfer [fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", transactionAmount="
			+ transactionAmount + "]";
}



}



