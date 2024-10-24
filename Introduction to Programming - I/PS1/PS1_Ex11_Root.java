/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #11: PS1_Ex11_Root.java
 * 
 * This program reads three coefficients of a quadratic equation
 * and returns the bigger root.
 */


import java.util.Scanner;
import java.text.DecimalFormat;

class Root {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter coefficients (a b c): ");
    double a = sc.nextDouble();
    double b = sc.nextDouble();
    double c = sc.nextDouble();
    double root = getRoot(a, b, c);
    
    DecimalFormat df = new DecimalFormat("0.00");
    System.out.println("Bigger root is " + df.format(root));
    sc.close();
    
  }
  
  // Take the three coefficients and return the bigger root
  public static double getRoot(double a, double b, double c) {
    
    return (-b + Math.sqrt(Math.pow(b, 2)-4 * a * c))/ (2 * a); 
  }
}