package com.javaconcurrency.ReentrantLockExp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptibleLock_2 {

	public static void main(String[] args) throws InterruptedException {
		Bus bus=new Bus("MW1");
		Student s=new Student(bus, "sharmistha");
		Student s1=new Student(bus, "ritam");
		Student s2=new Student(bus, "shreemoyee");
		Student s3=new Student(bus, "sushmita");


		s2.start();
		s3.start();
		s.start();
		s1.start();
		System.out.println("all started");
		//Thread.currentThread().sleep(200000);
		s.interrupt();
		//s1.interrupt();

	}

}
class Student extends Thread{
	String name;
	Bus bus;
	Student(Bus bus,String name){
		this.name = name;
		this.bus = bus;
	}
	public void run(){
		try {
			System.out.println("before call lock+"+this.name);
			bus.lock.lockInterruptibly();
			try{
				System.out.println(this.name+" lock to board bus : "+bus.name);
				bus.boardBus(name);
			}
			finally{
				bus.lock.unlock();
			}

		} catch (InterruptedException e) {
			System.out.println(name + ": Interrupted!!");
			System.out.println(Thread.currentThread().getName());
			Thread.currentThread().interrupt();
		}

	}
}
class Bus{
	String name;
	Lock lock=new ReentrantLock();
	public Bus(String string) {
		this.name = string;
	}
	public void boardBus(String studentName){
		System.out.println(studentName + ": boarded"+this.name);
	}
}
//Book Example
/*public class Employee extends Thread {
	Bus bus; String name;
	Employee(String name, Bus bus) {
		this.bus = bus;
		this.name = name;
	}
	public void run() {
		try {
			bus.lock.lockInterruptibly();
			bus.boardBus(name);
		}
		catch (InterruptedException e) {
			System.out.println(name + ": Interrupted!!");
			Thread.currentThread().interrupt();
		}
		finally {
			bus.lock.unlock();
		}
	}
	public static void main(String args[]) {
		Employee e1 = new Employee("Paul", new Bus());
		e1.start();
		e1.interrupt();
	}
}
class Bus {
	Lock lock = new ReentrantLock();
	public void boardBus(String name) {
		System.out.println(name + ": boarded");
	}
}

O/P
Paul: Interrupted!!
Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
	at java.util.concurrent.locks.ReentrantLock$Sync.tryRelease(Unknown Source)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.release(Unknown Source)
	at java.util.concurrent.locks.ReentrantLock.unlock(Unknown Source)
	at com.javaconcurrency.Employee.run(Employee.java:82)

*/