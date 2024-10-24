/*
 * Programming Methodology
 * Problem Set 3 Exercise #03: PS3_Ex03_MaxDifference.java
 * 
 * This program reads in a list of integers and computes the 
 * maximum difference between two consecutive elements.
 * 
 */

import java.util.*;

class MaxDifference {
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the size of the array: ");
    int size = sc.nextInt();
    int[] arr = new int[size];
    
    System.out.print("Enter " + size + " elements: ");
    for(int i = 0; i < size; i++){
      arr[i] = sc.nextInt();
    }
    
    int difference = maxDifference(arr);

    System.out.println("Max difference = " + difference);

    sc.close();
  }
  
  // Compute the maximum difference between two consecutive elements.
  public static int maxDifference(int[] arr) {
    int difference = Math.abs(arr[1] - arr[0]);
      for(int i = 1; i < arr.length-1; i++)
          if(Math.abs(arr[i+1]-arr[i]) > difference)
              difference = Math.abs(arr[i+1] - arr[i]);
      return difference;
  }
}