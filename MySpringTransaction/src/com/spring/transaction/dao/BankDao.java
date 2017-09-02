package com.spring.transaction.dao;

public interface BankDao {
	public void withdraw(int fromAccountNumber, Double amount) throws Exception;
	public void deposit(int toAccountNumber, Double amount) throws Exception;

}
