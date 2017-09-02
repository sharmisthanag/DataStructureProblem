package com.Tree;

public class AVLTree {

	private static NNode root = null;

	public static void main(String[] args) {
		AVLTree at=new AVLTree();
		at.insert(60);at.insert(40);at.insert(70);
		at.insert(50);at.insert(20);at.insert(15);at.insert(26);
		at.insert(45);at.insert(55);at.insert(52);
		
		System.out.println("Preorder traversal" +
                " of constructed tree is : ");
		preOrder(root);
		
	}

	private void insert(int i) {
		NNode cr=null;
		if((cr=root)==null){
			root = new NNode(i);
		}
		else{
			root = insert(i,cr);	
		}
		preOrder(root);	
	}

	private NNode insert(int i, NNode cr) {
		if(cr == null){
			return new NNode(i);
		}
		if(i<cr.data){
			cr.left=insert(i,cr.left);
			return balance(cr);
		}
		else if(i>cr.data){
			cr.right= insert(i, cr.right);
			return balance(cr);
		}
		return cr;
	}

	private NNode balance(NNode cr) {
		cr.balanceFactor = getBalanceFactor(cr);
		//ll
		if(cr.balanceFactor>1 && cr.left.balanceFactor>0){
			return rotateRight(cr);
		}
		//rr
		else if(cr.balanceFactor<-1 && cr.right.balanceFactor<0){
			return rotateLeft(cr);
		}
		//lr
		else if(cr.balanceFactor>1 && cr.left.balanceFactor<0){
			return rotateLeftRight(cr);
		}
		//rl
		else if(cr.balanceFactor<1 && cr.right.balanceFactor>0){
			return rotateRightLeft(cr);
		}
		return cr;
	}

	private NNode rotateRightLeft(NNode cr) {
		cr.right = rotateRight(cr.right);
		return rotateLeft(cr);		
	}

	private NNode rotateLeftRight(NNode cr) {
		cr.left = rotateLeft(cr.left);
		return rotateRight(cr);
	}

	private NNode rotateLeft(NNode cr) {
		NNode newRoot = cr.right;
		NNode newRootLeft = newRoot.left;
		newRoot.left = cr;
		cr.right = newRootLeft;
		
		cr.balanceFactor = getBalanceFactor(cr);
		newRoot.balanceFactor = getBalanceFactor(newRoot);
		return newRoot;
	}

	private NNode rotateRight(NNode cr) {
		NNode newRoot = cr.left;
		NNode newRootRight = newRoot.right;
		newRoot.right = cr;
		cr.left = newRootRight;
		
		cr.balanceFactor = getBalanceFactor(cr);
		newRoot.balanceFactor = getBalanceFactor(newRoot);
		
		return newRoot; 
	}

	private int getBalanceFactor(NNode cr) {
		return height(cr.left)-height(cr.right);
	}

	private int height(NNode n) {
		if(n==null)return 0;
		if(n.balanceFactor>=0){
			return 1+height(n.left);
		}
		else if(n.balanceFactor<0){
			return 1+height(n.right);
		}
		else{
			return 1;
		}
		
	}

	public static void preOrder(NNode cr) {
		if(cr==null){
			return ;
		}
		System.out.println(((cr.left==null)?"0":cr.left.data)+"->"+cr.data+"("+cr.balanceFactor+")->"+((cr.right==null)?"0":cr.right.data));
		preOrder(cr.left);
		preOrder(cr.right);
	}

}
class NNode{
	public int data;
	public NNode left;
	public NNode right;
	public int balanceFactor=0;
	public NNode(int data){
		this.data = data;
	}
}