package Ex04;
/*
 * Programming Methodology
 * Problem Set 4 Exercise #04: PS4_Ex04_UseVoucher.java
 * 
 * This program helps Mr. Tan to use a couple of vouchers
 * wisely together with cash such that there is no overpay anytime.
 * 
 */

import java.util.*;

class UseVoucher {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter voucher name: ");
    String names = sc.next();
    
    System.out.print("Enter voucher face value: $");
    int face = sc.nextInt();
    
    System.out.print("Enter the number of vouchers: ");
    int number = sc.nextInt();
    
    // create a Voucher object with 3 values read
    Voucher v1 = new Voucher(names, face, number);
    
    System.out.print("Enter the price to pay: $");
    int price = sc.nextInt();
    
    // Call useVoucher() method to compute the number
    // of vouchers to be used
    int vouchersUsed = v1.useVoucher(price);
    
    System.out.println("Use " + vouchersUsed + " " + names + " voucher(s)");
    System.out.println("Cash payment: $" + (price - vouchersUsed*face));
    System.out.println("There remains " + (number - vouchersUsed) + " voucher(s)");

    sc.close();
  }
}