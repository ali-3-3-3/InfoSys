/*
 * Programming Methodology
 * Problem Set 2 Exercise #09: PS2_Ex09_CountNumbers.java
 * 
 * This program reads two divisors and two limits, and computes the number of integers.
 * 
 * 
 */

import java.util.*;

class CountNumbers {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter two divisors: ");
    int divisor1 = sc.nextInt();
    int divisor2 = sc.nextInt();
    
    System.out.print("Enter lower and upper limits: ");
    int limit1 = sc.nextInt();
    int limit2 = sc.nextInt();
    
    int count = countNumbers(divisor1, divisor2, limit1, limit2);
    
    System.out.println("Answer = " + count);
    sc.close();
  }
  
  // Calculate the number of integers that are not divisible by either div1 or div2
  public static int countNumbers(int div1, int div2, int lim1, int lim2) {
    int count = 0;
    for(int i = lim1; i <= lim2; i++){
      if(i % div1 != 0 && i % div2 != 0){
        count++;
      }
    }
    return count;
  }
}