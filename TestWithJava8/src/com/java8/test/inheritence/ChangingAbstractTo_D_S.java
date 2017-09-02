package com.java8.test.inheritence;

public class ChangingAbstractTo_D_S {

	public static void main(String[] args) {
		Animal animal=new Animal();
		System.out.println(animal.maxDistance());//calling class
	}

}
interface Jumpable{
	//abstract int maxDistance();
	
	static int maxDistance(){
	return 200;
	}
	
	/*default int maxDistance(){
	return 100;
	}
	*/
	
	
}
class Animal implements Jumpable{//implementation class 
	
	
	public int maxDistance() {
		return 100;
	}
	
}
/*if maxDistance is static : 
 * Implementation class: Compiles
 * Calling class: compiles.But in book it says doesn't compiles
 */
/*if maxDistance is default : 
 * Implementation class: compiles
 * Calling class: compiles
 */
