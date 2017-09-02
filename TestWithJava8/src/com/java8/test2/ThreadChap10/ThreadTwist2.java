package com.java8.test2.ThreadChap10;

public class ThreadTwist2 {
	public static void main(String args[]) {
		Thread sing = new Singg();
		sing.start();
		Thread.yield();
		throw new RuntimeException("main");
	}
}
class Singg extends Thread{
	public void run() {
		
		System.out.println("Singing");
		Thread.yield();
		throw new RuntimeException("run");
	}
}