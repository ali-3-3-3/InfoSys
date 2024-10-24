/*
 * Programming Methodology
 * Problem Set 3 Exercise #30: PS3_Ex30_Minesweeper.java
 * 
 * This program reads in a minefield containing mines,
 * and computes the values of the safe squares.
 * 
 */

import java.util.*;

class Minesweeper {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter level (1-3): ");
    int level = sc.nextInt();
    int length = 0, width = 0;

    switch(level){
      case 1:
        length = 8;
        width = 8;
        break;
      case 2:
        length = 12;
        width = 16;
        break;
      case 3:
        length = 16;
        width = 30;
        break;
    }
    char[][] board = new char[length][width];
    System.out.println("Enter the " + length + " x " + width + " board:");
    readBoard(board, length, width);

    computeScore(board, length, width);
    
    printBoard(board, length, width);

    sc.close();
  }
  
  // Read the board
  public static void readBoard(char[][] board, int l, int w){
    Scanner sc = new Scanner(System.in);
    for(int row = 0; row < l; row++){
      for(int col = 0; col < w; col++){
        board[row][col] = sc.next().charAt(0);
      }
    }
    sc.close();
  }

  // Compute the score
  public static void computeScore(char[][] board, int l, int w){
    for(int row = 0; row < l; row++){
      for(int col = 0; col <w; col++){
        if(board[row][col] == '*'){
          board[row][col] = 9;
        } else {
          board[row][col] = 0;
        }
      }
    }

    for(int row = 0; row < l; row++){
      for(int col = 0; col < w; col++){
        int[] x = {row - 1, row, row + 1, row - 1, row + 1, row - 1, row, row + 1};
        int[] y = {col - 1, col - 1, col - 1, col, col, col + 1, col + 1, col + 1};
        
        for(int i = 0; i < 8; i++){
          if(x[i] == -1 || x[i] > l - 1){
            x[i] = 100;
          }
          if(y[i] == -1 || y[i] > w){
            y[i] = 100;
          }
        }

        for(int i = 0; i < 8; i++){
          if(x[i] != 100 || y[i] != 100){
            if(board[x[i]][y[i]] == 9){
              board[row][col]++;
            }
          }
        }
      }
    }
  }

  // Print the board
  public static void printBoard(char[][] board, int l, int w){
    for(int row = 0; row < l; row++){
      for(int col = 0; col < w; col++){
        System.out.print(board[row][col]);
        if(col < w - 1){
          System.out.println();
        }
      }
    }
  }
}