package week6.stacksAndQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LLBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		LinkedList<String> jl=new LinkedList<>();
		
		jl.add("Batman");
		jl.add("Superman");
		jl.add("Wonder Women");
		jl.add("Flash");
		
		//^	"Batman"	^	"Superman"	^	"Wonder Women"	^	"Flash"	^
		ListIterator<String> listIterator = jl.listIterator(1);
		
		while(listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
		System.out.println("-----------");
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		jl.add(jl.indexOf("Wonder Women")+1, "Green Latern");
		
		//System.out.println(jl.getFirst());
		jl.remove("Flash");
		//System.out.println(jl);
		
		//System.out.println(jl);
		
		Iterator<String> iterator = jl.iterator();
		
	//	while(iterator.hasNext())
		//	System.out.println(iterator.next());
		
	}

}
