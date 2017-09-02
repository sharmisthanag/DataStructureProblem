package com.java8.test2.JavaClassDesignChap2;


public class InnerClassTwist {
	static int countOfInnerClassTwist=0;
	String color = "red";
	Petal[] petals;
	Petal petalss;
	private class Petal {
		public Petal() {System.out.println(this.color+","+color+"+"+countOfInnerClassTwist++);}
		String color = "purple"; // line 1
		static final int count = 3; // line 2
	}
	InnerClassTwist() {
		petals = new Petal[2]; // line 3
		petals[0]=new Petal();
		petals[1]=new Petal();
		petalss = new Petal(); // line 3
	}
	public static void main(String args[]) {
		new InnerClassTwist();
		new InnerClassTwist();
	}
}