package week6.stacksAndQueue;

import java.util.Arrays;
import java.util.Iterator;

import binarySearchTree.BinarySearchTree;
import binarySearchTree.TreeTraversalOrder;



public class BinaryTreeTest {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bt=new BinarySearchTree<>();
		
		bt.add(4);
		bt.add(2);
		bt.add(5);
		bt.add(1);
		bt.add(3);
		
		Iterator<Integer> traverse = bt.traverse(TreeTraversalOrder.IN_ORDER);
		int[] op=new int[bt.size()];
		int i=0;
		while(traverse.hasNext())
			op[i++]=traverse.next();
		
		System.out.println(Arrays.toString(op));
		
	}
}
