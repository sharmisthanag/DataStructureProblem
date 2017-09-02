package com.java8.test.inheritence;

public interface Interfaces {
	default void  defaultmethod(){
		System.out.println("default in interfaces");
	};
	
	static void staticmethod(){
		System.out.println("static in interfaces");
	}

}
interface Interfaces1 {
	default String  defaultmethod(String h){
		System.out.println("default in interfaces1");
		return null;
	};
	
	static void staticmethod(){
		System.out.println("static in interfaces1");
	}

}
class A implements Interfaces,Interfaces1 {
	/*if have default methods with same name and signature,
	 * only return type chnages,then that 2 interfaces together cannot be implement by a class
	 * e.g: remove String h from defaultmethod of Interfaces1
	 * */
	
	static String staticmethod(){
		System.out.println("static in A");
		return null;
	}
	public static void main(String[] args){
		A a=new A();
		a.defaultmethod();
		A.staticmethod();
		new Interfaces(){
			
		};
	}
	
}
