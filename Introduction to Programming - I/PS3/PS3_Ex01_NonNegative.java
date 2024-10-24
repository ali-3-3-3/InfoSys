/*
 * Programming Methodology
 * Problem Set 3 Exercise #01: PS3_Ex01_NonNegative.java
 * 
 * This program reads an integer n and checks if it is a square number.
 * 
 * 
 */

import java.util.*;

class NonNegative {
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the size of the array: ");
    int size = sc.nextInt();
    
    int[] values = new int[size];
    System.out.print("Enter " + size + " elements: ");
    for (int i = 0; i < size; i++) {
      values[i] = sc.nextInt(); 
    }
    
    if (nonNegative(values) == true){
      System.out.println("All array elements are non-negative");
    } else {
      System.out.println("Some array elements are negative");
    }
    sc.close();
  }

  
  // Check if all elements in the array are non-negative
  public static boolean nonNegative(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
     if (arr[i] < 0) {
      return false; 
     }
    }
    return true;
  }
}