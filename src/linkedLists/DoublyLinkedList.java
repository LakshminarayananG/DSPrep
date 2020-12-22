package linkedLists;

import java.util.LinkedList;

public class DoublyLinkedList {
	
	public static void main(String[] args) {
		
		LinkedList<String> team= new LinkedList<String>();
		team.add("Lakshmi");
		team.add("Sooraj");
		team.add("Sethu");
		team.add("Bharathi");
		team.add("Vardhini");
		team.add("Sagar");
		team.add("Sooraj");
		
	
		String s="Sooraj";
		int val= team.indexOf(s);
		System.out.println("Next to sooraj is: "+team.listIterator(val).next());
		
		System.out.println("Second member is: "+team.get(2));
		System.out.println("Index of sooraj is "+val);
		System.out.println("Next member to 1st is: "+team.listIterator(0).next());
		System.out.println("Previous member to 1st is: "+team.listIterator(1).previous());
		//System.out.println("Deleting Sagar: "+team.remove("Sooraj"));
		System.out.println(team.removeLastOccurrence("Sooraj"));
		System.out.println("Searching name: "+team.contains("Lakshmi"));
		
		System.out.println(team);
	}

}
