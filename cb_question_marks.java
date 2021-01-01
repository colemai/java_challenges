/*
Challenge as per https://coderbyte.com/editor/Questions%20Marks:Java

Have the function QuestionsMarks(str) take the str string parameter, which will contain single digit numbers, letters, and question marks, and check if there are exactly 3 question marks between every pair of two numbers that add up to 10. If so, then your program should return the string true, otherwise it should return the string false. If there aren't any two numbers that add up to 10 in the string, then your program should return false as well.

For example: if str is "arrb6???4xxbl5???eee5" then your program should return true because there are exactly 3 question marks between 6 and 4, and 3 question marks between 5 and 5 at the end of the string.

*/


import java.util.*; 
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



class Main {


  public static String QuestionsMarks(String str) {
    int countOfPairsAddingToTen = 0;
    ArrayList<ArrayList<Integer>> indicesOfSubStrings = getComponentsFromString(str, "\\d+");
    ArrayList<Integer> substringStartIndices = indicesOfSubStrings.get(0);
    ArrayList<Integer> substringEndIndices = indicesOfSubStrings.get(1);

    if (substringStartIndices.size() == 0) {
    	return "false";
    }

    for (int i = 0; i < substringStartIndices.size() -1; i++) {
    	int firstNumberIndex = substringStartIndices.get(i);
    	int secondNumberIndex = substringStartIndices.get(i+1);
    	char firstNumber = str.charAt(firstNumberIndex);
    	char secondNumber = str.charAt(secondNumberIndex);
    	int firstInteger = Character.getNumericValue(firstNumber);
    	int secondInteger = Character.getNumericValue(secondNumber);

    	if (firstInteger + secondInteger == 10) {
    		countOfPairsAddingToTen ++;
    		String substringBetweenNumbers = str.substring(firstNumberIndex+1, secondNumberIndex);
    		int questionMarkCount = (substringBetweenNumbers.split("\\?", -1).length) - 1;
    		if (questionMarkCount == 3) {
    			continue;
    		} else {
    			return "false";
    		}
    	}
    }

	if (countOfPairsAddingToTen == 0) {
		return "false";
	} else {
		return "true";
	}
  }


  public static ArrayList<ArrayList<Integer>> getComponentsFromString(String inputString, String pattern) {
  	Pattern p = Pattern.compile(pattern);
  	Matcher matcher = p.matcher(inputString);
  	ArrayList<Integer> numberStartIndex = new ArrayList<Integer>();
  	ArrayList<Integer> numberEndIndex = new ArrayList<Integer>();
  	while (matcher.find()) {
  		numberStartIndex.add(new Integer(matcher.start()));
  		numberEndIndex.add(new Integer(matcher.end()));
  	}
  	
  	return new ArrayList<ArrayList<Integer>>(Arrays.asList(numberStartIndex, numberEndIndex));
  }


  public static void main (String[] args) {  
    var inputString = "acc?77??sss?3rr1??????5";
    QuestionsMarks(inputString);
  }

}