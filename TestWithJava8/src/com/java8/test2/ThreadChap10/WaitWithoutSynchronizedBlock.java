package com.java8.test2.ThreadChap10;

public class WaitWithoutSynchronizedBlock {
	static Object j=new Object();
	public static void main(String[] args) throws InterruptedException {
		
		/*synchronized(j){
		j.wait();
		}
		*/
		j.wait();
		
		Runnable r=new Runnable() {
			
			@Override
			public void run() {
				System.out.println("kk");
				
			}
		};
		
	}

}
