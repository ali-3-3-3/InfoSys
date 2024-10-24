/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #06: PS1_Ex06_TriangleCentroid.java
 * 
 * This program computes the centroid (G) of a triangle
 * given the coordinates of three vertices.
 * 
 * <Type your name here>
 */

import java.util.Scanner;
import java.text.DecimalFormat;

class TriangleCentroid {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Coordinates of 1st vertex: ");
    double x1 = sc.nextDouble();
    double y1 = sc.nextDouble();
    
    System.out.print("Coordinates of 2nd vertex: ");
    double x2 = sc.nextDouble();
    double y2 = sc.nextDouble();
    
    System.out.print("Coordinates of 3rd vertex: ");
    double x3 = sc.nextDouble();
    double y3 = sc.nextDouble();
    
    double x4 = (x1 + x2 + x3) / 3;
    double y4 = (y1 + y2 + y3) / 3;

    DecimalFormat df = new DecimalFormat("0.00");
    System.out.println("Coordinates of centroid = (" + df.format(x4) + ", " +  df.format(y4) + ")");
    sc.close();
  }
}