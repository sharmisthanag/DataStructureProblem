package com.java8.test2.JavaClassDesignChap1.otherpackage;

import com.java8.test2.JavaClassDesignChap1.ParentChildRelationship;

public class DerivedInOtherPackage extends ParentChildRelationship{
	DerivedInOtherPackage(){
		this.i=10;
	}

	protected void method(){
		ParentChildRelationship f=new ParentChildRelationship();
		/*
		 * f.i ->not accessible
		 * A derived class can inherit and access protected members of its
		 * base class, regardless of the package in which it’s defined. A derived
		 * class in a separate package can’t access protected members of its base
		 * class using reference variables.
		 */
		
		System.out.println("ParentChildRelationship");
	}



}
