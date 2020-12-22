package binaryTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import binaryTree.Tree.Node;

public class AddToTree {
	
	@Test
	public void setOne()
	{
		int[] input= {2,5,6};
		System.out.println(CheckBST(input));
	}
	
	//Solution 1
	public Boolean CheckBST(int[] array)
	{
		List<Integer>output=new LinkedList<>();
		List<Integer> ref=new LinkedList<>();
		Tree<Integer> t=new Tree<Integer>();
        Node root=t.new Node(array[0]);
		for(int i=1; i<array.length;i++)
		{
		t.insertBST(root, array[i]);
		}
		
		output=t.InorderTraversal(root);
		ref=t.InorderTraversal(root);
		Collections.sort(ref);
		if(output.equals(ref))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/*
	 * //Solution 2
	 * 
	 * public Boolean CheckBST(int[] array) {
	 * 
	 * }
	 */
	
	

}
