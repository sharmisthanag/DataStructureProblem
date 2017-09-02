package com.java8.test2.ThreadChap10;

import java.util.Set;

/*
 * When you call start() on a Thread instance, it creates a new thread of execution. A
thread of execution has a lifecycle: a thread is created, it might be paused, and eventually
it completes its execution.
You can’t guarantee that a thread with a higher priority will
always execute before a thread with a lower priority.
Each thread is created with a priority. Its range varies from 1 to 10, with 1 being the lowest
priority and 10 the highest priority. By default, a thread creates another thread with the
same priority as its own

You can call start() only once on a Thread instance when it’s
in the NEW state. Calling start() on a thread in any other state will throw
an IllegalThreadStateException.

Calling run() on a Thread instance doesn’t start a new thread
of execution. The run() continues to execute in the same thread
 */
public class ThreadTwist {
	public static void main(String args[]) {
		Thread sing = new Sing();
		Thread newThread = new Thread(sing);
		newThread.setPriority(1);
		newThread.start();
		//newThread.start();//java.lang.IllegalThreadStateException
		System.out.println("dancing");

		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		for(Thread t : threadSet)
			System.out.println(t + " --- " + t.getState());
	}
}
class Sing extends Thread{
	public void run() {
		System.out.println("Singing");
	}
}