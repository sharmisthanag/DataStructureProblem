package com.java8.test2.ThreadChap10;

public class ThreadExceptionhandlingAtThreadGroupLevel {

	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Default ThreadGroup Exception Handler :Thread Name :"+t.getName() + " Message :"+e.getMessage());

			}});
		ThreadGroup tr = new ThreadGroup("MyGroup"){
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("ThreadGroup Exception Handler :Thread Name :"+t.getName() + " Message :"+e.getMessage());
			}
		};


		Thread t1=new Thread(tr, new WorkerThreadd(), "t1");t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Thread level ThreadGroup Exception Handler :Thread Name :"+t.getName() + " Message :"+e.getMessage());
				
			}
		});t1.start();
		Thread t2=new Thread(tr, new WorkerThreadd(), "t2");t2.start();
		Thread t3=new Thread(tr, new WorkerThreadd(), "t3");t3.start();
		Thread t4=new Thread(tr, new WorkerThreadd(), "t4");t4.start();


	}

}
class WorkerThreadd extends Thread{
	public void run(){
		throw new RuntimeException("run run");
	}
}