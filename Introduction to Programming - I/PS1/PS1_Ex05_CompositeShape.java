/*
 * Programming Methodology
 * Problem Set 1 Exercise #05: PS1_Ex05_CompositeShape.java
 * 
 * This program computes the area of the given composite shape.
 * 
 */

import java.util.Scanner;
import java.text.DecimalFormat;

class CompositeShape {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter length of rectangle: ");
    double length = sc.nextDouble();
    
    
    System.out.print("Enter width of rectangle: ");
    double width = sc.nextDouble();
    
    double radius = length / 2;

    double area = 1.0/2 * Math.PI * Math.pow(radius, 2) + length * width;
    DecimalFormat df = new DecimalFormat("0.0000");
    System.out.println("Area = " + df.format(area));
    sc.close();
  }
}
