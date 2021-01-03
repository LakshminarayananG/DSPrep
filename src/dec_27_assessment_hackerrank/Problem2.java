package dec_27_assessment_hackerrank;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2 {
	
	@Test
	public void eg1() {
		List<Integer> input= Arrays.asList(1,2,2,4,7);
		System.out.println(maxdiff(input));
	}
	
	private int maxdiff(List<Integer> input) {
		input.set(0, 1);
		for(int i=1;i<input.size();i++) {
			if(input.get(i)-input.get(i-1)>1) {
				input.set(i, input.get(i-1)+1);
			}
		}
		
		return Collections.max(input);
	}

}
