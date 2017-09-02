package com.java8.test2.ThreadChap10;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//http://javarevisited.blogspot.com/2012/02/producer-consumer-design-pattern-with.html#ixzz4hxjwXtoT

public class ProducerConsumerWithBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		//Creating shared object
		BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<Integer>(10);

		//Creating Producer and Consumer Thread
		Thread prodThread = new Thread(new Producerr(sharedQueue));
		Thread consThread = new Thread(new Consumerr(sharedQueue));

		//Starting producer and Consumer thread
		prodThread.start();
		consThread.start();



	}

}
class Producerr implements Runnable{
	private static int i=0;

	private final BlockingQueue<Integer> sharedQueue;
	public Producerr(BlockingQueue<Integer> sharedQueue){
		this.sharedQueue = sharedQueue;
	}
	@Override
	public void run() {
		while(sharedQueue.size()>10){
			System.out.println("full bucket");
		}
		/*for(int i=0;i<10;i++){*/
		while(true){
			try {

				System.out.println("produced->"+i);

				sharedQueue.put(i++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//}

	}
}
class Consumerr implements Runnable{
	private final BlockingQueue<Integer> sharedQueue;
	public Consumerr(BlockingQueue<Integer> sharedQueue){
		this.sharedQueue = sharedQueue;
	}
	@Override
	public void run() {
		while(sharedQueue.size()==0){
			System.out.println("empty nothing to have");
		}
		//for(int i=0;i<10;i++){
		while(true){
			try {					

				System.out.println("consumed->"+sharedQueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//}

	}
}