package com.java8.test2.ThreadChap10;

/*As stated before, when a thread acquires a lock on the object monitor, no other
thread can execute any other synchronized method on the object until the lock is
released.
Multiple threads can concurrently execute methods with synchronized
statements if they acquire locks on monitors of separate objects.
*/
public class SynchronizedTest {

	public static void main(String[] args) {

		Book2 Book2 = new Book2(); //3
		for(int i=0;i<100;i++){
			Thread task = new OnlineBuy2(Book2); task.start();
		}
		Thread task3 = new OnlineReturn2(Book2); task3.start(); //6
		System.out.println(Book2.copiesSold);

	}

}
class Book2{
	int copiesSold = 0;
	public void newSale() { ++copiesSold; }
	public void returnBook2() { --copiesSold; }
}
class OnlineBuy2 extends Thread{
	private Book2 Book2;
	public OnlineBuy2(Book2 Book2) { this.Book2 = Book2; }
	synchronized public void run() { //1
		Book2.newSale();
	}
}
class OnlineReturn2 extends Thread{
	private Book2 Book2;
	public OnlineReturn2(Book2 Book2) { this.Book2 = Book2; }
	synchronized public void run() { //2
		Book2.returnBook2();
	}
}
