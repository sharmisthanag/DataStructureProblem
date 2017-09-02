package com.java8.test2.JavaClassDesignChap2;

/*
 * The private methods of a base class aren’t inherited by its
derived classes. A method using the same signature in the derived class
isn’t an overridding method, but a new method.
 */
abstract class FinalVariableFromSuperClass {
	public final int finalVar;
}
class MyDerivedClass extends FinalVariableFromSuperClass {
	MyDerivedClass() {
		super();
		finalVar = 1000;//The final field FinalVariableFromSuperClass.finalVar cannot be assigned
	}
}