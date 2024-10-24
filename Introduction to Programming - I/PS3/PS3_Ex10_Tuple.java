/*
 * Programming Methodology
 * Problem Set 3 Exercise #10: PS3_Ex10_Tuple.java
 * 
 * This program takes in a sorted array of distinct integers and a key,
 * and checks if there is a pair of elements in the array that sum up to the key.
 * 
 */

import java.util.*;

class Tuple {
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the number of distinct elements in sorted array: ");
    int num = sc.nextInt();
    int[] arr = new int[num];

    System.out.print("Enter " + num + " elements: ");
    for(int i = 0; i < num; i++){
      arr[i] = sc.nextInt();
  }
    
    System.out.print("Enter key: ");
    int key = sc.nextInt();
    
    boolean pair = checkTuple(arr, key);

    if(pair == true) {
    System.out.println("Exist");
    } else {
    System.out.println("Not exist");
    }
    sc.close(); 
  }
  
  // Check if the array has a pair of elements that sum up to the key
  public static boolean checkTuple(int[] arr, int key) {
    int front = 0, back = arr.length - 1;

    while(front < back) {
      if(arr[front] + arr[back] < key){
        front++;
      } else if(arr[front] + arr[back] > key){
        back--;
      } else {
        return true;
      }
    }
    return false;
  }
}