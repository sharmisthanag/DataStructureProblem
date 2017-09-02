package com.java8.test.exceptions;

public class PrimitiveValueReturedFromCatchBlock {

	public static void main(String[] args) {
		System.out.println(new PrimitiveValueReturedFromCatchBlock().method());

	}
	
	public int method(){
		int i=10;
		try{
			System.out.println("hello");
			throw new Exception("ex");
		}
		catch(Exception e){
			i=i+2;
			return i;
		}
		finally{
			System.out.println("final block ");
			i=i+2;
			System.out.println(i);
			//return i;
		}
	}

}
