/*
 * Programming Methodology
 * Problem Set 2 Exercise #01: PS2_Ex01_PrintAsterisks.java
 * 
 * This program reads an integer n and prints n asterisks.
 * 
 * 
 */

import java.util.*;

class PrintAsterisks {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter n: ");
    int n = sc.nextInt();

    for(int i = 0; i < n; i++) {
      System.out.print('*');
    }
    
    System.out.println();  // just to change line

    sc.close();
  }
}