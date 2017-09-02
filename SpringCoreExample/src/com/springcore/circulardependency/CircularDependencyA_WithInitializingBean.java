package com.springcore.circulardependency;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//Implement ApplicationContextAware and InitializingBean	
@Component
public class CircularDependencyA_WithInitializingBean implements ApplicationContextAware, InitializingBean,BeanNameAware {
	 private CircularDependencyB circB;
	 
	 private ApplicationContext context;
	 
	 public CircularDependencyA_WithInitializingBean(){
		 System.out.println("in constr of CircularDependencyA_WithInitializingBean");
	 }
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("in setApplicationContext of Awithi");
		context=ctx;
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("in afterPropertiesSet of CircularDependencyA_WithInitializingBean");
		this.circB = context.getBean(CircularDependencyB.class);
		System.out.println("this.cirB=>"+this.circB);
	}
	@PostConstruct
	public void init(){
		System.out.println("in init of CircularDependencyA_WithInitializingBean");
	}
	@Override
	public void setBeanName(String arg0) {
		System.out.println("in setBeanNameof CircularDependencyA_WithInitializingBean");
		
	}
}
