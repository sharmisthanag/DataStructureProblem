package com.java8.test2.ThreadChap10;

import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptively {

	public static void main(String[] args) {
		LockLock l=new LockLock();
		Thread t=new Thread(l,"t");
		Thread t1=new Thread(l,"t1");
		t1.start();t.start();t.interrupt();

	}

}
class LockLock implements Runnable{
	ReentrantLock r=new ReentrantLock();

	@Override
	public void run() {
		int i=10;
		try {
			r.lockInterruptibly();
			//Thread.sleep(1000);
			System.out.println("lock aquired by "+Thread.currentThread().getName());
			while(true){
				if(r.isLocked() ==false) break;
				i++;
			}
			
		} catch (Exception e) {
			System.out.println("Catch for thread :"+Thread.currentThread().getName());
		}
		finally {
			System.out.println("Trying to unlock"+Thread.currentThread().getName());
			r.unlock();
		}
		
	}
	
}