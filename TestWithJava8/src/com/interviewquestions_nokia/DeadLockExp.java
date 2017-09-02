package com.interviewquestions_nokia;

public class DeadLockExp {

	public static void main(String[] args) throws InterruptedException {
		
		//Thread.currentThread().join();
		
		Thread th=new Thread("th");
		Thread th1=new Thread("th1");
		
		Thread th2=new Thread("th2");
		th.start();
		th1.start();
		th2.start();
		

	}

}
