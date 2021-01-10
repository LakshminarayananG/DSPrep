package job;

import java.util.Arrays;
import java.util.List;

public class Problem3 {


	public static String getLargestString(String s, int k) {

		String outputStr = "";
		int i = 255;
		boolean isThere = false;

		int[] count = new int[256];
		for (int j = 0; j < s.length(); j++) {
			count[s.charAt(j)]++;
		}

		while(i >= 0) {
			for(int j=0; j < Math.min(count[i], k); j++) {
				outputStr += "" + (char)(i);
			}

			count[i] -= Math.min(count[i], k);
			if(count[i] == 0) {
				i -= 1;
				continue;
			}

			isThere = false;

			for(int j = i-1; j >= 0; j--) {				
				if(count[j] > 0) {
					outputStr += "" + (char)(j);
					count[j] -= 1;
					isThere = true;
					break;
				}				
			}

			if(isThere == false)
				break;

		}
		return outputStr;

	}


	public static void main(String[] args) {
		String s = "azzzzz";
		int k = 2;
		System.out.println(getLargestString(s, k));
	}


}
