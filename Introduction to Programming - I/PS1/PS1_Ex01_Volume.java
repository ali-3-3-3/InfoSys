/*
 * Programming Methodology
 * Problem Set 1 Exercise #01: PS1_Ex01_Volume.java
 * 
 * This program reads length, width and height of a box, computes its volume.
 * 
 */

import java.util.Scanner; 

class Volume {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter length: ");
    int length = sc.nextInt();
    
    System.out.print("Enter width: ");
    int width = sc.nextInt();
    
    System.out.print("Enter height: ");
    int height = sc.nextInt();
    
    int volume = length * width * height;
      System.out.println("Volume = " + volume);

    sc.close();
  }
}