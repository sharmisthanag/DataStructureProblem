package com.spring.transaction.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.transaction.service.BankService;

@Component
public class MySpringTransactionTestClass {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		
		BankService bankService=ctx.getBean("bankServiceImpl",BankService.class);
		bankService.createAccount("Sharmistha", "savings", 7200.00);
		//bankService.transferFund(50, 100 , 10.00);

	}

}
