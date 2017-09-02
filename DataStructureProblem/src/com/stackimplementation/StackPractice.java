package com.stackimplementation;

public class StackPractice {

	public static void main(String[] args) {
		MyStack1<String> myStack=new MyStack1<>(5);
		myStack.push("1");myStack.push("2");myStack.push("3");myStack.push("4");myStack.push("5");myStack.push("6");
		System.out.println(myStack.peek());
System.out.println(myStack.pop());
System.out.println(myStack.peek());
myStack.printStack();

	}

}
class MyStack1<T>{
	int size;
	T[] elements;
	int top;
	

	@SuppressWarnings("unchecked")
	public MyStack1(int i) {
		//this();super();
		elements = (T[])new Object[i];
		this.size = i;
	}

	public MyStack1() {
		// TODO Auto-generated constructor stub
	}

	public void printStack() {
		// TODO Auto-generated method stub
		
	}

	public char[] pop() {
		// TODO Auto-generated method stub
		return null;
	}

	public char[] peek() {
		// TODO Auto-generated method stub
		return null;
	}

	public void push(T obj) {
		// TODO Auto-generated method stub
		
	}
	
}