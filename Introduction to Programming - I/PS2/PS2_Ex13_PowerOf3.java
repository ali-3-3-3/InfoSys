/*
 * Programming Methodology
 * Problem Set 2 Exercise #13: PS2_Ex13_PowerOf3.java
 * 
 * This program reads two integers, start and end, and computes the 
 * number of integers from start to end (both inclusive) that are power of 3.
 * 
 */

import java.util.*;

class PowerOf3 {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter start and end: ");
    int start = sc.nextInt();
    int end = sc.nextInt();

    int answer = countNumber(start, end);
    
    System.out.println("Answer = " + answer);
    sc.close();

  }
  
  // Count the number of integers from start to
  // end (both inclusive) that are power of 3
  
  public static int countNumber(int start, int end){
    int count = 0;
    double n = 1;
    double powerOf3 = 3;
    while(powerOf3 < end) {
        powerOf3 = Math.pow(3, n);
        if (powerOf3 >= start && powerOf3 <= end) {
            count++;
        }
        n++;
    }
    return count;
  }
}