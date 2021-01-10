package assessment.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*	A sentence is made up of a group of words. Each word is a sequence of
	letters, ('a'-'z', 'A'-'Z'), that may contain one or more hyphens and may
	end in a punctuation mark: period (.), comma (,), question mark (?), or
	exclamation point (!). Words will be separated by one or more white
	space characters. Hyphens join two words into one and should be
	retained while the other punctuation marks should be stripped.
	Determine the number of words in a given sentence.
	Example
	s = 'How many eggs are in a half-dozen, 13?'
	The list of words in the string is ['How', 'many', 'eggs', 'are', in', 'a', 'halfdozen'] 
	and the number of words is 7. Notice that the numeric string,
	'13', is not a word because it is not within the allowed character set.
*/

import org.junit.Test;

public class Prob7_CountWords {
	
	@Test
	public void eg1() {
		//String input="he is a good programmer, he won 865 competitions, but sometimes he dont. What do you think? All test-cases should pass. Done-done?";
		//count1(input);
		
		//String anotherinput="How many eggs are in a half-dozen, 13?";
		//count1(anotherinput);
		
		String input1="jds!    dsaf lkdf kdsa fkldsf, adsbf ldka ads? asd bfdal ds bf[l. akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj.";
		count1(input1);
	}
	
	
	
	private void count1(String input) {
		String str=input.replaceAll("\\s+"," ").toLowerCase();		
		Pattern my_pattern = Pattern.compile("[^!a-zA-Z.,?-]");
		String[] stringArray=str.split(" ");
		System.out.println(Arrays.toString(stringArray));
		List<String> output= new ArrayList<String>();
		for(int i=0;i<stringArray.length;i++) {
			//stringArray[i].trim();
			Matcher my_match = my_pattern.matcher(stringArray[i]);
			if(!my_match.find()) {
				output.add(stringArray[i]);
			}
		}
		
		System.out.println(output.size());
	}
	
	
	private void wordsCount(String s) {
		String[] split = s.split(" ");
		int count = 0;
		for (String str : split) {
			// System.out.println(str);
			Matcher matcher = Pattern.compile("^[[a-zA-Z]\\-[a-zA-Z]]+").matcher(str);
			while (matcher.find()) {
				String chk=matcher.group();
				if(chk.equals(str.substring(0, str.length()-1)) || chk.equals(str))
					count++;
			}
		}

		System.out.println(count);

	}

	private void wordsCount1(String s) {
		s = "home-run";
		Matcher matcher = Pattern.compile("^[[a-zA-Z]\\-[a-zA-Z]]+").matcher(s);
		while (matcher.find())
			if(matcher.group().equals(s))
				System.out.println(matcher.group());

	}
	

}
