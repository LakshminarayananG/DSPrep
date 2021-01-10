package week6.tree;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

public class MinimumVal {
	
	public static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data)
		{
			this.data=data;
		}
		
	}

	@Test
	public void eg2() {
		TreeNode root= new TreeNode(5);
		root.left=new TreeNode(4);
		root.right=new TreeNode(7);
		System.out.println("Minimum absolute diff is "+minabsdiff(root));		
	}
	
	
	@Test
	public void eg3() {
		TreeNode root= new TreeNode(11);
		root.left=new TreeNode(6);
		root.right=new TreeNode(15);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(10);
		root.right.left=new TreeNode(13);
		root.right.right=new TreeNode(17);
		Integer minval=Integer.MAX_VALUE;
		ArrayList<Integer> listn= new ArrayList<Integer>();		
		System.out.println("Minimum absolute diff is "+Collections.min(inOrdernew(root,minval,listn)));		
	}
	
	
	private int minabsdiff(TreeNode root) {
		ArrayList<Integer> listn= new ArrayList<Integer>();
		ArrayList<Integer> list=inOrder(root,listn);
		Integer minval=Integer.MAX_VALUE;
		for (int i = 0; i < list.size()-1; i++) {
			minval=Math.abs(Math.min(minval, list.get(i+1)-list.get(i)));
		}
		return minval;
	}
	
	
	public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> listn) {
		if(root !=  null) {
			inOrder(root.left,listn);  
			listn.add(root.data);
			System.out.printf("%d ",root.data);
			inOrder(root.right,listn);
		}
		return listn;
	}
	
	
	public ArrayList<Integer> inOrdernew(TreeNode root,int minval,ArrayList<Integer> listn) {
		if(root !=  null && root.left!=null && root.right!=null) {				
			minval=Math.min(Math.abs(root.data-root.left.data), Math.abs(root.right.data-root.data));
			listn.add(minval);
			inOrdernew(root.left,minval,listn);  
			inOrdernew(root.right,minval,listn);
		}
		
		return listn;
	}

}
