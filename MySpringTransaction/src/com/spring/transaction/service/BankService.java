package com.spring.transaction.service;


public interface BankService {
	void transferFund(int fromAccountNumber, int  toAccountNumber, Double amount);
	void createAccount(String accountHolderName, String accountType, Double balance);


}
