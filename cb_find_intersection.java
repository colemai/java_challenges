import java.util.*; 
import java.io.*;

class Main {

  public static String FindIntersection(String[] strArr) {
    // code goes here 
    // Iterate through first arr
    // While second list iter <= first list iter if statement
    // edge cases
    int[] numArr1 = StringToIntArr(strArr[0]);
    int[] numArr2 = StringToIntArr(strArr[1]);
    ArrayList<Integer> results = new ArrayList<Integer>(); 

    for (int number : numArr1) {
      for (int subNum = 0; subNum <= number && subNum < numArr2.length; subNum++) {
        if (numArr2[subNum] == number) {
          results.add(number);
        }
      }
    }
    String[] resultsConverted = new String[results.size()];
    for (int i = 0; i < results.size(); i++) {
      resultsConverted[i] = String.valueOf(results.get(i));
    }
    String res = String.join(",", resultsConverted);
    return res;
  }

  public static int[] StringToIntArr(String numberString) {
    // Take a string of comma separated numbers and 
    // return it as an array of ints
    String[] strArr = numberString.split(",");
    int[] numArr = new int[strArr.length];
    for (int i = 0; i < strArr.length; i++) {
      numArr[i] = Integer.parseInt(strArr[i].trim());
    }
    return numArr;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(FindIntersection(s.nextLine())); 
  }

}