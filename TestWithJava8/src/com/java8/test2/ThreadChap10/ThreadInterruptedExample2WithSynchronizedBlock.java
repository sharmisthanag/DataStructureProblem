package com.java8.test2.ThreadChap10;

public class ThreadInterruptedExample2WithSynchronizedBlock {

	public static void main(String[] args) {
		Myrunnable234 m=new Myrunnable234();
		Thread th=new Thread(m);th.start();th.interrupt();
		Thread th1=new Thread(m);th1.start();th1.interrupt();
		Thread th2=new Thread(m);th2.start();th2.interrupt();
		Thread th3=new Thread(m);th3.start();th3.interrupt();
		Thread th4=new Thread(m);th4.start();th4.interrupt();
		Thread th5=new Thread(m);th5.start();th5.interrupt();
		Thread th6=new Thread(m);th6.start();th6.interrupt();
		
		System.out.println("main finished");

	}

}
class Myrunnable234 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" blocked");
		synchronized(this){
			System.out.println("Aquired lock"+Thread.currentThread().getName());
			for(int i=0;i<100000;i++) {
				System.out.print("");
			}
		}
		System.out.println();
		System.out.println(Thread.currentThread().getName()+" released lock");
		
	}
	
}