package com.java8.test2.JavaClassDesignChap2;

/*
 * A final static class variable can be initialized with its declaration, or by using a static initializer
block, which is guaranteed to execute only once for a class.
 */
public class FinalStaticInstanceVariable {
	private final static int v;
	//allowed
	static{
		v=10;
	}
	//not allowed
	/*FinalStaticInstanceVariable(){
		v=10;
	}*/
	/*static void setStaticFinal(int value) {
		v = value;
	}*/
	
}
