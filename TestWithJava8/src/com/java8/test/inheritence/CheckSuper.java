package com.java8.test.inheritence;

public class CheckSuper {

	public static void main(String[] args) {
		Derived23 d=new Derived23();
		d.supergetname();
		d.getName();
		System.out.println("**********************");
		new Programmer().printValues();
	}

}
class Base23{
	String name="Purnima";
	public void getName(){
		System.out.println(this.name);
	}
	
}
class Derived23 extends Base23{
	String myname="Sharmistha";
	public void getName(){
		System.out.println(this.myname);
		System.out.println(super.name);
		super.getName();
	}
	public void supergetname(){
		super.getName();
	}
}
class Employee{
	String name="Emp";
	String address = "Belgharia";
}
class Programmer extends Employee{
	String name="Prod";
	void printValues(){
		System.out.println(this.name);
		System.out.println(this.address);
		System.out.println(super.address);
		System.out.println(super.name);
	}
}