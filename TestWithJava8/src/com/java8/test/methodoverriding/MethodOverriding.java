package com.java8.test.methodoverriding;

public class MethodOverriding {

	public static void main(String[] args) {
		Parent d=new Derived();
		Parent p=new Parent();
		System.out.println(p.b+","+p.a);
		System.out.println(d.b+","+d.a);
		
		p.method();
		d.method();
		
		Parent.staticMethod();
		//p.staticMethod();
		Derived.staticMethod();


	}

}
class Parent{
	public static int a=10;
	public int b=13;
	public Number method(){
		System.out.println("in parent+a="+a+",b="+b);
		return null;
	}
	public static void staticMethod(){
		System.out.println("in parent static");
	}
}
class Derived extends Parent{
	public int a=111;
	public int b=123;
	/*public Derived(){
		this.a=super.a;
		this.b=super.b;
	}*/
	public Integer method(){
		System.out.println("in derived,a="+a+",b="+b);
		return 0;
	}
	public static void staticMethod(){
		System.out.println("in derived static");
	}
}