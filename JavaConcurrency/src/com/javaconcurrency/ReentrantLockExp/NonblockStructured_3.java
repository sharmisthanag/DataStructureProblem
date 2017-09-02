package com.javaconcurrency.ReentrantLockExp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//lock in one method and release in another
public class NonblockStructured_3 {

	public static void main(String[] args) {
		BusTC b=new BusTC();
		b.boardBus();
		System.out.println("");
		b.unBoard();


	}

}
class BusTC{
	ReentrantLock lock=new ReentrantLock(true);
	public void boardBus(){
		lock.lock();
	}
	public void ticketCheck(){
		lock.unlock();
	}
	public void unBoard(){
		if(lock.isHeldByCurrentThread()){
			System.out.println("Please provide ticket");
		}
	}
	
}