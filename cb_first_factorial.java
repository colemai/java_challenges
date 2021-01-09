/*
Challenge as per https://coderbyte.com/information/First%20Factorial

Have the function FirstFactorial(num) take the num parameter being passed and return the factorial of it. For example: if num = 4, then your program should return (4 * 3 * 2 * 1) = 24. For the test cases, the range will be between 1 and 18 and the input will always be an integer.

Input: 4
Output: 24

8
40320

*/


import java.util.*; 
import java.io.*;


class Main {

  public static int FirstFactorial(int num) {
    int i = num;
    while (i >= 2) {
      num *= (i - 1);
      i--;
    } 
    return num;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(FirstFactorial(s.nextLine())); 
  }

}