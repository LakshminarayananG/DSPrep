package week13;

import org.junit.Test;

public class DecodeStringAtIndex {
	
	/*
	 * An encoded string S is given. To find and write the decoded string to a tape,
	 * the encoded string is read one character at a time and the following steps
	 * are taken:
	 * 
	 * If the character read is a letter, that letter is written onto the tape. If
	 * the character read is a digit (say d), the entire current tape is repeatedly
	 * written d-1 more times in total. Now for some encoded string S, and an index
	 * K, find and return the K-th letter (1 indexed) in the decoded string.
	 * 
	 * 
	 * 
	 * Example 1:	 * 
	 * Input: S = "leet2code3", K = 10 Output: "o" Explanation: The decoded string
	 * is "leetleetcodeleetleetcodeleetleetcode". The 10th letter in the string is
	 * "o". 
	 * 
	 * Example 2:	 * 
	 * Input: S = "ha22", K = 5 Output: "h" Explanation: The decoded string is
	 * "hahahaha". The 5th letter is "h". 
	 * 
	 * Example 3: 
	 * Input: S = "a2345678999999999999999", K = 1 Output: "a" Explanation: The
	 * decoded string is "a" repeated 8301530446056247680 times. The 1st letter is
	 * "a".
	 * 
	 * 
	 * Constraints:
	 * 
	 * 2 <= S.length <= 100 S will only contain lowercase letters and digits 2
	 * through 9. S starts with a letter. 1 <= K <= 10^9 It's guaranteed that K is
	 * less than or equal to the length of the decoded string. The decoded string is
	 * guaranteed to have less than 2^63 letters.
	 */
	
	@Test
	public void example1() {
		String s="leet2code3";
		int k=10;
		System.out.println(findKthCharacter(s, k));
	}
	
	@Test
	public void example2() {
		String s="ha22";
		int k=5;
		System.out.println(findKthCharacter(s, k));
	}
	
	@Test
	public void example3() {
		String s="a2b3c4d5e6f7g8h9";
		int k=10;
		System.out.println(findKthCharacter(s, k));
	}
	
	@Test
	public void example4() {
		String s="y959q969u3hb22odq595";
		int k=222280369;
		System.out.println(findKthCharacter(s, k));
	}
	
	private char findKthCharacter(String s,int k) {
		String op="";
		for(char ch:s.toCharArray()) {
			if(Character.isDigit(ch)) {
				String temp=op;
				for (int i = 1; i < Character.getNumericValue(ch); i++)
					op+=temp;
			}else {
				op+=ch;
			}
			if(op.length()>=k) {
				System.out.println(op);
				return op.charAt(k-1);
			}
		}
		
		return 0;
	}
	
	public String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();

        // Find size = length of decoded string
        for (int i = 0; i < N; ++i) {
            char c = S.charAt(i);
            if (Character.isDigit(c))
                size *= c - '0';
            else
                size++;
        }

        for (int i = N-1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                size /= c - '0';
            else
                size--;
        }

        throw null;
    }

}
