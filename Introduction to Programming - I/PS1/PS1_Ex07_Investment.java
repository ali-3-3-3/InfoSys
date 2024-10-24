/*
 * Programming Methodology
 * Problem Set 1 Exercise #07: PS1_Ex07_Investment.java
 * 
 * This program computes the amount earned given principal amount,
 * interest rate, and number of years, based on compound interest.
 * 
 */

import java.util.*;
import java.text.*;

class Investment {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter principal amount: ");
    double principal = sc.nextDouble();
    
    System.out.print("Enter interest rate   : ");
    double rate = sc.nextDouble();
    double interest = rate / 100;
    
    System.out.print("Enter number of years : ");
    double years = sc.nextDouble();
    
    double amount = principal * ( 1 - Math.pow(interest, years + 1)) / (1 - interest);

    DecimalFormat df = new DecimalFormat("0.00");
    System.out.println("Amount = $" + df.format(amount));
    sc.close();
  }
}