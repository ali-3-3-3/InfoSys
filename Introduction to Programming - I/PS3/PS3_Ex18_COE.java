/*
 * Programming Methodology
 * Problem Set 3 Exercise #18: PS3_Ex18_COE.java
 * 
 * This program reads the number of available COEs, the number of bids, and the bids.
 * 
 * 
 */

import java.util.*;

class COE {
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the number of available COEs: ");
    int COEs = sc.nextInt();
    
    System.out.print("Enter the number of bids: ");
    int bids = sc.nextInt();
    int[] arr = new int[bids];
    
    System.out.print("Enter " + bids +  " bids: ");
    for(int i = 0; i < bids; i++){
      arr[i] = sc.nextInt();
    }  
    
    sortBids(arr);
    // for debugging
    // System.out.println(Arrays.toString(bids));
    
    System.out.println("COE final price this month is $" + findCOE(arr, COEs));
    sc.close();
  }
  
  // Sort bids in descending order
  public static void sortBids(int[] arr) {
    int temp;
    for (int i = 0; i < arr.length-1; i++) {
      for(int j = i+1; j < arr.length; j++) {
        if(arr[i] < arr[j]) {
          temp = arr [i];
          arr [i] = arr [j];
          arr [j] = temp;
        }
      }
    }
  }

  // Find the COE price
  public static int findCOE(int[] arr, int numCOEs){
    if(numCOEs >= arr.length){
      return arr[arr.length-1];
    }

    int i = numCOEs - 1;
    while (arr[i] == arr[i+1]){
      i--;
    }
    return arr[i];
  }
}