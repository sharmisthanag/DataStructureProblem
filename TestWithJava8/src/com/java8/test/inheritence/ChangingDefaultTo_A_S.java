package com.java8.test.inheritence;

public class ChangingDefaultTo_A_S {

	public static void main(String[] args) {
		Animal2 animal=new Animal2();
	}

}
interface Jumpable2{
	default int maxDistance(){
	return 100;
	}
	/*static int maxDistance(){
		return 100;
	}*/
	
	//abtract int maxDistance();
}
class Animal2 implements Jumpable2{//implementation class 
	
	public void callingMaxDistance(){//calling method
		Jumpable2.super.maxDistance();
	}
	
}
/*if maxDistance is static : 
 * Implementation class: Compiles
 * Calling class: doesn't compile : This static method of interface Jumpable can only be accessed as Jumpable.maxDistance
 */
/*if maxDistance is abstract : 
 * Implementation class: Doesn't Compiles,The type Animal must implement the inherited abstract method Jumpable.maxDistance()
 * Calling class: doesn't compile : Cannot directly invoke the abstract method maxDistance() for the type Jumpable
 */
