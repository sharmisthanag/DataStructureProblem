package com.java8.test.protectedaccessmodifer;

public class TestProtectMethod {

	public static void main(String[] args) {
		AbstractParent c=new ChildClass();
		c.doStuff();
		c.method();

	}

}
