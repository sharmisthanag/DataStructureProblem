package com.java8.test2.Exceptions;

/*
 * finally block if present will always be a deciding block for return value of method if return
                statement is present in finally block irrespective of return present in try and catch block.
 */
public class ExceptionExamplea{ 

	public static final void main(String[] args) {
		System.out.println(test());
	}

	/*private static int test() {
		int a=10;
		try {
			String str = null;
			str.toString();
			a=20;
			return a;
		}
		catch(NullPointerException n){
			return a;
		}
		finally {
			a=100;
			//return a;
		}
	} */
	private static Integer test() {
		Integer a=10;
		try {
			/*String str = null;
			str.toString();*/
			a=20;
			return a;
		}
		catch(NullPointerException n){
			return a;
		}
		finally {
			a=100;
			//return a;
		}
	} 
}
