package com.java8.test2.JavaClassDesignChap1;

/*
 * Each
instance initializer is invoked when an instance is created, in the order they’re defined
in a class. They’re invoked before a class constructor is invoked.
 */
/*public class InstanceInitializer {
	private int i;
	private String h;
	{
		i=10;
		h="shar";
	}
	public InstanceInitializer(){
		this.i=100;
		this.h="sharmistha";
	}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getH() {
		return h;
	}

	public void setH(String h) {
		this.h = h;
	}

	public static void main(String[] args) {
		InstanceInitializer i=new InstanceInitializer();
		System.out.println(i.i);
		System.out.println(i.h);
	}

}*/
/*class Employee {
String name;
int age;
Employee() {
this("Shreya", 10);//Recursive constructor invocation Employee(String, int)
}
Employee (String newName, int newAge) {
this();//Recursive constructor invocation Employee(String, int)
name = newName;
age = newAge;
}
void print(){
print(age);
}
void print(int age) {
print();
}
}*/


//The instance initializer blocks are executed after an implicit or explicit call to the parent class’s constructor
/*
 * Child constructor
Child initialization block
Parent constructor
Parent initialization block       
 */
class Instrument {
	Instrument() {
		System.out.println("Instrument:constructor");
	}
}
public class InstanceInitializer extends Instrument {
	public InstanceInitializer() {
		System.out.println("InstanceInitializer:constructor");
	}
	{
		System.out.println("InstanceInitializer:instance initializer");
	}
	public static void main(String[] args) {
		new InstanceInitializer();
	}
}