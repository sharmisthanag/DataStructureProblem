package com.spring.transaction.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.dao.BankCRUD;
import com.spring.transaction.model.Account;

@Repository
@Transactional
public class BankCRUDImpl implements BankCRUD{
	
	public BankCRUDImpl(){
		System.out.println("BankCRUDImpl bean created");
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session getCurrentSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionFactory.openSession();
		}
	}


	@Override
	//if not created a new transaction,it always read from cache which may not persists in db
	//@Transactional(isolation=Isolation.SERIALIZABLE)
	//@Transactional(readOnly=true)//read from cache
	
	//If new Transaction is created,it always fetch data from db
	@Transactional(readOnly=true,propagation=Propagation.REQUIRES_NEW)
	public Account getAccount(int accountNumber) {
		return (Account) getCurrentSession().get(Account.class, accountNumber);
	}

	@Override
	public void saveAccount(Account account) {
		getCurrentSession().save(account);
	}

	@Override
	public void updateAccount(Account account) {
		getCurrentSession().update(account);
	}

	@Override
	public void deleteAccount(Account account) {
		getCurrentSession().delete(account);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAllAccounts() {
		return getCurrentSession().createQuery("from Account").list();
	}

}
