package practice.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Interpolation {
	
	@Test
	public void eg1() {
		int n=1999;
		List<Integer> instances= new ArrayList<Integer>(Arrays.asList(10,25,50,100,500));
		List<Float> price =new ArrayList<Float>();
		price.add((float) 27.32);
		price.add((float) 23.13);
		price.add((float) 21.25);
		price.add((float) 18.00);
		price.add((float) 15.50);
		System.out.println(temp(n, instances, price));
	}
	
	
	private String temp(int n,List<Integer> instances, List<Float> price) {
		if(instances.contains(n)) {
			int tmp=instances.indexOf(n);
			return String.valueOf(price.get(tmp));
		}
		
		float total=0;
		if(n>instances.get(instances.size()-1)) {
			int prev=instances.size()-2;
			int curr=instances.size()-1;
			int instdiff=Math.abs(instances.get(curr)-instances.get(prev));
			float pricediff=Math.abs(price.get(curr)-price.get(prev));
			int jumpdiff=n-instances.get(curr);
			float totjump=(float)jumpdiff/instdiff;
			total=(price.get(curr)-(pricediff*totjump));
		}
		
		return String.valueOf(Math.round(total*100.0)/100.0);
	}

}
