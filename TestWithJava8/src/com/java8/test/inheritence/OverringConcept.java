package com.java8.test.inheritence;

public class OverringConcept {

	public static void main(String[] args) {
		new Prrogrammer().run();


	}

}
class Emmmployee {
	String run() {
		System.out.println("Emp-run");
		return null;
	}
}

class Prrogrammer extends Emmmployee{
	String run() {
		System.out.println("Programmer-run");
		return null;
	}
}
