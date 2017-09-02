package com.java8.test2.JavaClassDesignChap2;

/*
 * For an enum constant BEGINNER in enum Level, calling
System.out.println(Level.BEGINNER) returns the name of the enum
constant—that is, BEGINNER. You can override toString() in an enum to
modify this default return value

a class can extend from only one base class, an attempt to make your enum
extend any other class will fail.

But you can make your enum implement any number of interfaces. A class can extend
only one base class but can implement multiple interfaces

An enum implicitly extends java.lang.Enum, so it can’t extend
any other class. But a class can’t explicitly extend java.lang.Enum.
 */
public class EnumTest {

	public static void main(String[] args) {
		EnumDemo level=EnumDemo.BEGINNER;
		System.out.println(level);
		System.out.println(EnumDemo.valueOf("BEGINNER"));
		System.out.println(level.name());
		System.out.println(ExtendEnumFails.h);
		
		EnmWithConstants enmWithConstants=EnmWithConstants.CHOCOLATE;
		System.out.println(enmWithConstants.name());
		enmWithConstants.setColor("white");
		System.out.println(enmWithConstants.getColor());
		
		EnumConstructor choclateEnum=EnumConstructor.CHOCOLATE;
		System.out.println(choclateEnum);
		EnumConstructor walnut=EnumConstructor.WALNUT;
		System.out.println(walnut);
		
	}

}
/*enum ExtendEnumFailes extends EnumTest{
	HELLO,PEACE;
}*/

enum ExtendEnumFails implements ENUMInterface{
	HELLO,PEACE;
}
interface ENUMInterface{
	int h=20;
}