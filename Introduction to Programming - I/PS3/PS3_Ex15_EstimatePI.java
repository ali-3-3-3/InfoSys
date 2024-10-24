/*
 * Programming Methodology
 * Problem Set 3 Exercise #15: PS3_Ex15_EstimatePI.java
 * 
 * This program reads a list of integers and estimates the value of pi.
 * 
 * 
 */

import java.util.*;
import java.text.*;

class EstimatePI {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the size of the list: ");
    int size = sc.nextInt();

    int[] list = new int[size];

    System.out.print("Enter " + size + " elements: ");
    for (int i = 0; i < size; i++){
      list[i] = sc.nextInt();
    }

    double pi = estimatePI(list);

    DecimalFormat df = new DecimalFormat("0.0000");
    System.out.println("Estimated pi = " + df.format(pi));

    sc.close();
  }

  // Estimate the value of pi
  public static double estimatePI(int[] list){
    int gcd;
    int pairs = 0;
    int count = 0;
    for(int i = 0; i < list.length; i++){
        for(int j = list.length - 1; j > i; j--){
        gcd = gcdByEuclidsAlgorithm(list[i], list[j]);
        pairs++;
        if(gcd == 1){
          count++;
        }
      }
    }
    return Math.sqrt(6.0 / ((double)count /(double) pairs));
  }

  // Compute the greatest common divisor of two numbers
  public static int gcdByEuclidsAlgorithm(int n1, int n2) {
    if (n2 == 0) {
        return n1;
    }
    return gcdByEuclidsAlgorithm(n2, n1 % n2);
  }
}