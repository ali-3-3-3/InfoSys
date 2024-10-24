/*
 * Programming Methodology
 * Problem Set 2 Exercise #19: PS2_Ex19_Winners.java
 * 
 * This program reads a factor-digit, a must-have-digit, and the number of participants,
 * and computes the number of winners.
 * 
 */

import java.util.*;

class Winners {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);  
    
    System.out.print("Enter factor-digit: ");
    int factor = sc.nextInt();
    
    System.out.print("Enter must-have-digit: ");
    int musthave = sc.nextInt();
    
    System.out.print("Enter the number of participants: ");
    int n = sc.nextInt();
    
    int i = 1;
    int noOfWinners = 0;

    while(i <= n) {
      boolean winner = contains(i, musthave);
      if (winner == true && i % factor == 0) {
        noOfWinners++;
      }
      i++;
    }

    System.out.println("Number of winners: " + noOfWinners);
    sc.close(); 
  }
    
    
  
  // Return true if number contains the mustHaveDigit, or false otherwise
  public static boolean contains(int number, int mustHaveDigit) {
    int n;
    while (number > 0){
      n = number % 10;
      if (n == mustHaveDigit) {
        return true;
      }
      number /= 10;
    }
    return false;
  }
}