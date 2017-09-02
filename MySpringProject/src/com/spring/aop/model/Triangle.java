package com.spring.aop.model;

import org.springframework.aop.framework.AopContext;

public class Triangle {
	public Triangle(){
		System.out.println("set triangle");

	}
	
	private String name;

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
		
	}
	
	public String adviceMethod(int i){
		System.out.println(i);
		return "triangle adviceMethod";//->in loggingAdvice6 call execution
	}
	public String adviceMethodThrowsException(int i){
		System.out.println(((Triangle)AopContext.currentProxy()).privateCall(10)+" "+i);
		throw new RuntimeException();//in loggingAdvice7 call execution
	}
	public String adviceMethodThrowsException1(int i){
		System.out.println(((Triangle)AopContext.currentProxy()).privateCall(10)+" "+i);
		throw new RuntimeException();//in loggingAdvice7 call execution
	}
	public String privateCall(int g){
		return "privateCall";
	}

	
}
