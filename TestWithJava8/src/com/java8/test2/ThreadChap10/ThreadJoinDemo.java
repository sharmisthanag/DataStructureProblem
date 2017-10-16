package com.java8.test2.ThreadChap10;

public class ThreadJoinDemo extends Thread{
	static ThreadJoinDemo thread1;
	static Object obj=new Object();

	public void run(){
		try{
			synchronized(thread1){
				synchronized(obj) {
					System.out.println(Thread.currentThread().getName()+" acquired a lock on thread1");
					Thread.sleep(5000);
					System.out.println(Thread.currentThread().getName()+" completed");
				}
			}
		}
		catch (InterruptedException e){ }
	}

	public static void main(String[] ar) throws Exception{
		thread1 = new ThreadJoinDemo();
		thread1.setName("thread1");
		thread1.start();

		synchronized(thread1){
			synchronized(obj) {
				System.out.println(Thread.currentThread().getName()+" acquired a lock on thread1");
				Thread.sleep(1000);
				thread1.join();
				System.out.println(Thread.currentThread().getName()+" completed");
			}
		}
	}
}
