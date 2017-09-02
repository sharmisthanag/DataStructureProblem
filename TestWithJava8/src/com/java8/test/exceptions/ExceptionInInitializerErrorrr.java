package com.java8.test.exceptions;

public class ExceptionInInitializerErrorrr {
	
	//anonymous static block
	/*static{
		int i=10;
		int j=12;
		int x=2/0;
	}*/
	
	//runtime exception thrown while initializing static variable
	/*static int c=2/0;*/
	
	//Execution of a static method (called from either of the previous two items)
	static{
		method();
	}

	public static void main(String[] args) {

	}
	
	public static void method() {
		int i=10;
		int j=12;
		int x=2/0;
	}
	
	
}
