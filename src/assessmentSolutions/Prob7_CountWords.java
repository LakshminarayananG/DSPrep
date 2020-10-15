package assessmentSolutions;

import java.util.ArrayList;
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
		String anotherinput="How many eggs are in a half-dozen, 13?";
		System.out.println(count1(anotherinput));
	}
	
	@Test
	public void eg2() {
		String input="he is a good programmer, he won 865 competitions, but sometimes he dont. What do you think? All test-cases should pass. Done-done?";
		System.out.println(count1(input));
		}
	
	@Test
	public void eg3() {
		String input1="jds!    dsaf lkdf kdsa fkldsf, adsbf ldka ads? asd bfdal ds bf[l. akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj.";
		System.out.println(count1(input1));
	}
	
	
	
	private int count1(String input) {
		
		//Removing all the extra white spaces and converting the string to lower case
		String str=input.replaceAll("\\s+"," ").toLowerCase();		
		
		//Defining the pattern since !, . , - are all part of valid string
		Pattern my_pattern = Pattern.compile("[^!a-zA-Z.,?-]");
		String[] stringArray=str.split(" ");
		List<String> output= new ArrayList<String>();
		
		//Iterating through the string array and checking if the input string matches the pattern defined
		for(int i=0;i<stringArray.length;i++) {
			Matcher my_match = my_pattern.matcher(stringArray[i]);
			
			//Pattern match returns false since ^ not is given in pattern matcher, length > 0 is to ignore any spaces
			if(!my_match.find()&&stringArray[i].length()>0) {
				output.add(stringArray[i]);
			}
		}
		
		return output.size();
	}
	
	

}
