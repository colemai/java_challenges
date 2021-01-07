/*
Challenge as per https://coderbyte.com/editor/Longest%20Word:Java

Have the function LongestWord(sen) take the sen parameter being passed and return the largest word in the string. If there are two or more words that are the same length, return the first word from the string with that length. Ignore punctuation and assume sen will not be empty.

Input: "fun&!! time"
Output: time

The problem says to "ignore" punctuation, does that mean fu***n equates to fun?
I'll assume so

*/


import java.util.*; 
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Main {

  public static String LongestWord(String sen) {
    String wordToBeat = new String(""); 
    String senWithoutPunctuation = sen.replaceAll("\\p{P}", "");

    Pattern wordPattern = Pattern.compile("[a-zA-Z]+");
    Matcher matcher = wordPattern.matcher(senWithoutPunctuation);
  	while (matcher.find()) {
        int start = matcher.start(0);
        int end = matcher.end(0);
        String thisMatch = senWithoutPunctuation.substring(start, end);
        if (thisMatch.length() > wordToBeat.length()) {
        	wordToBeat = thisMatch;
        }
  	}

    return wordToBeat;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(LongestWord(s.nextLine())); 
  }

}