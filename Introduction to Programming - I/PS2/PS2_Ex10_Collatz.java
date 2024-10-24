/*
 * Programming Methodology
 * Problem Set 2 Exercise #10: PS2_Ex10_Collatz.java
 * 
 * This program reads a natural number n and calculates the 
 * number of iterations needed to process n till 1.
 * 
 */

import java.util.*;

class Collatz {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter a natural number: ");
    int n = sc.nextInt();
    int iterations = countIterations(n);
    
    System.out.println("Number of iterations = " + iterations);
    sc.close();
  }
  
  // Calculate how many rounds are needed to process n till 1
  public static int countIterations(int n) {
    
    int count = 0;

    while (n != 1) {
      if (n%2 == 0) {
        n = n / 2;
      } else {
        n = 3 * n + 1;
      }
      count++;
    }
    return count;
  }
}