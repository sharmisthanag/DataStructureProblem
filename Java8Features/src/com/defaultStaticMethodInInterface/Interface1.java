package com.defaultStaticMethodInInterface;

public interface Interface1 {
	void method();
	default String method1_Interface1(Integer i){
		return "welcome to default method of Interface1=>"+i;
	}
	static String method2_Interface1(Integer i){
		return "welcome to static method of Interface1=>"+i;
	}
}
