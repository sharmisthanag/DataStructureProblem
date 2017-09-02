package com.java8.test2.JavaClassDesignChap2;

/*
 * A final class can’t be extended. On the other hand, abstract classes are created so they
can be extended by other classes. Hence, abstract classes can’t be defined as final classes
 */
public class CanAbstractHaveConstructor {

	public static void main(String[] args) {
		A b=new B();
		b.method();//print 20
		System.out.println(b.j);//print 10

	}

}
abstract class A{
	int j=10;
	public A(){
		
	}
	abstract void method();
	
	/*
	 * IMP class can’t define an abstract static method.
	 */
	//abstract static void method1();//The abstract method method1 in type A can only set a visibility modifier, one of public or protected
}
class B extends A{
	int j =20;
	@Override
	void method() {
		System.out.println(this.j);
	}
	
}
/*DON’T MAKE AN ABSTRACT CLASS IMPLEMENT INTERFACES THAT RESULT IN INVALID
METHOD IMPLEMENTATION

interface Live{
boolean eat();
}
abstract class Animal implements Live{
public abstract void eat();
}
*/