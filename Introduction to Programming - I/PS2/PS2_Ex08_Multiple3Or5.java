/*
 * Programming Methodology
 * Problem Set 2 Exercise #08: PS2_Ex08_Multiple3Or5.java
 * 
 * This program reads an integer n and computes the number of multiples of 3 or 5.
 * 
 * 
 */

import java.util.*;

class Multiple3Or5 {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter n: ");
    int n = sc.nextInt();

    int i;
    if(n <= 3) {
      i = n;
    } else {
      i = 1;
    }

    int m;
    int k = 0;

    if (n%3 == 0 || n == 5) {
      m = 2;
    } else {
      m = 1;
    }

    while (i < n - 1) {
      i = m * 3;
      m++;
      k++;
    }

    if(n <= 5) {
      i = n;
    } else {
      i = 1;
    }

    if (n%5 == 0 || n%3 == 0) {
      m = 2;
    } else {
      m = 1;
    }

    while (i < n - 1) {
      i = m * 5;
      m++;
      if(i%3 != 0){
        k++;
      } 
    }

    System.out.println(k);
    sc.close();
    
  }
}