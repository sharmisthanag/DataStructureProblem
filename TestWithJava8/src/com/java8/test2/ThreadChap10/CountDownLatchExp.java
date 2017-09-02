package com.java8.test2.ThreadChap10;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExp {

    public static void main(String args[]) throws InterruptedException  {
        
        CountDownLatch latch = new CountDownLatch(2);
        Worker first = new Worker(1000, latch, "WORKER-1");
        Worker second = new Worker(2000, latch, "WORKER-2");
        Worker third = new Worker(3000, latch, "WORKER-3");
        Worker fourth = new Worker(4000, latch, "WORKER-4");
        
        first.start();
        second.start();
        third.start();
        fourth.start();
        System.out.println("main is waiting");
        // Main thread will wait until all thread finished
        latch.await();
        System.out.println("main is running");
        
        latch.await();
        
        System.out.println(Thread.currentThread().getName() + " has finished");

    }

}

class Worker extends Thread {
    private int delay;
    private CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch, String name) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println("before countdown of current thread+"+Thread.currentThread().getName());
            latch.countDown();
            System.out.println("before await of current thread+"+Thread.currentThread().getName());
            latch.await();
            System.out.println(Thread.currentThread().getName() + " has finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


