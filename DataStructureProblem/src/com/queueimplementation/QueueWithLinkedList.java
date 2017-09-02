package com.queueimplementation;

public class QueueWithLinkedList {

	public static void main(String[] args) {
		MyQueueWithLinkedList myQueueWithLinkedList=new MyQueueWithLinkedList();
		myQueueWithLinkedList.insertFront("front1");myQueueWithLinkedList.insertFront("front2");myQueueWithLinkedList.insertFront("front3");
		myQueueWithLinkedList.insertRear("rear1");myQueueWithLinkedList.insertRear("rear2");myQueueWithLinkedList.insertRear("rear3");
		myQueueWithLinkedList.display();
		System.out.println(myQueueWithLinkedList.removeFront());
		System.out.println(myQueueWithLinkedList.removeRear());
		myQueueWithLinkedList.display();
	}
	
	

}
class MyQueueWithLinkedList{
	Node front;
	Node rear;
	
	public void insertFront(String s){
		Node n=new Node(s);
		if(this.front ==null && this.rear==null){
			this.front=n;
			this.rear=n;		
		}
		else{
			this.front.previous=n;
			n.next=this.front;
			this.front=n;			
		}
	}
	public void insertRear(String s){
		Node n=new Node(s);
		if(this.front ==null && this.rear==null){
			this.front=n;
			this.rear=n;					
		}
		else{
			this.rear.next=n;
			n.previous=this.rear;
			this.rear=n;	
		}	
	}
	public String removeFront(){
		if(this.front!=null && this.rear!=null){
			String s=this.front.value;
			this.front=this.front.next;
			this.front.previous=null;
			return "popFront=>"+s;
		}
		return null;
		
	}
	public String removeRear(){
		if(this.rear!=null && this.front!=null){
			String s=this.rear.value;
			this.rear=this.rear.previous;
			this.rear.next=null;

			return "popRear=>"+s;	
		}
		return null;
	}
	public void display(){

		if(this.front!=null && this.rear!=null){
			Node f=this.front;

			do{
				System.out.println (f.value);
				f=f.next;
			}while(f!=null);
		}
	}
	
	private class Node{
		Node next;
		Node previous;
		String value;
		public Node(String value){
			this.value=value;
			this.next=null;
			this.previous=null;
		}
		@Override
		public String toString() {
			return "Node [next=" + next.value + ", previous=" + previous.value + ", value=" + value + "]";
		}
		
	}
}