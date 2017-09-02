package com.spring.transaction.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.dao.BankCRUD;
import com.spring.transaction.dao.BankDao;
import com.spring.transaction.model.Account;
import com.spring.transaction.service.BankService;

@Service

public class BankServiceImpl implements BankService{
	public BankServiceImpl() {
	System.out.println("BankServiceImpl created");
	}
	
	
	
	@Autowired
	private BankDao bankDao;
	@Autowired
	private BankCRUD bankCRUD;
	
	
	@Override
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW,readOnly=true)
	public void transferFund(int fromAccountNumber, int toAccountNumber, Double amount) {
		
		try {
			System.out.println("before"+bankCRUD.getAccount(fromAccountNumber));
			bankDao.withdraw(fromAccountNumber, amount);
			System.out.println("after"+bankCRUD.getAccount(fromAccountNumber));
			
			System.out.println("before"+bankCRUD.getAccount(toAccountNumber));
			bankDao.deposit(toAccountNumber, amount);			
			System.out.println("after"+bankCRUD.getAccount(toAccountNumber));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void createAccount(String accountHolderName,String accountType,Double balance) {
		Account account =new Account();
		account.setAccountHolderName(accountHolderName);
		account.setAccountType(accountType);
		account.setBalance(balance);
		bankCRUD.saveAccount(account);
	}

	
}
