package com.bank.response;

import java.math.BigInteger;

public class FundTranferResponse {
	 private double accountbalance;
		private BigInteger referenceNumber;
		
		
		public double getAccountbalance() {
			return accountbalance;
		}
		public void setAccountbalance(double accountbalance) {
			this.accountbalance = accountbalance;
		}
		public BigInteger getReferenceNumber() {
			return referenceNumber;
		}
		public void setReferenceNumber(BigInteger referenceNumber) {
			this.referenceNumber = referenceNumber;
		}
		
		public FundTranferResponse(double accountbalance, BigInteger referenceNumber) {
			super();
			this.accountbalance = accountbalance;
			this.referenceNumber = referenceNumber;
		}
		@Override
		public String toString() {
			return "FundTransferResponse [accountbalance=" + accountbalance + ", referenceNumber=" + referenceNumber
					+ "]";
		}
		
		
		

}



