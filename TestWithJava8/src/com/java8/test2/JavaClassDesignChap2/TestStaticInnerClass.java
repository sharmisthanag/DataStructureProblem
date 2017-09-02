package com.java8.test2.JavaClassDesignChap2;

import com.java8.test2.JavaClassDesignChap2.Outer.StaticNested;

/*
 * To create an object of a static nested class, you need to prefix its name with the
name of its outer class (necessary only if you’re outside the outer class).
■ A static nested class can define both static and nonstatic members.
■ You need not create an object of a static nested class to access its static members.
They can be accessed the way static members of a regular class are
accessed.
■ You should create an object of a static nested class to access its nonstatic
members, by using the operator new.
■ A static nested class can be defined using any access modifier.
■ A static nested class can define constructor(s).
 */
public class TestStaticInnerClass {

	public static void main(String[] args) {
		StaticNested nested1 = new StaticNested();
		Outer.StaticNested nested2 = new Outer.StaticNested();
		nested1.innerStatic = 99;
		nested1.innerInstance = 999;
		System.out.println(nested1.innerStatic + ":" +
				nested1.innerInstance);
		System.out.println(nested2.innerStatic + ":" +
				nested2.innerInstance);

	}

}
