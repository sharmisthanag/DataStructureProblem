/*package com.linkedlistcontainsloop;

import java.util.ArrayList;

public class ValidateLoopInLinkedList {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.add(1);
		l.add(2);
		l.add(3);
		System.out.println(l.size());
		System.out.println(l);
		
		ArrayList al=new ArrayList();
		al.add(null);
		System.out.println(al);

	}

}
class LinkedList{
	Node head;
	static int size;
	LinkedList(){
	}

	public void add(int i){
		Node newNode=new Node();newNode.setData(i);
		if(head==null){
			head=newNode;
		}
		else{
			Node currentHead = head;
			while(currentHead.next!=null){
				currentHead=currentHead.next;
			}
			currentHead.next=newNode;
		}
		size++;
	}
	public String toString(){
		String s="[";
		Node currentHead = head;
		if(currentHead!=null && currentHead.next==null){
			return "["+head.data+"]";
		}
		while(currentHead.next!=null){
			s=s+currentHead.data+",";
			currentHead=currentHead.next;
		}
		s=s.substring(0, s.length()-1)+"]";
		return s;
	}

	public int size(){

		return size;

	}

}
class Node{
	Node next;
	int data;
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [next=" + next + ", data=" + data + "]";
	}

}*/