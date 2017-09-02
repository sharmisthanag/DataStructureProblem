package com.java8.test2.JavaClassDesignChap2;


/*
 * Characteristics of an inner class: it can be defined using any access modifier, can
define constructors, and can define instance variables and methods. An inner class can define static
members variables but not static methods.Can’t define static
methods and nonfinal static variables

The accessibility of an inner class outside its outer class depends
on the access modifier used to define the inner class. For example, an
inner class with default access can’t be accessed by classes in different
packages than the outer class.

Yes, an inner class can exist only with an object of its outer class. When a compiler
compiles an inner class, it seems to insert code in the inner class, which defines an
instance variable of its outer class, initialized using its constructor
 */
public class InnerClass {
	static Object obj=null;
	static final Object obj1=null;
	
	Inner inner=new Inner();
	Outer1.Inner1 inner1;

	InnerClass(){
		inner1 = new Outer1().new Inner1();
	}
	public static void main(String[] args) {
		//System.out.println(Outer1.staticMethod());

	}
	protected class Inner{

		Inner(){}
		public String publicInner = "Inner";
		private int privateInner = 20;
		//static int staticInner = 10;
	}
}
class Outer1 {
	class Inner1 {}
	static String staticMethod () {
		Inner1 innerObj = new Outer1().new Inner1();
		return null;
	}
}

//InnerClass cannot have static members because it belongs to an instance (of OuterClass). If you declare InnerClass as static to detach it from the instance, your code will compile.

class OuterClass {
	class InnerClass {
		static final int  i = 100; // no compile error
		//static void f() { } // no compile error
		static final Object obj="";
	}
}
