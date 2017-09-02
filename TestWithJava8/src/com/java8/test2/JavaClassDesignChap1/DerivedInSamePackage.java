package com.java8.test2.JavaClassDesignChap1;

public class DerivedInSamePackage extends ParentChildRelationship {
	DerivedInSamePackage(){
		this.i=10;
		
	}

	public static void main(String[] args) {
		ParentChildRelationship o=new ParentChildRelationship();
		o.i=10;
		
	}

}
