package com.java8.test2.ThreadChap11.Concurrency.Executorss;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {

	public static void main(String[] args) {
		//ExecutorService e=Executors.newFixedThreadPool(3);
		ExecutorService e=Executors.newCachedThreadPool();
		e.execute(()->System.out.println("Thread1"));
		e.execute(()->{try {
			Thread.sleep(1000);
			System.out.println("Thread2");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
		e.execute(()->{try {
			Thread.sleep(1000);
			System.out.println("Thread3");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
		e.execute(()->System.out.println("Thread4"));
		e.execute(()->System.out.println("Thread5"));
		e.execute(()->{try {
			Thread.sleep(1000);
			System.out.println("Thread6");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}});
		//e.shutdown();
		//e.shutdown();
		e.shutdownNow();
		//e.execute(()->System.out.println("Thread7"));

	}

}
