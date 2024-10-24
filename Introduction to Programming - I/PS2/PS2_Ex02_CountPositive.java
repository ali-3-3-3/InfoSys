/*
 * Programming Methodology
 * Problem Set 2 Exercise #02: PS2_Ex02_CountPositive.java
 * 
 * This program reads 5 integers and counts the number of positive integers.
 * 
 * 
 */

import java.util.*;

class CountPositive {
  
  public static void main(String[] args) {
    
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter 5 integers: ");
      int count = 0;
      int i = 0;
      int n;
      for (i= 0; i < 5; i++){
        n = sc.nextInt();
        if(n>0) {
          count++;
        }
      }
      
      System.out.println("Count = " + count);
    }
    
  }
}