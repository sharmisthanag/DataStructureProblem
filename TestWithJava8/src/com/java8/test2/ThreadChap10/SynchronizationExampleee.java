package com.java8.test2.ThreadChap10;

public class SynchronizationExampleee{
	 private static volatile SynchronizationExampleee synchronizationExample = new SynchronizationExampleee();
	 public static void main(String ar[]){
	 // hello();
	  
	  Thread t1=new Thread(new Runnable() {
		
		@Override
		public void run() {
			hello();
			
		}
	},"hh");
	  t1.start();
	  
	 Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				hello();
				
			}
		},"gg");
	 t2.start();
	 }
	  
	 private static void hello(){
	  synchronized (synchronizationExample) {
	    System.out.println("Before making reference null+"+Thread.currentThread().getName());
	   
	    try {
			Thread.sleep(1000);
			 synchronizationExample = null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("After making reference null+"+Thread.currentThread().getName());
	  }
	  System.out.println("unlocked by=>"+Thread.currentThread().getName());
	 }
	}
