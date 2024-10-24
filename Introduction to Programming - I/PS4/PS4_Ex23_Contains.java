/*
 * Programming Methodology
 * Problem Set 4 Exercise #23: PS4_Ex23_Contains.java
 * 
 * This program checks if digit 'k' appears in 'number'.
 * 
 */

import java.util.*;

class Contains {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a positive integer: ");
    int number = sc.nextInt();

    System.out.print("Enter a single digit integer k: ");
    int k = sc.nextInt();

    if(contains(number, k)){
      System.out.println(k + " appears in " + number);
    } else {
      System.out.println(k + " doesn't appear in " + number);
    }
    sc.close();
  }
  
  // Check if k appears in any digit of number
  // Return true if so, or false otherwise
  // Pre-cond: number > 0, k < 10 && k >= 0
  public static boolean contains(int number, int k) {
    if(number == k){
        return true;
    } else if (number % 10 == k){
        return true;
    } else if(number < 10){
        return false;
    } else {
      return contains(number / 10, k);
    }
  }
}