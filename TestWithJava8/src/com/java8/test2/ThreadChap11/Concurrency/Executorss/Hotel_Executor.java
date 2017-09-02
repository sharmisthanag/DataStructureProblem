package com.java8.test2.ThreadChap11.Concurrency.Executorss;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/*
 * If you don’t want your Callable to return a value, you can create
it using Callable<Void>.
 */
public class Hotel_Executor implements Executor {
	final Queue<Runnable> custQueue = new ArrayDeque<>();
	public void execute(Runnable r) {
		synchronized(custQueue) {
			custQueue.offer(r);
		}
		try {
			processEarliestOrder();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*private void processEarliestOrder() {
		synchronized(custQueue) {
			Runnable task = custQueue.poll();
			task.run();
		}
	}*/
	private void processEarliestOrder() throws InterruptedException {
		synchronized(custQueue) {
			Thread.currentThread().sleep(100);
			Runnable task = custQueue.poll();
			new Thread(task).start();
		}
	}
	public static void main(String args[]) {
		Hotel_Executor hotel = new Hotel_Executor();
		hotel.execute(new Order("tea"));
		hotel.execute(new Order("coffee"));
		hotel.execute(new Order("burger"));
	}
}
class Order implements Runnable {
	String name;
	Order(String name) {this.name = name;}
	public void run() {
		System.out.println(name);
	}
}

class Order1 implements Callable<Void> {
	String name;
	Order1(String name) {this.name = name;}
	@Override
	public Void call() throws Exception {
		System.out.println(name);
		if (name.equalsIgnoreCase("berry"))
			throw new Exception("Berry unavailable");
		return null;
	}
}