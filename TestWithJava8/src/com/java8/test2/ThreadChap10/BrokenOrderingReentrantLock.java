package com.java8.test2.ThreadChap10;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
 
public class BrokenOrderingReentrantLock implements Runnable {
    private ReentrantLock lock1 = new ReentrantLock();
    private ReentrantLock lock2 = new ReentrantLock();
    private Condition condition = lock1.newCondition();
 
    public static void main(String[] args) throws InterruptedException {
        BrokenOrderingReentrantLock runnable = new BrokenOrderingReentrantLock();
        Thread thread1 = new Thread(runnable, "thread1");
        Thread thread2 = new Thread(runnable, "thread2");
        thread1.start();
        Thread.sleep(500);
        thread2.start();
    }
 
    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            lock1.lock();
            System.out.println(threadName+" lock1.getHoldCount()==>"+lock1.getHoldCount());
            try{
                System.out.println(threadName + " has lock1");
                lock2.lock();
                System.out.println(threadName+ " lock2.getHoldCount()==>"+lock2.getHoldCount());
                try{
                    System.out.println(threadName + " has lock2");
                    lock1.lock();
                    System.out.println(threadName+" lock1.getHoldCount()==>"+lock1.getHoldCount());
                    try{
                        System.out.println(threadName + " reenters lock1");
                        condition.await(1, TimeUnit.SECONDS);
                        System.out.println(threadName +" lock1.getHoldCount() after await==>"+lock1.getHoldCount());
                    } finally {
                        lock1.unlock();
                        System.out.println("lock1.getHoldCount() after unlock lock1==>"+lock1.getHoldCount());
                    }
                } finally {
                    lock2.unlock();
                    System.out.println("lock2.getHoldCount() after unloc lock2==>"+lock2.getHoldCount());
                }
            } finally {
                lock1.unlock();
                System.out.println("lock1.getHoldCount() after unlock lock1==>"+lock1.getHoldCount());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}