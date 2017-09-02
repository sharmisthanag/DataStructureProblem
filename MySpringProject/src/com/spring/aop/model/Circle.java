package com.spring.aop.model;

public class Circle {
	public Circle(){
		System.out.println("set circle");

	}
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		
		return name;
	}
	

}
