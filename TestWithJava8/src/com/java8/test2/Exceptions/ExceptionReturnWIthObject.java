package com.java8.test2.Exceptions;

public class ExceptionReturnWIthObject {

	public static void main(String[] args) {
		System.out.println(test());

	}

	private static Ex test() {
		Ex e=new Ex();
		e.i=20;
		try{
			return e;
		}
		catch(Exception e1){
			e.i=100;
		}
		finally{
			e.i=30;
			//return e;
		}
		return e;
	}

}
class Ex{
	int i=10;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return "Ex [i=" + i + "]";
	}
}