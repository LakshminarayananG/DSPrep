package binaryTree;

import java.util.ArrayList;
import org.junit.Test;

public class CheckBST {
	
	@Test
	public void eg1() {
		TreeNode root= new TreeNode(11);
		root.left=new TreeNode(6);
		root.left.left= new TreeNode(3);
		root.left.right= new TreeNode(8);
		root.right=new TreeNode(15);
		root.right.left=new TreeNode(13);
		root.right.right=new TreeNode(17);
		System.out.println(isBST(root));		
	}
	
	

	
	
	public static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data)
		{
			this.data=data;
		}
		
	}
	
	
	private boolean isBST(TreeNode root) {
		ArrayList<Integer> listn= new ArrayList<Integer>();
		ArrayList<Integer> list=inOrder(root,listn);
		for (int i = 0; i < list.size()-1; i++) {
			if(list.get(i)>list.get(i+1)) {
				return false;
			}
		}
		return true;
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
	

}
