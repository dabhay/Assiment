package com.bank.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable

public class TransactionPrimarykey implements Serializable {

	private static final long serialVersionUID = 1313750585939954818L;

	private int accountNo;

	private String transactionFlag;

	private int referenceNumber;

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getTransactionFlag() {
		return transactionFlag;
	}

	public void setTransactionFlag(String transactionFlag) {
		this.transactionFlag = transactionFlag;
	}

	public int getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@Override
	public String toString() {
		return "Transactionprimarykey [accountNo=" + accountNo + ", transactionFlag=" + transactionFlag
				+ ", referenceNumber=" + referenceNumber + "]";
	}

}
