/*
 * Programming Methodology
 * Problem Set 1 Exercise #13: PS1_Ex13_Travel.java
 * 
 * This program reads the coordinates of Home, Office and NTUC
 * and computes the total distance of travel.
 * 
 */

import java.text.DecimalFormat;
import java.util.Scanner;

class Travel {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.00");
    
    System.out.print("Enter X Y coordinates for Home: ");
    double hx = sc.nextDouble();
    double hy = sc.nextDouble();
    
    System.out.print("Enter X Y coordinates for Office: ");
    double ox = sc.nextDouble();
    double oy = sc.nextDouble();
    
    System.out.print("Enter X Y coordinates for NTUC: ");
    double nx = sc.nextDouble();
    double ny = sc.nextDouble();  
    
    double totaldist = distance(hx, hy, ox, oy) + distance(ox, oy, nx, ny) + distance(nx, ny, hx, hy);

    System.out.println("Distance of travel is " + df.format(totaldist));
    sc.close();
  }
  
  // <Write a short description of the method here>
  public static double distance(double x1, double y1, double x2, double y2) {
    
    return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
  }
}