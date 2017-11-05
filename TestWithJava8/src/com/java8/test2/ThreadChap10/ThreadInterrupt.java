package com.java8.test2.ThreadChap10;

public class ThreadInterrupt {

	public static void main(String[] args) {
		Thread th=new Thread(()->{try {
			
			Thread.currentThread().sleep(10000);
			
		} catch (InterruptedException e) {
			System.out.println("Thread 1 "+Thread.currentThread().isInterrupted());
			Thread.currentThread().interrupt();
		}System.out.println("Thread 1");});
		th.start();
		
		th.interrupt();
		System.out.println("th.isInterrupted()==>"+th.isInterrupted());
		System.out.println("th.interrupted()==>"+th.interrupted());
		System.out.println("th.isInterrupted()==>"+th.isInterrupted());
		
	}

}
