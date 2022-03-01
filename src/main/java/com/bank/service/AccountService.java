package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.AccountDetails;
import com.bank.repository.AccountDetailsRepository;

@Service
	public class AccountService {

		@Autowired
		private AccountDetailsRepository accountDetailsRepository;

		public AccountDetails getBalance(int accountNo) {

			return accountDetailsRepository.findByaccountNo(accountNo);
		}
	}


