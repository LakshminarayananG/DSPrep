package assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class StringProb {
	
	@Test
	public void eg1() {
		String input="he is a good programmer, he won 865 competitions, but sometimes he dont. What do you think? All test-cases should pass. Done-done?";
		count1(input);
		
		String anotherinput="How many eggs are in a half-dozen, 13?";
		count1(anotherinput);
		
		String input1="jds dsaf lkdf kdsa fkldsf, adsbf ldka ads? asd bfdal ds bf[l. akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj.";
		count1(input1);
	}
	
	
	
	private void count1(String input) {
		String str=input.toLowerCase();
		Pattern my_pattern = Pattern.compile("[^a-zA-Z.,?-]");
		String[] charArr=str.trim().split(" ");
		List<String> output= new ArrayList<String>();
		for(int i=0;i<charArr.length;i++) {
			Matcher my_match = my_pattern.matcher(charArr[i]);
			boolean check = my_match.find();
			if(charArr[i].length()>0&&check==false) {
				output.add(charArr[i]);
			}
		}
		
		System.out.println(output.size());
	}
	
	
	
	
	
	private void count(String input) {
		String str=input.toLowerCase();
		str=str.replaceAll("[^A-Za-z-]", " ");
		str.trim();
		String[] charArr=str.trim().split(" ");
		
		List<String> output= new ArrayList<String>();
		for (int i = 0; i < charArr.length; i++) {
			if(charArr[i].length()>0)
			output.add(charArr[i]);
		}
		
		System.out.println(output.size());
		
	}

}
