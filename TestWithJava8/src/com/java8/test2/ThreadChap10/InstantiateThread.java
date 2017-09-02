package com.java8.test2.ThreadChap10;

public class InstantiateThread {

	public static void main(String[] args) {
		MyThread mt=new MyThread();
		mt.start();
		MyRunnable mr=new MyRunnable();
		Thread th=new Thread(mr);
		th.start();

	}

}
class MyThread extends Thread{
	public void run(){
		System.out.println("in am in Mythread.class:"+MyThread.currentThread().getName());
	}
}
class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("in am in MyRunnable.class");
		
	}
	
}