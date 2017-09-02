package com.java8.test.inheritence;


class Employee_ctb {
	String name = "Employee";
	void printName() {
		System.out.println(name);
	}
}
class Programmer_ctb extends Employee_ctb {
	String name = "Programmer";
	void printName() {
		System.out.println(name);
	}
}
class VariablesBoundAtCompileTime {
	public static void main(String[] args) {
		Employee_ctb emp = new Employee_ctb();
		Employee_ctb programmer = new Programmer_ctb();
		System.out.println(emp.name);
		System.out.println(programmer.name);
		emp.printName();
		programmer.printName();
	}
}