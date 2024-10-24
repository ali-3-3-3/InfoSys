/*
 * Programming Methodology
 * Problem Set 3 Exercise #17: PS3_Ex17_SortThreeDigits.java
 * 
 * This program reads an integer n and sorts the array according to the first 3 digits.
 * 
 * 
 */

import java.util.*;

class SortThreeDigits {
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the number of elements: ");
    int num = sc.nextInt();
    int[] arr = new int[num];

    System.out.print("Enter " + num + " elements: ");
    for (int i = 0; i < num; i++){
      arr[i] = sc.nextInt();
    }
    
    sortArray(arr);
    
    System.out.println("Sorted array: " + Arrays.toString(arr));
    sc.close();
    
  }
  
  // Bubble sort the given array according to the first 3 digits
  public static void sortArray(int[] arr) {
    int temp;
    for (int i = 0; i < arr.length-1; i++) {
      for(int j = i+1; j < arr.length; j++) {
        if(moreThan(arr[i], arr[j])) {
          temp = arr [i];
          arr [i] = arr [j];
          arr [j] = temp;
        }
      }
    }
  }
  
  // Compare num1 with num2 according to their first 3 digits.
  // Return true if num1 is bigger, or false otherwise
  public static boolean moreThan(int num1, int num2) {
    while (num1 >= 1000){
      num1 /= 10;
    }
    while (num2 >= 1000){
      num2 /= 10;
    }
    return num1 > num2;
  }
}