package com.java8.test2.ThreadChap10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExp {

    public static void main(String args[]) throws InterruptedException, BrokenBarrierException {
        
        CyclicBarrier barrier = new CyclicBarrier(4,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Running after all thread calls await!!Then thread rest part of code will get executed");
				
			}
		});
        Party first = new Party(1000, barrier, "PARTY-1");
        Party second = new Party(1000, barrier, "PARTY-2");
        Party third = new Party(1000, barrier, "PARTY-3");
        Party fourth = new Party(1000, barrier, "PARTY-4");
        Party fifth = new Party(1000, barrier, "PARTY-5");
        Party sixth = new Party(1000, barrier, "PARTY-6");
        Party seventh = new Party(1000, barrier, "PARTY-7");
        Party eighth = new Party(1000, barrier, "PARTY-8");
        
        first.start();
        second.start();
        third.start();
        fourth.start();
        fifth.start();
        sixth.start();
        seventh.start();
        eighth.start();
        
        System.out.println(Thread.currentThread().getName() + " has finished");

    }

}

class Party extends Thread {
    private int duration;
    private CyclicBarrier barrier;

    public Party(int duration, CyclicBarrier barrier, String name) {
        super(name);
        this.duration = duration;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName() + " is calling await()");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " has started running again");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}


