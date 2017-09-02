package com.java8.test.methodOverloading;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OverLoading {

	public static void main(String[] args) {
		KKK k=new KKK();
		k.add(1l,2);
		

	}

}
class KKK{
	public int add(long l,int i){
		return (int) (l+i);
	}
	public int add(int i,long l){
		return (int) (l+i);
	}
	
}
interface ITest{
	 Object test(Object o) throws IOException;
	}
	 
	class CTest implements ITest{
	 @Override
	 public synchronized String test(Object o) throws IOException, FileNotFoundException, EOFException, 
     StackOverflowError, IndexOutOfBoundsException{
	  return "hello";
	 }
	}