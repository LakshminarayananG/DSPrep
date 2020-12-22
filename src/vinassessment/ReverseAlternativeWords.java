package vinassessment;

import org.junit.Test;

public class ReverseAlternativeWords {

    /*
        Pseudo-code:
        Split the given string as String array
        iterate an reverse loop to print in reverse order
        And also check the i value as odd or even
        If it is odd, then reverse all the  characters in particular index string (By storing in temp stringbuilder)
     */

    @Test
    public void dataSet1(){
        String str = "There is no test";
        reverseAlternateWordsFromString(str);
    }

    @Test
    public void dataSet2(){
        String str = "my data";
        reverseAlternateWordsFromString(str);
    }

    public void reverseAlternateWordsFromString(String str){
        StringBuilder output = new StringBuilder();
        String[] strArr = str.split(" ");
        for (int i= strArr.length-1; i>=0; i--){
            StringBuilder temp = new StringBuilder(strArr[i]);
            if (i%2 != 0) temp.reverse();
            output.append(temp).append(" ");
        }
        System.out.println(output.toString().trim());
    }
}
