package com.java8.test2.JavaClassDesignChap1;

/*
 * cast a final class’s instance to an interface it doesn’t implement
 * 
 * You can explicitly cast null to any type. It won’t generate a
compilation error or throw a ClassCastException

If you cast an instance to a class outside its inheritance tree,
you’ll get a compiler error. If you cast an instance to a class within its
inheritance tree, but the types don’t match at runtime, the code will
throw a ClassCastException.
 */
public class FinalANDNULL_ClassCasting {

	public static void main(String[] args) {

		Engineer engineer = new Engineer();
		Printable printable = (Printable)engineer;
		
		/*IMP
		Engineer1 engineer1 = new Engineer1();
		Printable printable1 = (Printable)engineer1;
		 */
		
		/*It allow subclasses of Engineer2 to implement Printable and use
		the reference variable of type Printable
		 */
		Engineer2 engineer2 = new Engineer2();
		Printable printable2 = (Printable)engineer2;//.ClassCastException as engineer2 doesnot implements Printable
		Engineer2 engineer3 = new Engineer3();
		Printable printable3 = (Printable)engineer3;
		//this the above line printable3 allowed but if Engineer2 was final then it will not compile as final class has no subclasses
		
		/*
		 * Explicitly NULL Casting
		 */
		Engineer e = (Engineer)null;
		Engineer1 e1 = (Engineer1)null;
		Printable p1 = (Printable)null;
		
		
		
	}

}
interface Printable {}
final class Engineer implements Printable{}
final class Engineer1 {}
class Engineer2 {}
class Engineer3 extends Engineer2 implements Printable{}
class Factory {

}