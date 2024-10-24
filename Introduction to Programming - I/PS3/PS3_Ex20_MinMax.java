/*
 * Programming Methodology
 * Problem Set 3 Exercise #20: PS3_Ex20_MinMax.java
 * 
 * This program reads in a matrix and finds the minimum and maximum values.
 * 
 * 
 */

import java.util.*;

class MinMax {
  
  public static void main(String[] args) {
    
    System.out.print("Enter the size of the matrix: ");
    Scanner sc=new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();

    System.out.println("Enter elements row by row:");
    int mtx[][]=new int[r][c];
           
    for(int i = 0; i < r; i++){            
      for(int j = 0; j < c ;j++){
          mtx[i][j]=sc.nextInt();
      }
    }
    int[] minMax = new int[2];
    getMinMax(mtx, minMax);
    
    System.out.println("Min = " + minMax[0]);
    System.out.println("Max = "+ minMax[1]);
    sc.close();
  }
  
  // Return the minimum and maximum values in a matrix
  public static int[] getMinMax(int[][] mtx, int[] minMax) {
    int min, max;

    min = max = mtx[0][0];
    for(int r = 0; r < mtx.length; r++){
      for(int c = 0; c < mtx[r].length; c++){
        min = (int)Math.min(min, mtx[r][c]);
        max = (int)Math.max(max, mtx[r][c]);
      }
    }
    minMax[0] = min;
    minMax[1] = max;

    return minMax;
  }
}