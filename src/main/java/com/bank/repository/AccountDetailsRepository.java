package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.AccountDetails;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails,Integer>{
	
	public AccountDetails findByaccountNo(int accountNo);
	
}
