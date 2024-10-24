/*
 * Programming Methodology
 * Problem Set 2 Exercise #05: PS2_Ex05_Age.java
 * 
 * The program ensures that the user enters a valid age 
 * between 1 and 100, keeps track of how many attempts
 * were made, and displays both the valid age and the 
 * number of attempts.
 * 
 */

import java.util.*;

class Age {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
  
    int age = 0;
    int i = 0;

    while (age < 1 || age > 100) {
      System.out.print("Enter age: ");
      age = sc.nextInt();
      i++;
    }
    System.out.println("Your age is " + age);
    System.out.println("Number of attempts = " + i);
    sc.close();
  }
}