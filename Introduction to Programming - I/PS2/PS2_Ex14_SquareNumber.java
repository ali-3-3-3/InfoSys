/*
 * Programming Methodology
 * Problem Set 2 Exercise #14: PS2_Ex14_SquareNumber.java
 * 
 * This program reads an integer n and checks if it is a square number.
 * 
 * 
 */

import java.util.*;

class SquareNumber {
  Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter an integer: ");
    int integer = sc.nextInt();
    int n = 1;
    int i;

    while(true) {
      i = n * n;
      n++;
      if (i >= integer) {
        break;
      }
    }
    if (i == integer){
      System.out.println(integer + " is a square number");
    } else {
      System.out.println(integer + " is not a square number");
    }
    sc.close();
  }
}