package binaryTree;

import java.util.ArrayList;
import org.junit.Test;

public class SimilarTrees {
	
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
	public void eg1() {
		ArrayList<Integer> t1= new ArrayList<Integer>();
		ArrayList<Integer> t2= new ArrayList<Integer>();
		TreeNode root= new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		
		TreeNode root1= new TreeNode(1);
		root1.left= new TreeNode(2);
		root1.right= new TreeNode(3);
		
		isSimilar(root1, t1);
		isSimilar(root, t2);
		System.out.println(t1.equals(t2));
				
	}
	
	//@Test
	public void eg2() {
		ArrayList<Integer> t1= new ArrayList<Integer>();
		ArrayList<Integer> t2= new ArrayList<Integer>();
		TreeNode root= new TreeNode(1);
		TreeNode root1= new TreeNode(1);
		isSimilar(root1, t1);
		isSimilar(root, t2);
		System.out.println(t1.equals(t2));
				
	}
	
	
	private void isSimilar(TreeNode root, ArrayList<Integer> list) {
		if(root==null)
        {
            return;
        }
        if(root.left==null&&root.right==null)
        {
            list.add(root.data);
        }
        else
        {
        	isSimilar(root.left,list);
        	isSimilar(root.right,list);
            
        }
	}

}
