package com.java8.test2.Exceptions;

import java.io.IOException;
import java.util.Date;

public class ExceptionExample {
	public static void main(String[] args) {
		//test();
		System.out.println(test());
	}
	/*private static void test(){
		try{
			System.out.println("In try");
			throw new ArithmeticException();
		} catch(Exception e){
			System.out.println("In catch");
			throw new ArrayIndexOutOfBoundsException();
		} finally{
			System.out.println("In finally");
			throw new NullPointerException();
		}
	}*/
	/*private static int test(){
		int i=10;
		try{
			System.out.println("In try");
			i=20;
			return i;
		} catch(Exception e){
			System.out.println("In catch");
			i=30;
			return i;
		} finally{
			//i=40;
			System.out.println("In finally");
			return i;
		}
	}*/
	/*private static int test(){
		int a = 10;
		try {
			return a;
		} catch (Exception e) {
			a = 20;
			System.out.println("a in catch : "+a);
		}finally{
			a = 30;
			System.out.println("a in finally : "+a);
		}
		a = 40;
		System.out.println("a outside try-catch : "+a);
		return a;
	}*/
	/*private static long test(){
		  Date a=new Date();
		  try {
			  System.out.println(a.getTime());
			  Thread.sleep(10021);
			  
		   return a.getTime();
		  } catch (Exception e) {
		   a = new Date();
		   System.out.println("a in catch : "+a.getTime());
		  }finally{
		   a= new Date();
		   System.out.println("a in finally : "+a.getTime());
		   //return a.getTime();
		  }
		return 0;
		  
		 }*/
	/*private static long test(){
		  long a=new Date().getTime();
		  try {
			  System.out.println(a);
			  Thread.sleep(1021);
			  
		   return a;
		  } catch (Exception e) {
		   a = new Date().getTime();
		   System.out.println("a in catch : "+a);
		  }finally{
		   a= new Date().getTime();
		   System.out.println("a in finally : "+a);
		   //return a;
		  }
		return a;
		  
		 }*/
	private static Date test(){
		  Date a=new Date();
		  try {
			  System.out.println(a);
			  Thread.sleep(10021);
			  
		   return a;
		  } catch (Exception e) {
		   a = new Date();
		   System.out.println("a in catch : "+a);
		  }finally{
		   a= new Date();
		   System.out.println("a in finally : "+a);
		   //return a.getTime();
		  }
		return null;
		  
		 }
}
interface InterfaceTest{ 
	 public void test() throws Exception; 
	}
	 /*
	  *  the class which implements InterfaceTest need to define method test() which may not throws exception OR either 
                throws Exception class or Exception class adding any number of subclass of Exception and is perfectly valid 
                inherited test() method. 
                Throwing Throwable will not compile the code successfully
	  */
	class ExceptionExampleq implements InterfaceTest{ 
	 public void test() throws Exception, IOException, RuntimeException, Error {
	 }
	  
	 
	}