package com.java8.test2.ThreadChap10;

/*
 * It makes the currently executing thread give up its execution and sleep.
It can be called from any piece of code—all code is executed by some thread. If it’s
placed in Runnable’s run(), it will cause the thread to sleep. Placed otherwise, it will
make the calling thread sleep.
 */
public class ThreadSleep {

	public static void main(String[] args) {


		System.out.println("1");
		ThreadSleepTest f=new ThreadSleepTest();
		System.out.println("2");
		ThreadSleepTest1 f1=new ThreadSleepTest1();
		System.out.println("3");
		f1.start();
		System.out.println("4");

	}

}
class ThreadSleepTest {
	int i=10;
	public ThreadSleepTest(){
		i=100;
		System.out.println("in constructor of ThreadSleepTest="+i);
		
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class ThreadSleepTest1 extends Thread{
	int i=20;
	public ThreadSleepTest1(){
		i=200;
		System.out.println("in constructor of ThreadSleepTest1="+i);
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		System.out.println("in run of ThreadSleepTest1 before sleeps "+Thread.currentThread());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("in run of ThreadSleepTest1 after sleeps "+Thread.currentThread());
	}
	
}