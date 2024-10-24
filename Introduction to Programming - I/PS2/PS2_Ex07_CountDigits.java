/*
 * Programming Methodology
 * Problem Set 2 Exercise #07: PS2_Ex07_CountDigits.java
 * 
 * This program reads an integer n and counts the number of digits in n.
 * 
 * 
 */

import java.util.*;

class CountDigits {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter n: ");
    int n = sc.nextInt();

    int numDigits = String.valueOf(n).length();
    
    System.out.println("Number of digits = " + numDigits);
    sc.close();
  }
}