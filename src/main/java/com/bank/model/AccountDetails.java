package com.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_details")
public class AccountDetails {

	@Id
	private int accountNo;
	private double availableBalance;

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	@Override
	public String toString() {
		return "AccountDetails [accountNo=" + accountNo + ", availableBalance=" + availableBalance + "]";
	}

	public AccountDetails(int accountNo, double availableBalance) {
		super();
		this.accountNo = accountNo;
		this.availableBalance = availableBalance;
	}

	public AccountDetails() {

	}

}
