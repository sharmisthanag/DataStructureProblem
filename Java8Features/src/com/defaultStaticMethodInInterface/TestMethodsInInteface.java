package com.defaultStaticMethodInInterface;

public class TestMethodsInInteface implements Interface1,Interface2{

	public static void main(String[] args) {
		System.out.println(Interface1.method2_Interface1(10));
		System.out.println(Interface2.method2_Interface2(20));
		System.out.println(new TestMethodsInInteface().method1_Interface1(100));
		System.out.println(new TestMethodsInInteface().method1_Interface2(200));

	}

	@Override
	public void method() {
		System.out.println("Implemented abstract method of Interfaces");
		System.out.println();
	}
	@Override
	public String method1_Interface1(Integer i) {
		System.out.println(Interface1.super.method1_Interface1(90));
		System.out.println("Overriddden default method of Interfaces1=>"+i);
		return "";
	}
	@Override
	public String method1_Interface2(Integer i) {
		System.out.println(Interface2.super.method1_Interface2(190));
		System.out.println("Overriddden default method of Interfaces2=>"+i);
		return "";
	}

}
