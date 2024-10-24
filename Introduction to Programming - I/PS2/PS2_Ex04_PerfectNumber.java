/*
 * Programming Methodology
 * Problem Set 2 Exercise #04: PS2_Ex04_PerfectNumber.java
 * 
 * This program reads an integer n and checks if it is a perfect number.
 * 
 * 
 */

import java.util.*;

class PerfectNumber {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter a positive integer: ");
    int n = sc.nextInt();

    int properdivisors = 1;
    if(n > 2){
        for(int i = 2; i < n; i++) {
        if (n%i == 0) {
          properdivisors += i;
        }
      }
    } else if (n==2) {
      properdivisors = n;
    } else {
      properdivisors = 0;
    }

    if(n==properdivisors) {
      System.out.println(n + " is a perfect number");
    } else {
      System.out.println(n + " is not a perfect number, its sum of "
                         + "proper divisors is " + properdivisors);
    }
    sc.close();
  }
}