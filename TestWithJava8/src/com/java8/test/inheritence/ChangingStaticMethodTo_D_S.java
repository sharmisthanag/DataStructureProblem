package com.java8.test.inheritence;

public class ChangingStaticMethodTo_D_S {

	public static void main(String[] args) {
		Animal3 animal=new Animal3();
		System.out.println(Jumpable3.maxDistance());//calling class
	}

}
interface Jumpable3{
	static int maxDistance(){
		return 100;
	}
	/*default int maxDistance(){
		return 100;
	}*/
	//abtract int maxDistance();
}
class Animal3 implements Jumpable3{//implementation class 
	
}
/*if maxDistance is default : 
 * Implementation class: Compiles
 * Calling class: doesn't compile : Cannot make a static reference to the non-static method maxDistance() from the type Jumpable
 */
/*if maxDistance is abstract : 
 * Implementation class: Doesn't Compiles,The type Animal must implement the inherited abstract method Jumpable.maxDistance()
 * Calling class: doesn't compile : Cannot make a static reference to the non-static method maxDistance() from the type Jumpable
 */
