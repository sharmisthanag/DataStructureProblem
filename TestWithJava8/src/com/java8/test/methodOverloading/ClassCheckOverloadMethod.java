package com.java8.test.methodOverloading;

public class ClassCheckOverloadMethod {

	public static void main(String[] args) {
		ClassCheckOverloadMethod v=new ClassCheckOverloadMethod();
	//	v.method(null);

	}
	public void method(Object obj) {
		System.out.println("in object");
	}
	public void method(Integer obj) {
		System.out.println("in Integer");

	}
	public void method(String obj) {
		System.out.println("in String");
	}

}
