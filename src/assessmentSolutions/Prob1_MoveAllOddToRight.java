package assessmentSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/*Given an array numbers , write a function to move all odd numbers to
the end of it while maintaining the relative order of all elements.
Example:
Input: [2,1,5,3,12]
Output: [2,12,1,5,3]
Note:
1. You must do this in-place without making a copy of the array.
2. Minimize the total number of operations.*/


public class Prob1_MoveAllOddToRight {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String next = sc.next();
        
        //Getting the input through scanner and converting the same into a string array
        next = next.replaceAll("\\{|\\}", "");
        String[] input = next.split(",");
        
       ArrayList<Integer> oddArray = new ArrayList<>();
        ArrayList<Integer> evenArray = new ArrayList<>();
        
        
        int[] output= new int[input.length];
        int counter=0;

        //Iterate through the input string array, add all even elements to evenArr & odd elements to oddArray
        for (int i = 0; i < input.length; i++) {
            if (Integer.parseInt(input[i]) % 2 == 0 && Integer.parseInt(input[i])!=0 ) {
                evenArray.add(Integer.parseInt(input[i]));
            } else if (Integer.parseInt(input[i]) % 2 == 1 && Integer.parseInt(input[i])!=0) {
                oddArray.add(Integer.parseInt(input[i]));
            } else{
                counter++;
            }
        }
        
        
        //If there are any 0's, add those to the end of the even array
        while(counter>0){
            evenArray.add(0);
            counter--;
        }

        //Merge the odd array with even array
        evenArray.addAll(oddArray);

       for(int i=0;i<output.length;i++) {
    	   output[i]=evenArray.get(i);
       }
       
       //Replace the [ in output with { since expected output is { and ends with ]
       String out=Arrays.toString(output).replace("[", "{");
       String finaloutput=out.replace(" ", "");
       System.out.println(finaloutput);
	}

}
