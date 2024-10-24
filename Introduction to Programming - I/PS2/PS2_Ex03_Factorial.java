/*
 * CS1010J Programming Methodology
 * Problem Set 2 Exercise #03: PS2_Ex03_Factorial.java
 * 
 * This program reads an integer n and computes n!.
 * 
 * 
 */

import java.util.*;

class Factorial {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter n: ");
    int n = sc.nextInt();
    int j = 1;
    for(int i = 1; i < (n + 1); i++) {
      j *= i;
    }
    System.out.println(j);
    sc.close();
  }
}