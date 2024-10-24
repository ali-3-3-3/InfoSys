/*
 * Programming Methodology
 * Problem Set 3 Exercise #06: PS3_Ex06_PositiveFirst.java
 * 
 * This program reads an integer n and checks if it is a square number.
 * 
 * 
 */

import java.util.*;

class PositiveFirst {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the number of elements: ");
    int size = sc.nextInt();

    int [] values = new int[size];
    System.out.print("Enter " + size + " elements: ");
    for(int i = 0; i < size; i++){
      values[i] = sc.nextInt();
    }

    if(isPositiveFirst(values) == true){
      System.out.println("Positive numbers appear before non-positive numbers");
    } else {
      System.out.println("Some positive numbers appear after non-positive numbers");
    }

    sc.close();
  }
  
  // Check if the array is sorted
  public static boolean isPositiveFirst(int[] numbers) {
    for(int i = 0; i < numbers.length-1; i++) {
      if(numbers[i] <= 0 && numbers[i+1] >0){
        return false;
      }
    }
    return true;
  }
}