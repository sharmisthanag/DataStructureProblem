package com.springcore.circulardependency;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class AfterPropertiesSetTest implements InitializingBean{

	String g;
	
	public AfterPropertiesSetTest(){
		System.out.println("in const of AfterPropertiesSetTest");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	System.out.println("in afterPropertiesSet of AfterPropertiesSetTest");
		
	}
	@PostConstruct
	public void init(){
		System.out.println("in init of AfterPropertiesSetTest");
	}

}
