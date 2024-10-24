/*
 * Programming Methodology
 * Problem Set 1 Exercise #23: PS1_Ex23_SAT.java
 * 
 * This program calculates the SAT score percentile and IQ score.
 * 
 * 
 */



import java.util.*;
import java.text.*;

class SAT {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter scores: ");
    int verbal = sc.nextInt();
    int maths = sc.nextInt();
    int writing = sc.nextInt();
    
    int percentile = computePercentile(verbal, maths, writing);

    System.out.println("The SAT score is in the " + percentile + " percentile.");
    
    double IQ = computeIQScore(verbal, maths);

    DecimalFormat df = new DecimalFormat("0.00");
    
    System.out.println("The IQ score is " + df.format(IQ));
    
    if (verbal > 600 && maths > 600 && writing > 600 || IQ >= 120) {
      System.out.println("Wow, this is amazing!");
    }
    sc.close();
  }
  
  // Calculate student's SAT score percentile
  public static int computePercentile(int verbal, int maths, int writing) {
    int SAT = verbal + maths + writing;
    int percentile;
    if (SAT >= 2200) {
      percentile = 99;
    } else if (SAT >= 2000) {
      percentile = 95;
    } else if (SAT > 1500) {
      percentile = 50;
    } else {
      percentile = 10;
    }

    return percentile; 
  }
  
  // Calculate student's IQ score
  public static double computeIQScore(int verbal, int maths) {
    
    return 0.095 * maths + 0.003 * verbal + 50.241;
  }
}