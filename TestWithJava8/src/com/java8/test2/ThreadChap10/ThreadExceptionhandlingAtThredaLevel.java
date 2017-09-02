package com.java8.test2.ThreadChap10;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadExceptionhandlingAtThredaLevel {

	public static void main(String[] args) {
		Thread t1 = new Thread(new WorkerThread());
		t1.setName("T");

		t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
			@Override
			public void uncaughtException(Thread t, Throwable e){
				System.out.println("Thread Exception Handler :Thread Name :"+t.getName() + " Message :"+e.getMessage());
			}
		});
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler(){
			@Override
			public void uncaughtException(Thread t, Throwable e){
				System.out.println("Default Thread Exception Handler :Thread Name :"+t.getName() + " Message :"+e.getMessage());
			}
		});
		t1.start();

		Thread t11 = new Thread(new WorkerThread());
		t11.setName("T1");

		/*t11.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
		        @Override
		 public void uncaughtException(Thread t, Throwable e){
		    System.out.println("Thread Exception Handler :Thread Name :"+t.getName() + " Message :"+e.getMessage());
		        }
		});*/
		/*t11.setUncaughtExceptionHandler(new UncaughtExceptionHandler(){
			@Override
			public void uncaughtException(Thread t, Throwable e){
				System.out.println("Thread Exception Handler :Thread Name :"+t.getName() + " Message :"+e.getMessage());
			}
		});*/
		t11.start();

	}

}
class WorkerThread extends Thread{
	public void run(){
		throw new RuntimeException("run run");
	}
}