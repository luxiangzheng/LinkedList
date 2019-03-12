package com.lu.binaryTree;

import java.util.Scanner;

public class BinaryTree {

	public static String[] str;
	public static int count;
	//创建接点
	public static TreeNode createBtree(){
		TreeNode root = null;
		if(count >= str.length || str[count++].equals("#")){
			root =null;
		}else{
			root = new TreeNode(str[count - 1]);
			root.lchild = createBtree();
			root.rchild = createBtree();
		}
		
		return root;
	}
	public static void preTraverse(TreeNode root) {
		if(root != null){
			System.out.println(root.data + "");
			preTraverse(root.lchild);
			preTraverse(root.rchild);
		}
	}
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		while (cin.hasNext()) {
			String s = cin.nextLine();
			str = s.split(",");
			
			count = 0;
			
			TreeNode root = createBtree();
			System.out.println(root.data);
			preTraverse(root);
		}
	}
}
