package com.spring.transaction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="\"Account\"")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceForAccountGen")
    @SequenceGenerator(name = "SequenceForAccountGen", sequenceName = "\"SequenceForAccount\"")
	private int accoutNumber;
	private Double balance;
	private String accountHolderName;
	private String accountType;
	private String branch;
	
	public int getAccoutNumber() {
		return accoutNumber;
	}
	public void setAccoutNumber(int accoutNumber) {
		this.accoutNumber = accoutNumber;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Account [accoutNumber=" + accoutNumber + ", balance=" + balance + ", accountHolderName="
				+ accountHolderName + ", accountType=" + accountType + ", branch=" + branch + "]";
	}
	
	
	
}
