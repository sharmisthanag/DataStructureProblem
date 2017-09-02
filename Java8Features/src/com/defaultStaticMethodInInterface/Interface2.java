package com.defaultStaticMethodInInterface;

public interface Interface2 {

	void method();
	default String method1_Interface2(Integer i){
		return "welcome to default method of Interface2=>"+i;
	}
	static String method2_Interface2(Integer i){
		return "welcome to static method of Interface2=>"+i;
	}
}
