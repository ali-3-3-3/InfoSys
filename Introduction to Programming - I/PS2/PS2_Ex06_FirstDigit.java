/*
 * Programming Methodology
 * Problem Set 2 Exercise #06: PS2_Ex06_FirstDigit.java
 * 
 * This program reads an integer n and prints the leftmost digit of n.
 * 
 * 
 * <Type your name here>
 */

import java.util.*;

class FirstDigit {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter an integer: ");
    int n = sc.nextInt();
    int numDigits = String.valueOf(n).length();
    int i = 0;

    if(numDigits == 1) {
      i = n;
    } else {
      for(int k = 1; k < n; k++) {
        n /= 10;
        i = n;
      }
    }

    System.out.println("Leftmost digit is " + i);
    sc.close();
  }
}