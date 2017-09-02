package com.java8.test2.JavaClassDesignChap2;

public class Check2ndTimeDerivedClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class A11{
	protected int b=10;
}
class B11 extends A11{
	
}
class C11 extends B11{
	
	public void methods(){
		System.out.println(new C11().b);
	}
}