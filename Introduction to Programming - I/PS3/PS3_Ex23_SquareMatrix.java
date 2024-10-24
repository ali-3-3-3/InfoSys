/*
 * Programming Methodology
 * Problem Set 3 Exercise #23: PS3_Ex23_SquareMatrix.java
 * 
 * This program reads a square matrix and checks if it is a 
 * diagonal matrix or an upper triangular matrix.
 * 
 */

import java.util.*;

class SquareMatrix {
  
  public static void main(String[] args) {
    
    System.out.print("Enter the size of the square matrix: ");
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();

    System.out.println("Enter elements row by row:");
    int mtx[][] = new int[r][c];
           
    for(int i = 0; i < r; i++){            
      for(int j = 0; j < c ;j++){
          mtx[i][j]=sc.nextInt();
      }
    }
    
    if(isDiagonal(mtx)){
    System.out.println("Given matrix is a diagonal matrix.");
    } else {
    System.out.println("Given matrix is not a diagonal matrix.");
    }

    if(isUpperTriangular(mtx)){
    System.out.println("Given matrix is an upper triangular matrix.");
    } else {
    System.out.println("Given matrix is not an upper triangular matrix.");
    }

    sc.close();
  }

  // Check if the matrix is a diagonal matrix
  public static boolean isDiagonal(int[][] mtx){
    int len = mtx.length;
    for(int r = 0; r < len; r++){
      for(int c = 0; c < len; c++){
        if(r!= c && mtx[r][c] != 0){
          return false;
        }
      }
    }
    return true;
  }

  // Check if the matrix is an upper triangular matrix
  public static boolean isUpperTriangular(int[][] mtx){
    int len = mtx.length;
    for(int r = 0; r < len; r++){
      for(int c = 0; c < len; c++){
        if(r > c && mtx[r][c] != 0){
          return false;
        }
      }
    }
    return true;
  }
}