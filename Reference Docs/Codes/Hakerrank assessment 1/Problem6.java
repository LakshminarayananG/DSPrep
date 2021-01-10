package job;

import java.util.HashSet;
import java.util.Set;

public class Problem6 {

    public static int getMinDeletions(String s) {
    	
    	Set<Character> unique = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			unique.add(s.charAt(i));
		}

		return s.length()-unique.size();

	}

	public static void main(String[] args) {
		String str = "  ";
		System.out.println(getMinDeletions(str));
	}


}
