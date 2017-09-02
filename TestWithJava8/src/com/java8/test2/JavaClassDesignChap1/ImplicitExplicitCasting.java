package com.java8.test2.JavaClassDesignChap1;

/*
 * If you cast an instance to a class outside its inheritance tree,
you’ll get a compiler error. If you cast an instance to a class within its
inheritance tree, but the types don’t match at runtime, the code will
throw a ClassCastException.
 */
public class ImplicitExplicitCasting {

	public static void main(String[] args) {
		BookImplicitExplicitCasting book = new BookImplicitExplicitCasting();
		PrintableImplicitExplicitCasting printable = book;
		printable.print();
		ShoppingItemImplicitExplicitCasting shoppingItem = book;
		shoppingItem.description();

		
		//
		PrintableImplicitExplicitCasting printable2 = new BookImplicitExplicitCasting();
		((BookImplicitExplicitCasting)printable2).description();
		
	}

}
interface PrintableImplicitExplicitCasting {
void print();
}
class ShoppingItemImplicitExplicitCasting {
public void description() {
System.out.println("Shopping Item");
}
}
class BookImplicitExplicitCasting extends ShoppingItemImplicitExplicitCasting implements PrintableImplicitExplicitCasting {
public void description() {
System.out.println("Book");
}
public void print() {
System.out.println("Printing book");
}
}