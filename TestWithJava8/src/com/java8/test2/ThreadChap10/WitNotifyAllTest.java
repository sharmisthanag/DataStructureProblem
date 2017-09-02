package com.java8.test2.ThreadChap10;

/*
 * You can use wait() and notify() method to implement inter-thread communication in Java. Not just one or two threads but multiple threads can communicate to each other by using these methods.
 * Always call wait(), notify() and notifyAll() methods from synchronized method or synchronized block otherwise JVM will throw IllegalMonitorStateException.
 * Always call wait and notify method from a loop and never from if() block, because loop test waiting condition before and after sleeping and handles notification even if waiting for the condition is not changed.
 * Always call wait in shared object e.g. shared queue in this example.
 */
import java.util.LinkedList;
import java.util.Queue;

public class WitNotifyAllTest {

	public static void main(String[] args) throws InterruptedException {
		Queue<Integer> q=new LinkedList<Integer>();
		Producer1 p=new Producer1(q,10);
		Consumer1 c=new Consumer1(q,10);
		Thread th = new Thread(p,"Producer1");
		Thread th1 = new Thread(c,"Consumer1");
		th.start();
		th1.start();

	}

}
class Producer1 implements Runnable{
	private Queue<Integer> q;
	private int maxSize;
	private static int count=0;
	Producer1(Queue<Integer> q,int maxSize){
		this.maxSize=maxSize;
		this.q=q;
	}
	@Override
	public void run() {
		while(q!=null){
			synchronized (q) {
				while(q.size() == maxSize){
					System.out.println("Wait for notify to make Queue empty");
					try {
						q.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				q.add(count++);
				System.out.println("produced="+q);
				q.notifyAll();
			}
		}
		
	}
}
class Consumer1 implements Runnable{
	private Queue<Integer> q;
	private int maxSize;
	private static int count=0;
	Consumer1(Queue<Integer> q,int maxSize){
		this.maxSize=maxSize;
		this.q=q;
	}
	@Override
	public void run() {
		while(q!=null){
			synchronized (q) {
				while(q.isEmpty()){
					System.out.println("Wait for notify to make Queue fill");
					try {
						q.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				q.remove();
				System.out.println("Consumed="+q);
				q.notifyAll();
			}
		}
		
	}
}