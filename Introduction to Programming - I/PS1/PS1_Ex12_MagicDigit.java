/*
 * Programming Methodology
 * Problem Set 1 Exercise #12: PS1_Ex12_MagicDigit.java
 * 
 * This program reads two 5-digit numbers and returns the magic digit of each number.
 * 
 * 
 */

import java.util.*;

class MagicDigit {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter 1st number: ");
    int a = sc.nextInt();
    int Magic1 = getMagic(a);

    System.out.println("Magic digit = " + Magic1);
    
    System.out.print("Enter 2nd number: ");
    int b = sc.nextInt();
    int Magic2 = getMagic(b);
    
    System.out.println("Magic digit = " + Magic2);
    sc.close();
  }
  
  // Take a number and return the magic digit
  public static int getMagic(int num) {
    int pos1 = num / 10000;
    int pos2 = num / 100 % 10;
    int pos3 = num % 10000;
    return (pos1 + pos2 + pos3) % 10;
  }
}