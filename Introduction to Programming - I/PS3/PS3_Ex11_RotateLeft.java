/*
 * Programming Methodology
 * Problem Set 3 Exercise #11: PS3_Ex11_RotateLeft.java
 * 
 * This program reads an integer n and rotates the array to the left.
 * 
 * 
 */

import java.util.*;

class RotateLeft {
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the number of elements: ");
    int size = sc.nextInt();    

    int[] arr = new int[size];

    System.out.print("Enter " + size + " elements: ");
    for(int i = 0; i < size; i++){
      arr[i] = sc.nextInt();
    }

    rotateLeft(arr);
    String str = Arrays.toString(arr);
    System.out.println(str);

    sc.close();
  }
  
  // Rotate the array to the left
  public static void rotateLeft(int[] arr) {
    int temp = arr[0];
    for(int i = 0; i < arr.length - 1; i++){
      arr[i] = arr[i + 1];
    }
    arr[arr.length - 1] = temp;
  }
}