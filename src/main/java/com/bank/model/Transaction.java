package com.bank.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "transaction_details")
// @IdClass(Transactionprimarykey.class)
public class Transaction implements Serializable {

	private static final long serialVersionUID = -4905411833443676690L;

	@EmbeddedId
	private TransactionPrimarykey transactionprimarykey;

	private Double transactionAmount;

	public TransactionPrimarykey getTransactionprimarykey() {
		return transactionprimarykey;
	}

	public void setTransactionprimarykey(TransactionPrimarykey transactionprimarykey) {
		this.transactionprimarykey = transactionprimarykey;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionprimarykey=" + transactionprimarykey + ", transactionAmount="
				+ transactionAmount + "]";
	}
}
