package homework;

import org.junit.Test;

public class BulbSwitch {
	
	@Test
	public void eg1() {
		String target="10111";
		System.out.println(minFlips(target));
	}
	
	
	
	public int minFlips(String target) {
        int count = 0;
        char onechar = '0';
        for (char c : target.toCharArray()) {
            if (c != onechar) {
                onechar = c;
                count++;
            }
        }
        return count;
    }

}
