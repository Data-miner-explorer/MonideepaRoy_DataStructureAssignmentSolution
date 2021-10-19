package com.greatlearning.main;
import java.util.ArrayList;
import java.util.Collections;


public class BST_ascending {
	static class Node {
		int value;
		Node left, right;
		
		public Node( int data ) {
			this.value = data;
			left = right = null;
		}
	}

	public static ArrayList storeinorder(Node root,ArrayList BSTarray) 
	{
		if (root==null) {
			return new ArrayList();
		}
			
		storeinorder(root.left,BSTarray); 
		BSTarray.add(root.value);
		storeinorder(root.right,BSTarray);			
		return BSTarray;
	}
	

	public static void main(String[] args) {
		 Node tree = new Node(50);
		 tree.left = new Node(30);
		 tree.right = new Node(60);
		 tree.left.left = new Node(10);
		 tree.right.left= new Node(40);
		 ArrayList BSTarray=new ArrayList();
	
		 ArrayList BSTarrayList = storeinorder( tree , BSTarray );
		 Collections.sort(BSTarrayList);
			
		 for(int i=0;i<=BSTarrayList.size()-1;i++) {
			System.out.print( BSTarrayList.get( i ) + "  " );
		 }
			}
	}


