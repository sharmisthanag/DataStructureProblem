package com.javaconcurrency.ReentrantLockExp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AcuireLockAndReturn_1 {

	public static void main(String[] args) throws InterruptedException {
		Inventory loc1 = new Inventory("Seattle"); loc1.stockCount = 100;;
		Inventory loc2 = new Inventory("LA"); loc2.stockCount = 200;
		Shipment s1 = new Shipment(loc1, loc2, 1);
		Shipment s2 = new Shipment(loc2, loc1, 10);
		s1.start();
		Thread.currentThread().sleep(1000);
		s2.start();
		
		System.out.println("In main "+loc1.getStockCount()+" of :"+loc1.getName());
		System.out.println("In main "+loc2.getStockCount()+" of :"+loc2.getName());
	}

}
class Inventory{
	int stockCount;
	private String name;
	Lock lock=new ReentrantLock();
	public Inventory(String name){this.name=name;}
	public int getStockCount() {
		return stockCount;
	}
	public void stockIn(int stockCount) {
		this.stockCount += stockCount;
	}
	public void stockOut(int stockCount) {
		this.stockCount -= stockCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class Shipment extends Thread{
	Inventory iInventoryIn,iInventoryOut;
	int stock;
	public Shipment(Inventory iInventory1,Inventory iInventory2,int stock){
		this.iInventoryIn = iInventory1;
		this.iInventoryOut = iInventory2;
		this.stock = stock;		
	}
	
	public void run() {
		if(iInventoryIn.lock.tryLock() /*&& iInventoryIn.lock.tryLock()*/){
			if(iInventoryOut.lock.tryLock()){
				System.out.println("//Before==>");
				System.out.println(iInventoryIn.getStockCount()+" of :"+iInventoryIn.getName());
				System.out.println(iInventoryOut.getStockCount()+" of :"+iInventoryOut.getName());
				
				iInventoryIn.stockIn(stock);
				iInventoryOut.stockOut(stock);
				
				System.out.println("//After==>");
				System.out.println(iInventoryIn.getStockCount()+" of :"+iInventoryIn.getName());
				System.out.println(iInventoryOut.getStockCount()+" of :"+iInventoryOut.getName());

				iInventoryOut.lock.unlock();
				iInventoryIn.lock.unlock();
			}
			else{
				System.out.println("iInventoryOut.lock is not available:"+iInventoryOut.getName());
			}
			
		}
		else{
			System.out.println("iInventoryIn.lock is not available:"+iInventoryIn.getName());
		}
		
	}
	
}