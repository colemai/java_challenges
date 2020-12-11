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
    // code goes here 
    var numberSubStrings = getComponentsFromString(inputString, "\\d+");
    var stringSubStrings = getComponentsFromString(inputString, "\\D+");
    System.out.println(numberSubStrings);
    System.out.println(stringSubStrings);
    return str;
  }

  public static ArrayList<Object> getComponentsFromString(String inputString, String pattern) {
  	Pattern p = Pattern.compile(pattern);
  	Matcher matcher = p.matcher(inputString);
  	ArrayList<Object> pMatches = new ArrayList<Object>();
  	while (matcher.find()) {
  		pMatches.add(matcher.group());
  		pMatches.add(new Integer(matcher.start()));
  	}
  	for (Object s : pMatches) {
  		System.out.println(s);
  	}
  	return pMatches;
  }


  public static void main (String[] args) {  
    // keep this function call here
    var inputString = "acc?7??sss?3rr1??????5";
    QuestionsMarks(inputString);
    // Scanner s = new Scanner(System.in);
    // System.out.print(getNumbersFromString(s.nextLine())); 
  }

}