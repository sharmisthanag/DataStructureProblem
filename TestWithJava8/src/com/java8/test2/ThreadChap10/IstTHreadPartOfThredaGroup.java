package com.java8.test2.ThreadChap10;

public class IstTHreadPartOfThredaGroup {

	public static void main(String[] args) {
		System.out.println("Top Level Thread Group:" + Thread.currentThread().getThreadGroup().getParent().getName());
		 System.out.println("Main Thread Group:" + Thread.currentThread().getThreadGroup().getName());
System.out.println(Thread.currentThread().getThreadGroup());

	}

}
