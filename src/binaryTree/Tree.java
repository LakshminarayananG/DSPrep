package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> {
	
	public class Node
	{
	T data ;
	Node left;
	Node right;
	
	
	public Node(T value )
	{
		this.data=value;
		left=null;
		right=null;
		
		
	}

	}
	
	
	
	public  Node insertBST(Node root, T value)
	{
		if(root==null)
		{
			return new Node(value);
			
		}
		else
		{
			if(value.compareTo(root.data)<0)
			{
				root.left=insertBST(root.left,value);
			}
			else
			{
				root.right=insertBST(root.right,value);
			}
		}
		return root;
	}
	
	public List<T> InorderTraversal(Node root)
	{
		List<T> output=new ArrayList<>();
		if(root!=null)
		{
		InorderTraversal(root.left);
		output.add(root.data);
		InorderTraversal(root.right);
		}
		return output;
	}
}


