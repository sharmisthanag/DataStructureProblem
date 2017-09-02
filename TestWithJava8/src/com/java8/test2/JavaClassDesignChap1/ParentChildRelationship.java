package com.java8.test2.JavaClassDesignChap1;

/*
 * A derived class can inherit and access protected members of its
base class, regardless of the package in which it’s defined. A derived
class in a separate package can’t access protected members of its base
class using reference variables.
 */
public class ParentChildRelationship {
	protected int i=10;
	protected void method(){
		System.out.println("ParentChildRelationship");
	}

}
