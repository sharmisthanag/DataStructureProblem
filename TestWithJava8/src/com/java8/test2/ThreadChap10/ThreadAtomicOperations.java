package com.java8.test2.ThreadChap10;

/*
 * 
down vote
volatile:

volatile is a keyword. volatile forces all threads to get latest value of the variable from main memory instead of cache. No locking is required to access volatile variables. All threads can access volatile variable value at same time.

Using volatile variables reduces the risk of memory consistency errors, because any write to a volatile variable establishes a happens-before relationship with subsequent reads of that same variable.

This means that changes to a volatile variable are always visible to other threads. What's more, it also means that when a thread reads a volatile variable, it sees not just the latest change to the volatile, but also the side effects of the code that led up the change.

When to use: One thread modifies the data and other threads have to read latest value of data. Other threads will take some action but they won't update data.

AtomicXXX:

AtomicXXX classes support lock-free thread-safe programming on single variables. These AtomicXXX classes (like AtomicInteger) resolves memory inconsistency errors / side effects of modification of volatile variables, which have been accessed in multiple threads.

When to use: Multiple threads can read and modify data.

synchronized:

synchronized is keyword used to guard a method or code block. By making method as synchronized has two effects:

First, it is not possible for two invocations of synchronized methods on the same object to interleave. When one thread is executing a synchronized method for an object, all other threads that invoke synchronized methods for the same object block (suspend execution) until the first thread is done with the object.
Second, when a synchronized method exits, it automatically establishes a happens-before relationship with any subsequent invocation of a synchronized method for the same object. This guarantees that changes to the state of the object are visible to all threads.
When to use: Multiple threads can read and modify data. Your business logic not only update the data but also executes atomic operations

AtomicXXX is equivalent of volatile + synchronized even though the implementation is different. AmtomicXXX extends volatile variables + compareAndSet methods but does not use synchronization.
 */
import java.util.concurrent.atomic.AtomicInteger;

/*
 * volatile int v = 0;

Thread 1:
r1 = v;
r2 = r1 + 1;
v = r2;

Thread 2:
r3 = v;
r4 = r3 - 1;
v = r4;
 */
public class ThreadAtomicOperations {
	private static int i=0;
	
	public static void main(String[] args) {
		Thread th=new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread()+""+i++);
			}
		});
		th.start();
		//i++;
		Thread th1=new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread()+""+i--);
			}
		});
		th1.start();


		i--;
		System.out.println(i);

		//******************************************************8
		AtomicInteger i=new AtomicInteger(100);
		i.incrementAndGet();
		System.out.println(i);
	}

}
