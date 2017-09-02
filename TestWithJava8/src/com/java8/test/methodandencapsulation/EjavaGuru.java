package com.java8.test.methodandencapsulation;

public class EjavaGuru {

	public static void main(String[] args) {
		char c=10;
		System.out.println("--"+c);
		Course course = new Course();
		course.enroll(new Integer(12));
		course.enroll(true);
		course.enroll(new char['a']);
		course.enroll(10);
		course.enroll(c);
		//1
		String letters = "ABCD";
		//System.out.println(letters.substring(0,2).startsWith('A'));//good example
		
		//2
		StringBuilder sb=new StringBuilder();
		char[] ch={'R','2','3','j','a'};
		sb.append(ch, 1, 3);//StringBuilder java.lang.StringBuilder.append(char[] str, int offset, int len)
		System.out.println(sb);
		//3
		StringBuilder sb1=new StringBuilder();
		String ch1="R23ja";
		sb1.append(ch1, 1, 3);//StringBuilder java.lang.StringBuilder.append(CharSequence s, int start, int end)
		System.out.println(sb1);
		//4
		int[][] multiarry=new int[2][];//[][10] is invalid and will have compilation error
		int[] test=new int['c'];
		System.out.println(test);
		int[] test1=new int[04];
		test1[3]=10;
		System.out.println(test1[3]);
	}
}
class Course{
	void enroll(long duration){
		System.out.println("long");
	}
	void enroll(int duration){
		System.out.println("int");
	}
	void enroll(Integer s){
		System.out.println("Integer");
	}
	void enroll(String s){
		System.out.println("String");
	}
	void enroll(Object o){
		System.out.println("Object");
	}
}