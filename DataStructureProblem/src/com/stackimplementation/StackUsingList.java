package com.stackimplementation;

public class StackUsingList {

	public static void main(String[] args) {
		MyStackWithLinkList m=new MyStackWithLinkList();
		m.push("hello1");
		m.push("hello2");m.push("hello3");m.push("hello4");m.push("hello5");
		System.out.println(m.peek());
		System.out.println(m.pop());
		System.out.println(m.peek());
		m.display();
		
		

	}

}
class MyStackWithLinkList{
	private Node top;
	public void push(String s){
		Node n=new Node(s);
		if(this.top != null){
			n.next=this.top;
			this.top=n;
		}
		else{
			this.top=n;	
		}
	}
	public String pop(){
		String s=null;
		if(!isEmptyStack()){
			s=top.s;
			top = top.next;
		}
		return "poped=>"+s;
		
	}
	public String peek(){
		if(!isEmptyStack()){
			return "peeked=>"+top.s;
		}
		return null;
	}
	private boolean isEmptyStack() {
		return top == null;
	}
	public void display(){
		if(!isEmptyStack()){
			do{
				System.out.println(top.s);
				top=top.next;
			}
			while(top.next!=null);
			System.out.println(top.s);
		}
	}

	private class Node{
		Node next;
		String s;
		Node(String s){
			this.s=s;
			this.next=null;
		}
		
	}
}