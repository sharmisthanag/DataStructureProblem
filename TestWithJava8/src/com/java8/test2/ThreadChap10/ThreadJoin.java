package com.java8.test2.ThreadChap10;

/*
 * Method join() guarantees that the calling thread won’t execute
its remaining code until the thread on which it calls join() completes.
 */
public class ThreadJoin {

	public static void main(String[] args) {

		ScreenDesign design = new ScreenDesign(); design.start();
		Developer dev = new Developer(design);
		dev.code();
	

	}

}
class ScreenDesign extends Thread {
	public void run() {
		for (int i = 0; i < 50000; i++) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}
class Developer {
	ScreenDesign design;
	Developer(ScreenDesign design) {
		this.design = design;
	}
	public void code() {
		try {
			System.out.println("Waiting for design to complete");
			design.join(1);//this wait for 1milisec for completion
			//design.join();
			
			System.out.println("Coding phase start");
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
	}
}
