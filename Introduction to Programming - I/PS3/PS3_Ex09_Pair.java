/*
 * Programming Methodology
 * Problem Set 3 Exercise #09: PS3_Ex09_Pair.java
 * 
 * This program takes in an array of distinct integers and a key, 
 * and checks if there is a pair of elements in the array that sum up to the key.
 * 
 */

import java.util.*;

class Pair {
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the number of distinct elements: ");
    int num = sc.nextInt();
    int[] arr = new int[num];
    
    System.out.print("Enter " + num + " elements: ");
    for(int i = 0; i < num; i++){
        arr[i] = sc.nextInt();
    }
    
    System.out.print("Enter key: ");
    int key = sc.nextInt();
    
    boolean pair = checkPair(arr, key);

    if(pair == true) {
    System.out.println("Exist");
    } else {
    System.out.println("Not exist");
    }

    sc.close();
  }
  
  // Check if the array has a pair of elements that sum up to the key
  public static boolean checkPair(int[] arr, int key) {
    for(int i = 0; i < arr.length - 1; i++) {
      for(int j = i+1; j < arr.length; j++){
        if(arr[i] + arr[j] == key){
          return true;
        }
      }
    }
    return false;
  }
}