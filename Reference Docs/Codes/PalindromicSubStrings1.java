package ds.assignments;

public class PalindromicSubStrings1 {

	public static void main(String[] args) {
		String input = "abccb";
		System.out.println(countPalindromeStrings(input));
	}

	private static int countPalindromeStrings(String S) {
        int N = S.length(), result = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                result++;
                left--;
                right++;
            }
        }
        return result;
    }
}
