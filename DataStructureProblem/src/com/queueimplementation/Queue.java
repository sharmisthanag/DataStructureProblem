package com.queueimplementation;

import java.util.NoSuchElementException;


public class Queue {

	public static void main(String[] args) {
		MyQueue myStack=new MyQueue(5);
		myStack.insert("1");myStack.insert("2");myStack.insert("3");myStack.insert("4");myStack.insert("5");//myStack.insert("6");
		System.out.println(myStack.peek());
		System.out.println(myStack.remove());
		System.out.println(myStack.peek());
		myStack.display();

	}

}
class MyQueue{
	private int front;
	private int rear;
	private String[] myarray;
	private int size;
	public MyQueue(int i){
		this.size=i;
		this.front=-1;
		this.rear=-1;
		this.myarray=new String[i];
	}
	public void insert(String s){
		if(rear == size-1){
			throw new IndexOutOfBoundsException("Queue Overflow");
		}
		else{
			myarray[++rear]=s;
			if(front == -1){
				front=0;
			}
			
		}
	}
	public String remove(){
		if(isEmpty()){
			throw new NoSuchElementException("Underflow Exception");
		}
		else{
			String s=myarray[front];
			if(front == rear){
				front = -1;
				rear =-1;
			}
			else{
				front++;
			}
			return s;
		}		
	}
	public String peek(){
		if(isEmpty()){
			throw new NoSuchElementException("Underflow Exception");
		}
		return myarray[front];
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println("Empty Queue");;
		}
		for(int i=front;i<=rear;i++){
			System.out.println(myarray[i]);
		}
	}
	private boolean isEmpty() {
		return front == -1;
	}

}