package com.java8.test.accessannonaccessmodifiers;

public class Derived extends Base{
	public final void f(){
	//non final me	
	}
	/*public final void f1(int h){
		compile time error
	}*/

}
