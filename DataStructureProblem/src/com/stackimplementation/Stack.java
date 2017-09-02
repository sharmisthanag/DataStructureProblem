package com.stackimplementation;

public class Stack {

	public static void main(String[] args) {
		MyStack myStack=new MyStack(5);
		myStack.push("1");myStack.push("2");myStack.push("3");myStack.push("4");myStack.push("5");myStack.push("6");
		System.out.println(myStack.peek());
System.out.println(myStack.pop());
System.out.println(myStack.peek());
myStack.printStack();
Object o=new Object();

	}

}
class MyStack{
	//private static native void registerNatives();
	private int size;
	private String[] myArray;
	private int top;
	public MyStack(int i){
		this.size=i;
		this.myArray=new String[i];
		top=-1;
	}
	public void push(String s){
		if(top == size-1){
			System.out.println("stack overflow");
		}
		else{
			myArray[++top]=s;
		}
	}
	public String pop(){
		if(top==-1){
			return "empty stack";
			
		}
		return myArray[top--];
		
	}
	public String peek(){
		if(top==-1){
			return "empty stack";
		}
		return myArray[top];
	}
	public void printStack(){
		for(int i=top;i>=0;i--){
			System.out.println(myArray[i]);
		}
	}
}