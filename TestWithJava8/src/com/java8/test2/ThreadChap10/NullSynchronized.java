package com.java8.test2.ThreadChap10;

import java.util.LinkedList;

public class NullSynchronized {

	public static void main(String[] args) {
		LinkedList l=null;
		Thread th=new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized(l){
					System.out.println("hello world");
				}
				
			}
		});
		th.start();
	}

}
