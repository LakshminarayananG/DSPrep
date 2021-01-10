package week8.homework;

public class Stairs {

	public static void main(String[] args) {
		int n = 4;
		String[] s = new String[n];

		for (int i = 0; i < n; i++)
			s[i] = " ";

		for (int i = n - 1; i >= 0; i--) {
			s[i] = "#";
			System.out.println(String.join("", s));
		}
	}
}
