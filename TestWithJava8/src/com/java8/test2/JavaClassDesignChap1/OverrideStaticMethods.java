package com.java8.test2.JavaClassDesignChap1;


/*
 * If a derived class defines a static method with the same name and signature as the one
defined in its base class, it hides its base class method and doesn’t override it.
static method are bonded during compile time using Type of reference variable, and not Object

** Constructors can’t be overridden because a base class constructor
isn’t inherited by a derived class
 */
public class OverrideStaticMethods {

	public static void main(String[] args) {
		BookOverrideStaticMethods base = new BookOverrideStaticMethods();
		base.printName();
		BookOverrideStaticMethods derived = new CourseBookOverrideStaticMethods();
		derived.printName();

	}

}
class BookOverrideStaticMethods {
	static void printName() {
		System.out.println("Book");
	}
}
class CourseBookOverrideStaticMethods extends BookOverrideStaticMethods {
	static void printName() {
		System.out.println("CourseBook");
	}
}
class BookOverrideStaticMethods1 {
	static void printName() {
		System.out.println("Book");
	}
}
class CourseBookOverrideStaticMethods1 extends BookOverrideStaticMethods1 {
	static void printName() {
		System.out.println("CourseBook");
	}
}