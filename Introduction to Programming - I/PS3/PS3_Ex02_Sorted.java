/*
 * Programming Methodology
 * Problem Set 3 Exercise #02: PS3_Ex02_Sorted.java
 * 
 * This program reads an integer n and checks if it is a square number.
 * 
 * 
 */

import java.util.*;

class Sorted {
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the size of the array: ");
    int size = sc.nextInt();

    int [] values = new int[size];
    System.out.print("Enter " + size + " elements: ");
    for(int i = 0; i < size; i++){
      values[i] = sc.nextInt();
    }
    if(isSorted(values) == true){
      System.out.println("Given array is sorted.");
    } else {
      System.out.println("Given array is not sorted.");
    }
    sc.close();
  }
  
  // Check if the array is sorted
  public static boolean isSorted(int[] arr) {
    for(int i = 1; i < arr.length; i++){
      if(arr[i-1] > arr[i]){
        return false;
      }
    }
    return true;
  }
}