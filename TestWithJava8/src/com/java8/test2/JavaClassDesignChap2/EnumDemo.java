package com.java8.test2.JavaClassDesignChap2;

/*
 * finite and predefined set of objects can be defined as enumerated types called enums.it is custom data type
 *Users are allowed to use only existing
enum objects; they can’t create new enum objects. Type safety was the main reason
for introducing enumerated types in Java version 5.0

These constants are also static members and are accessible by using the
name of the enum in which they’re defined.

You can assign a gaming level, defined by the enum Level for a game.

For an enum constant BEGINNER in enum Level, calling
System.out.println(Level.BEGINNER) returns the name of the enum
constant—that is, BEGINNER. You can override toString() in an enum to
modify this default return value
 */
public enum EnumDemo {
	 BEGINNER, INTERMEDIATE, EXPERT ;
	 
	 public String toString(){
		 return ""+this.ordinal();
	 }
	 
}
class Demo{
	EnumDemo level;
	Demo(){
		//level = "";//Type mismatch: cannot convert from String to EnumDemo
		this.level=EnumDemo.EXPERT;
	}
}