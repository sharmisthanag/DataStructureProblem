package com.java8.test2.ThreadChap10;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintEvenOddSequentiallyWithTwoThread {


	public static void main(String[] args) {
		AtomicInteger ai=new AtomicInteger();
		Object obj=new Object();
		Thread th=new Thread(new PrintOdd(ai,obj), "Th_Odd");
		Thread th1=new Thread(new PrintEven(ai,obj),"Th_Even");
		th.start();
		th1.start();


	}

}
class PrintEven implements Runnable{
	AtomicInteger ai;
	Object obj ;
	PrintEven(AtomicInteger ai,Object obj){
		this.ai = ai;
		this.obj = obj;
	}
	@Override
	public void run() {
		while(true){
			synchronized (obj) {
				if((ai.get() & 1)==0){
					System.out.println(Thread.currentThread().getName()+"-"+ai.getAndIncrement());
				}
				obj.notifyAll();
			}
		}
	}
}
class PrintOdd implements Runnable{
	AtomicInteger ai;
	Object obj;
	PrintOdd(AtomicInteger ai,Object obj){
		this.ai = ai;
		this.obj = obj;
	}
	@Override
	public void run() {
		while(true){
			synchronized (obj) {
				if(ai.get()==50){
					break;	
				}
				if((ai.get() & 1)==1){
					System.out.println(Thread.currentThread().getName()+"-"+ai.getAndIncrement());
					obj.notifyAll();
				}

				
			}
		}
	}
}