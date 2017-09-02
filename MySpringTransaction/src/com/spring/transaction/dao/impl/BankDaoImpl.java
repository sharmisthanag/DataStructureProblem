package com.spring.transaction.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.dao.BankCRUD;
import com.spring.transaction.dao.BankDao;
import com.spring.transaction.model.Account;

@Repository

public class BankDaoImpl implements BankDao{
	
	public BankDaoImpl(){
		System.out.println("BankDaoImpl bean created");
	}
	
	@Autowired 
	BankCRUD bankCRUD;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,readOnly=false)//if readOnly true,no write operation is performed
	public void deposit(int toAccountNumber, Double amount) throws Exception {
		Account toAccount = bankCRUD.getAccount(toAccountNumber);
		if(toAccount==null){
			throw new Exception("to Account not found");
		}
		toAccount.setBalance(amount+toAccount.getBalance());
		bankCRUD.updateAccount(toAccount);
		System.out.println("in deposit -> after deposited"+bankCRUD.getAccount(toAccountNumber));
		//throw new RuntimeException("hh");
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class/*,readOnly=true*/)
	public void withdraw(int fromAccountNumber, Double amount) throws Exception{
		Account fromAccount = bankCRUD.getAccount(fromAccountNumber);
		if(fromAccount==null){
			throw new Exception("to Account not found");
		}
		if(fromAccount.getBalance()>amount){
			fromAccount.setBalance(fromAccount.getBalance()-amount);
			bankCRUD.updateAccount(fromAccount);
			System.out.println("in withdraw -> after withdrawn: "+bankCRUD.getAccount(fromAccountNumber));
		}
		else{
			throw new RuntimeException("Insufficient Balance");
		}
	}

}
