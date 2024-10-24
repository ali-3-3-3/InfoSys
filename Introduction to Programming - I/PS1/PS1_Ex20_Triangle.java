/*
 * Programming Methodology
 * Problem Set 1 Exercise #20: PS1_Ex20_Triangle.java
 * 
 * This program reads three integers representing the sides of a triangle
 * and prints out the type of the triangle.
 * 
 */

import java.util.*;

class Triangle {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    
    if (a==b && b==c) {
      System.out.println("Equilateral");
    } else if (a >= b + c || b >= a + c || c >= b + a) {
      System.out.println("Not a triangle");
    } else if (a==b || b==c || a==c) {
      System.out.println("Isosceles");
    } else {
      System.out.println("Scalene");
    }

    sc.close();
  }
}