package com.java8.test2.ThreadChap10;

public class ThreadInterleave {

	public static void main(String[] args) throws InterruptedException {
		Book book = new Book("Java");
		
		for(int i=0;i<100;i++){
			Thread task = new OnlineBuy(book); task.start();
		}
		Thread task3 = new OnlineReturn(book); task3.start();
		//Thread.sleep(10);
		System.out.println(book.copiesSold);
	}

}
class Book{
	String title;
	int copiesSold = 0;
	Book(String title) {
		this.title = title;
	}
	public synchronized void newSale() {
		++copiesSold;
	}
	public synchronized void returnBook() {
		--copiesSold;
	}
}
class OnlineBuy extends Thread{
	private Book book;
	public OnlineBuy(Book book) {
		this.book = book;
	}
	@Override
	public void run() {
		book.newSale();
	}
}
class OnlineReturn extends Thread{
	private Book book;
	public OnlineReturn(Book book) {
		this.book = book;
	}
	@Override
	public void run() {
		book.returnBook();
	}
}