package com.javaconcurrency.ReadWriteLockExp;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.atomic.AtomicReference;

public class ReentrantReadWriteLockEx {

	public static void main(String[] args) {
		BusRWL b1=new BusRWL();
		
		b1.board();
		
		b1.busOnItsWay();
		b1.board();
		b1.busReadchedDestination();
		
		

	}

}
class BusRWL{
	ReentrantReadWriteLock rrwl=new ReentrantReadWriteLock();
	public void board(){
		System.out.println(Thread.currentThread().getName());
		rrwl.readLock().lock();
		System.out.println("bus boarded");
		
	}
	public void busOnItsWay(){
		System.out.println(Thread.currentThread().getName());
		//rrwl.readLock().unlock();
		rrwl.writeLock().lock();//cannot get lock as redaLock is  not unloacked [in code: exclusiveOwner thread is 
		//null and it checks for equality with the current thread.hence cannot aquire the lock :  if (w == 0 || current != getExclusiveOwnerThread()) of tryAcquire method of Sync line no. 400]
		System.out.println("bus on its way");
		
	}
	public void busReadchedDestination(){
		System.out.println(Thread.currentThread().getName());
		if(!rrwl.writeLock().isHeldByCurrentThread())
		{
			System.out.println("curent thread does not hold write lock");
		}
		
		rrwl.writeLock().unlock();

		System.out.println("bus reached destination");
		
	}
}