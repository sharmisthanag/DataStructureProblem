package com.java8.test2.JavaClassDesignChap2;

/*
 * All enums in Java extend the abstract class java.lang.Enum, defined in the Java
 * 
 * For an enum constant BEGINNER in enum Level, calling
System.out.println(Level.BEGINNER) returns the name of the enum
constant—that is, BEGINNER. You can override toString() in an enum to
modify this default return value
 */
public enum Level {
	BEGINNER;
	static{ System.out.println("static init block"); }
	Level(){
		System.out.println("constructor");
	}
	public static void main(String... args){
		System.out.println(Level.BEGINNER);
	}
}
/*
An enum can’t define a constructor with public or protected
access level.
 */
class MyClass {
	enum Level { BEGINNER, INTERMEDIATE, EXPERT }
}
interface MyInterface {
	enum Level { BEGINNER, INTERMEDIATE, EXPERT }
}
class MyClasss {
	void aMethod() {
		enum Levell { BEGINNER, INTERMEDIATE, EXPERT }//The member enum Levell can only be defined inside a top-level class or interface or in a static context
	}
}