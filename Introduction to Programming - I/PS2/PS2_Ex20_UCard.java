/*
 * Programming Methodology
 * Problem Set 2 Exercise #20: PS2_Ex20_UCard.java
 * 
 * Generates a check number using the Luhn-an algorithm, decides 
 * whether it is valid or invalid, and determines the branch that issued the card.
 * 
 */

import java.util.*;

class UCard {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter uCard Number: ");
    int ucard = sc.nextInt();
    int check = luhnah(ucard);
    
    System.out.println("The check number is " + check);
    
    if (check%7 == 0){ 
      System.out.println("Valid");
      printBranch(ucard);
    } else {
      System.out.println("Invalid");
    }
    sc.close();
  }
  
  // Luhn-ah algorithm
  public static int luhnah(int uCardNo) {
    int n = 0;
    Double digit;
    for (int i = 1; i < 10; i++) {
      digit = uCardNo % (Math.pow(10, i)) / Math.pow(10, i-1);
      if (i%2 != 0) {
        n += digit.intValue();
      } else {
        n += (digit.intValue() * 2 % 10) + (digit.intValue() * 2 / 10);
      } 
    }
    return n;  
  }
  
  // Printing Branch
  public static void printBranch(int uCard) {
    int numDigits = String.valueOf(uCard).length();
    Double firstTwoDigits = uCard / Math.pow(10, numDigits - 2); 
    String branch;
    switch (firstTwoDigits.intValue()) {
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
        branch = "East";
        break;
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
        branch = "West";
        break;
      default:
        branch = "Central";
        break;
    }
    System.out.println("Issued by " + branch + " branch");
  }
}