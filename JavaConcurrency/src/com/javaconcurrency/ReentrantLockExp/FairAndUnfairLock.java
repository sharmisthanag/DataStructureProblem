package com.javaconcurrency.ReentrantLockExp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairLock {

	public static void main(String[] args) {

		BusFU BusFU=new BusFU("MW1");
		StudentFU s=new StudentFU(BusFU, "sharmistha");
		StudentFU s1=new StudentFU(BusFU, "ritam");
		StudentFU s2=new StudentFU(BusFU, "shreemoyee");
		StudentFU s3=new StudentFU(BusFU, "sushmita");

		s.start();
		s1.start();
		s2.start();
		s3.start();
		System.out.println("all started");
		
	

	}

}


class StudentFU extends Thread{
	String name;
	BusFU BusFU;
	StudentFU(BusFU BusFU,String name){
		this.name = name;
		this.BusFU = BusFU;
	}
	public void run(){
		try {
			System.out.println("before call lock+"+this.name);Thread.currentThread().sleep(100);
			BusFU.lock.lockInterruptibly();
			BusFU.lock.lockInterruptibly();
			try{
				System.out.println(this.name+" lock to board BusFU : "+BusFU.name);
				BusFU.boardBusFU(name);
			}
			finally{
				BusFU.lock.unlock();
			}

		} catch (InterruptedException e) {
			System.out.println(name + ": Interrupted!!");
			System.out.println(Thread.currentThread().getName());
			Thread.currentThread().interrupt();
		}

	}
}
class BusFU{
	String name;
	Lock lock=new ReentrantLock(true);
	public BusFU(String string) {
		this.name = string;
	}
	public void boardBusFU(String StudentFUName){
		System.out.println(StudentFUName + ": boarded"+this.name);
	}
}
