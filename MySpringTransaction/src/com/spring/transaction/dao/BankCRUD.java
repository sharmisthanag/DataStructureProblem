package com.spring.transaction.dao;

import java.util.List;

import com.spring.transaction.model.Account;

public interface BankCRUD {
	Account getAccount(int accountNumber);
	void saveAccount(Account account);
	void updateAccount(Account account);
	void deleteAccount(Account account);
	List<Account> getAllAccounts();
	

}
