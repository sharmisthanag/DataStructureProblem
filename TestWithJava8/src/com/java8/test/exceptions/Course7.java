package com.java8.test.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/*class Course {
	String courseName;
	Course() {
		Course c = new Course();
		c.courseName = "Oracle";
	}
}
public class Course7 {
	public static void main(String args[]) throws RuntimeException{
		Course c = new Course();
		c.courseName = "Java";
		System.out.println(c.courseName);
	}
}
 */
/*public class Course7 {
	public static void main(String args[]) {
		Course7 var = new Course7();
		int i=args.length;//0
		var.printArrValues(args);//IndexOutOfBoundsException
	}
	void printArrValues(String[] arr) {
		try {
			System.out.println(arr[0] + ":" + arr[1]);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBoundsException");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException");
		}
	}
}*/

/*public class Course7 {
	void method() {
		try {
			guru();
			return;
		} finally {
			System.out.println("finally 1");
		}
	}
	void guru() {
		System.out.println("guru");
		throw new StackOverflowError();
	}
	public static void main(String args[]) {
		Course7 var = new Course7();
		var.method();
	}
}*/

/*public class Course7 {
	public static void main(String args[]) {
		int arr[] = new int[5];
		arr = new int[]{1,2,3,4};
		int x = arr[1]-- + arr[0]-- /arr[0] * arr[4];//arithmetic exception as because arr[0]-- /arr[0] means 1/0
		System.out.println(x);
	}

}*/

/*public class Course7 {
	int tryAgain() {
		int a = 10;
		try {
			++a;
		} finally {
			a++;
		}
		return a;
	}

	public static void main(String args[]) {
		System.out.println(new Course7().tryAgain());
	}
}*/

/*class EJavaBase {
	void myMethod() throws ExceptionInInitializerError {
		System.out.println("Base");
	}
}
class EJavaDerived extends EJavaBase {
	void myMethod() throws RuntimeException {
		System.out.println("Derived");
	}
}
public class Course7 {
	public static void main(String args[]) {
		EJavaBase obj = new EJavaDerived();
		obj.myMethod();
	}
}
*/

/*public class Course7 {
	void foo() {
		try {
			String s = null;
			System.out.println("1");
			try {
				System.out.println(s.length());
			} catch (NullPointerException e) {
				System.out.println("inner");
			}
			System.out.println("2");
		} catch (NullPointerException e) {
			System.out.println("outer");
		}
	}

	public static void main(String args[]) {
		Course7 obj = new Course7();
		obj.foo();
	}
}*/
public class Course7 {
	static int i=10;
	static{
		i=20;
	}
	public static void main(String args[]) {
		System.out.println(i);
	}
}
