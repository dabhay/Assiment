package com.bank.service;

import java.util.List;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.AccountDetails;
import com.bank.model.FundTransfer;
import com.bank.model.Transaction;
import com.bank.model.TransactionPrimarykey;
import com.bank.repository.AccountDetailsRepository;
import com.bank.repository.TransactionRepository;




	@Service
	public class TransactionService {

		@Autowired
		private TransactionRepository transactionRepository;

		@Autowired
		private AccountDetailsRepository accountDetailsRepository;

		public Transaction fundTransfer(FundTransfer fundtransfer) {
			
			RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
			int referenceNo = randomDataGenerator.nextInt(1, Integer.MAX_VALUE);

			
			AccountDetails accountDetailsFromAccount = accountDetailsRepository.findByaccountNo(fundtransfer.getFromAccount());
			AccountDetails accountDetailsToAccount = accountDetailsRepository.findByaccountNo(fundtransfer.getToAccount());

			Transaction transactionDetails = this.save(fundtransfer.getFromAccount(), fundtransfer.getAmount(), "D",
					referenceNo);

			this.save(fundtransfer.getToAccount(), fundtransfer.getAmount(), "C", referenceNo);

			Double fromAccountsubstract = (accountDetailsFromAccount.getAvailableBalance() - fundtransfer.getAmount());
			accountDetailsFromAccount.setAvailableBalance(fromAccountsubstract);

			accountDetailsRepository.save(accountDetailsFromAccount);
			Double toAccountSum = Double.sum(accountDetailsToAccount.getAvailableBalance(), fundtransfer.getAmount());
			accountDetailsToAccount.setAvailableBalance(toAccountSum);
			accountDetailsRepository.save(accountDetailsToAccount);

			return transactionDetails;

		}

		public Transaction save(int accountNo, Double transactionAmount, String transactionFlag, int referenceNo) {
			Transaction transaction = new Transaction();
			TransactionPrimarykey transactionprimarykey = new TransactionPrimarykey();
			transaction.setTransactionAmount(transactionAmount);
			transactionprimarykey.setAccountNo(accountNo);
			transactionprimarykey.setReferenceNumber(referenceNo);
			transactionprimarykey.setTransactionFlag(transactionFlag);
			transaction.setTransactionprimarykey(transactionprimarykey);
			transaction=transactionRepository.save(transaction);
			return transaction;
			
		}
		
		public List<Transaction> getTransactionDetails(int accountNo){
			return transactionRepository.findBytransactionprimarykeyAccountNo(accountNo);
		}
			
			
			
		

			
		

	}

	


