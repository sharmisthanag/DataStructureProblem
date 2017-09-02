package com.java8.test2.ThreadChap10;

/*enum Seasons{SPRING,SUMMER}
public class ETree extends Thread {
	String name;
	public ETree(String name) {this.name = name;}
	public void run() {
		for (Seasons season : Seasons.values())
			System.out.print(name + "-" + season + " ");
	}
	public static void main(String args[]) {
		ETree oak = new ETree("Oak"); oak.start();
		ETree maple = new ETree("Maple"); maple.start();
	}
}*/

/*public class ETree {
	public static void main(String[] args) {
		Thread bug = new Thread() {
			public void run() {
				System.out.print("check bugs");
			}
		};

		Thread reportQA = new Thread(bug);
		reportQA.run();
	}
}
 */

/*public class ETree implements Runnable {
	public void run() {
		System.out.println("eJava");
		start();//The method start() is undefined for the type ETree
	}
	public static void main(String... args) {
		new Thread(new ETree()).start();
	}
}
 */

class ELock{}
public class ETree implements Runnable {
	public void run() {
		synchronized(ELock.class) {
			System.out.println("Hand made paper");
		}
	}
	public static void main(String args[]) throws Exception {
		Thread epaper = new Thread(new ETree());
		epaper.start();
		synchronized(ELock.class) {
			System.out.println("lock aquired in main");
			epaper.join();
		}
	}
}