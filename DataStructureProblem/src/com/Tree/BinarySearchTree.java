package com.Tree;

public class BinarySearchTree {

	static Nodee root=null;
	static int k=6;
	static int count=0;
	static int[] arr=new int[k];
	void putInBinaryTree(int data){
		if(root == null){
			root = new Nodee(data,null,null);
		}
		else{
			Nodee cr=root;
			putrecursively(cr,data);
		}
	}
	private void putrecursively(Nodee cr, int data) {
		if(cr==null){
			return;
		}
		if(cr.data > data){
			putrecursively(cr.left, data);
			if(cr.left ==null)
				cr.left = new Nodee(data,null,null);
		}
		else{
			putrecursively(cr.right, data);
			if(cr.right == null)
				cr.right = new Nodee(data,null,null);
		}

	}
	public static void inOrder(Nodee cr){
		
		if(cr == null)return;
		inOrder(cr.left);
		System.out.println(cr.data);
		inOrder(cr.right);
	}
	public static void putInOrderArr(Nodee cr){
		if(cr == null)return;
		putInOrderArr(cr.left);
		if(count<k)
			arr[count++]=cr.data;
		putInOrderArr(cr.right);
	}


	public static void main(String[] args) {

		BinarySearchTree bt=new BinarySearchTree();
		bt.putInBinaryTree(50);
		bt.putInBinaryTree(80);
		bt.putInBinaryTree(20);
		bt.putInBinaryTree(10);
		bt.putInBinaryTree(30);
		bt.putInBinaryTree(70);
		bt.putInBinaryTree(60);
		inOrder(root);
		System.out.println("***");
		putInOrderArr(root);
		if(count==k)
		System.out.println(arr[k-1]);

	}

}

class Nodee{

	Nodee left;
	Nodee right;
	int data;
	public Nodee(int data, Nodee left, Nodee right) {
		this.left = left;
		this.right = right;
		this.data = data;
	}
}