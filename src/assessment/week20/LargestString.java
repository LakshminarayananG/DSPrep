package assessment.week20;

import java.util.Arrays;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;

public class LargestString {

	@Test
	public void example1() {
		String input = "baccc";
		int k = 2;
		Assert.assertEquals("ccbca", findLargestString(input, k));
	}

	@Test
	public void example2() {
		String input = "zzzazz";
		int k = 2;
		Assert.assertEquals("zzazz", findLargestString(input, k));
	}

	@Test
	public void example3() {
		String input = "axxzzx";
		int k = 2;
		Assert.assertEquals("zzxxax", findLargestString(input, k));
	}

	@Test
	public void example4() {
		String input = "yuzzvuyzpv";
		int k = 1;
		Assert.assertEquals("zyzyzvuvup", findLargestString(input, k));
	}

	@Test
	public void example5() {
		String input = "zxzuvozyzvzywvxyqxzxzyywyxwyzxxwzwzyzzzzyxzvzxxywx";
		int k = 4;
		Assert.assertEquals("zzzzyzzzzyzzzzyzzzzyyyyxyyyxxxxwxxxxwxxwwwwvvvvuqo", findLargestString(input, k));
	}

	
	
	
	public static String findLargestString(String s, int k) {
	    // Write your code here
	    StringBuilder sb = new StringBuilder();
	    char[] charr= s.toCharArray();
	    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	    for (char c : charr) {
	        map.put(c, map.getOrDefault(c,0)+1);
	    }
	    
	    Character[] keychars= new Character[map.keySet().size()];
	    map.keySet().toArray(keychars);
	    Arrays.sort(keychars);
	    int add=0;
	    for(int i=keychars.length-1;i>=0;i--){
	        add=0;
	        if(map.get(keychars[i])!=0){
	            
	            while(map.get(keychars[i])!=0){
	                if(add%k==0 && add!=0){
	                    int temp=1;
	                    while(i-temp>=0){
	                        if(map.get(keychars[i-temp])>0){
	                            sb.append(keychars[i-temp]);
	                            map.put(keychars[i-temp],map.get(keychars[i-temp])-1);
	                            break;
	                        }
	                        else{
	                            temp++;
	                        }
	                    }
	                    if(i-temp<0){
	                        map.put(keychars[i],0);
	                        break;
	                    }
	                }
	                sb.append(keychars[i]);
	                add++;
	                map.put(keychars[i],map.get(keychars[i])-1);
	            }
	        }
	    }    
	    return sb.toString();

	    }
}
