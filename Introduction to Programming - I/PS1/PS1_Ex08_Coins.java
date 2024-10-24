/*
 * Programming Methodology
 * Problem Set 1 Exercise #08: PS1_Ex08_Coins.java
 * 
 * This program calculates the minimum number of coins needed to make a given amount.
 * 
 * 
 */


import java.util.Scanner;

class Coins {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter amount in cents: ");
    int cents1 = sc.nextInt();
    int $1 = cents1 / 100;

    int cents2 = cents1 - $1 * 100;
    int c50 = cents2 / 50;

    int cents3 = cents2 - c50 * 50;
    int c20 = cents3 / 20;

    int cents4 = cents3 - c20 * 20;
    int c10 = cents4 / 10;

    int cents5 = cents4 - c10 * 10;
    int c5 = cents5 / 5;

    int cents6 = cents5 - c5 * 5;
    int c1 = cents6;

    int coins = $1 + c50 + c20 + c10 + c5 + c1;
    System.out.println("Minimum number of coins needed: " + coins);
    sc.close();
  }
}