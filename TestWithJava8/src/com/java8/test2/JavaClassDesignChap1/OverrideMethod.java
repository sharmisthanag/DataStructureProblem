package com.java8.test2.JavaClassDesignChap1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
 * You can override only the following methods from the
base class:
■ Methods accessible to a derived class[public protected]
■ Nonstatic base class methods

 * Overriding method can use any nonaccess modifier for an overridden method. A nonabstract method can
also be overridden to an abstract method. But a final method in the base class cannot be overridden. A
static method cannot be overridden to be nonstatic.

Define the same or a subtype of the return type used in the base class method (covariant return types).

An overriding method must either declare to throw no exception, the same exception,or a subtype of the exception[checked exception] thrown by the base
class method.An overriding method can throw any unchecked exception (RuntimeException or Error) even if the overridden method doesn’t.
 */
public class OverrideMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Book {
	synchronized protected List review(int id,List names) throws Exception {
		return null;
	}
}
class CourseBook extends Book {
	@Override
	final protected List review(int id,List names) throws IOException {
		return null;
	}
	
}
abstract class CourseBook1 extends Book {
	//@Override
	/*
	 * When the overriding method returns a subclass of the return type of the overridden method, it’s known as a covariant return type. To override a method, the parameter list
of the methods in the base and derived classes must be exactly the same. It you try to use covariant types in the argument list, you’ll end up overloading the methods and not overriding them.
	 */
	abstract protected List review(int id,ArrayList names) throws Exception ;
}
