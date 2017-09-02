package com.Tree;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;

public class DeleteNodeFromBSL {

	public static void main(String[] args) {
		BSL bt=new BSL();
		bt.insertInBSL(50);
		bt.insertInBSL(80);
		bt.insertInBSL(20);
		bt.insertInBSL(10);
		bt.insertInBSL(30);
		bt.insertInBSL(70);
		bt.insertInBSL(60);bt.insertInBSL(85);bt.insertInBSL(65);bt.insertInBSL(55);bt.insertInBSL(45);bt.insertInBSL(66);bt.insertInBSL(61);
		BSL.inOrder(BSL.root);
		System.out.println("***");
		BSL.putInOrderArr(BSL.root);
		BSL.deleteFromBSL(50);

	}

}

class BSL {
	static Nodeee root=null;
	static int k=6;
	static int count=0;
	static int[] arr=new int[k];
	void insertInBSL(int data){
		if(root == null){
			root = new Nodeee(data,null,null);
		}
		else{
			Nodeee cr=root;
			insertInBSLRecursively(cr,data);
		}
	}
	private void insertInBSLRecursively(Nodeee cr, int data) {
		if(cr==null){
			return;
		}
		if(cr.data > data){
			insertInBSLRecursively(cr.left, data);
			if(cr.left ==null)
				cr.left = new Nodeee(data,null,null);
		}
		else{
			insertInBSLRecursively(cr.right, data);
			if(cr.right == null)
				cr.right = new Nodeee(data,null,null);
		}

	}
	public static void inOrder(Nodeee cr){		
		if(cr == null)return;
		inOrder(cr.left);
		System.out.println(cr.data);
		inOrder(cr.right);
	}
	public static void putInOrderArr(Nodeee cr){
		if(cr == null)return;
		putInOrderArr(cr.left);
		if(count<k)
			arr[count++]=cr.data;
		putInOrderArr(cr.right);
	}
	public static void deleteFromBSL(int data) {
		Nodeee cr=root;
		Nodeee nodeToBeDeleted=searchNode(data,cr);
		root = deleteNodeee(data,cr);
	}
	private static Nodeee deleteNodeee(int data, Nodeee cr) {
		if(cr==null)return cr;
		if(data>cr.data){
			cr.right = deleteNodeee(data,cr.right);
		}
		else if(data<cr.data){
			cr.left=deleteNodeee(data,cr.left);
		}
		else{			
			if(cr.right==null)return cr.left;
			else if(cr.left==null)return cr.right;
			else{
				Nodeee minNodeFromLeft= getMinFromRightSubTreeOfTheNodeTobeDeleted(cr.right);
				cr.data = minNodeFromLeft.data;
				cr.right = deleteNodeee(minNodeFromLeft.data, cr.right);
			}
		}
		return cr;
		
		
	}
	private static Nodeee getMinFromRightSubTreeOfTheNodeTobeDeleted(Nodeee cr) {
		if(cr.left==null){
			return cr;
		}
		return getMinFromRightSubTreeOfTheNodeTobeDeleted(cr.left);
		
	}
	private static Nodeee searchNode(int data,Nodeee cr) {
		if(cr!=null && cr.data == data)return cr;
		if(data>cr.data){
			searchNode(data,cr.right);
		}
		else{
			searchNode(data,cr.left);
		}
		return null;
	}
}

class Nodeee{

	Nodeee left;
	Nodeee right;
	int data;
	public Nodeee(int data, Nodeee left, Nodeee right) {
		this.left = left;
		this.right = right;
		this.data = data;
	}
}