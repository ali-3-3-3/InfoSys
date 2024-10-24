package Ex04;
/*
 * Programming Methodology
 * Problem Set 4 Exercise #04: PS4_Ex04_Voucher.java
 * 
 * A voucher has three attributes: name (word),
 * face value (int) and amount of vouchers (int)
 * 
 */

class Voucher {
  
  // Attributes
  private String name;
  private int value;
  private int amt;
  
  // Constructor
  public Voucher(String voucherName, int voucherValue, int voucherAmt) {
    name = voucherName;
    value = voucherValue;
    amt = voucherAmt;
    
  }
  
  // Return name of a voucher
  public String getName() {
    return name;  // stub
  }
  
  // Return face value of a voucher
  public int getValue() {
    return value;  // stub
  }
  
  // Return the number of vouchers
  public int getAmt() {
    return amt;  // stub
  }
  
  // Compute the number of vouchers to use given a price
  // such that there is no overpay
  public int useVoucher(int price) {
    int numberOfVouchers = price / value;
    if (numberOfVouchers > amt){
        return amt;
    } else {
        return numberOfVouchers;
    }
  }
}