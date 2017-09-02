package com.java8.test2.JavaClassDesignChap1;

/*
 * 1>Calls to the overloaded methods are resolved during
compilation.
 */
public class Overloaded {
	static {
		System.out.println("in static initializer block of Overloaded");
	}

	public static void main(String[] args) {
		System.out.println(Travel.bookTicket(new CEO()));
		Employee emp = new CEO();

		System.out.println(Travel.bookTicket(emp));
		new Overloaded().method(new CEO());
		new Overloaded().method(emp);
	}
	public void method(){
	}
	public void method(int i){
	}
	public void method(short i){
	}
	public void method(Employee i){
		System.out.println("EMPLOYEE OF OVERLOADED");
	}
	public void method(CEO i){
		System.out.println("CEO OF OVERLOADED");
	}
}
class Employee {}
class CEO extends Employee {}
class Travel {
	static String bookTicket(Employee val) {
		return "economy class";
	}
	static String bookTicket(CEO val) {
		return "business class";
	}
}
/*class Employee {}
class Engineer extends Employee {}
class CEO extends Employee {}
class Travel {
	static String bookTicket(Engineer val) {
		return "economy class";
	}
	static String bookTicket(CEO val) {
		return "business class";
	}
	public static void main(String args[]) {
		Employee emp = new CEO();
		System.out.println(bookTicket(new CEO()));
		System.out.println(bookTicket(emp));
	}
}*/
class MyClass {
	static {
		System.out.println("in static initializer block of MyClass");
	}
	static double calcAverage(double marks1, int marks2) {
		return(marks1 + marks2)/2;
	}
	static double calcAverage(int marks1, double marks2) {
		return(marks1 + marks2)/2;
	}
	static double calcAverage(int marks1, int marks2){
		return(marks1 + marks2)/2;
	}
	public static void main(String[] args) {
		calcAverage(2, 3);
	}
}