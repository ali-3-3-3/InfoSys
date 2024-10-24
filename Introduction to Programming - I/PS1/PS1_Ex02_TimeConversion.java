/*
 * Programming Methodology
 * Problem Set 1 Exercise #02: PS1_Ex02_TimeConversion.java
 * 
 * This program prints out time in hours and minutes.
 * 
 */

import java.util.Scanner; 

class TimeConversion {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter time in minutes: ");
    int time = sc.nextInt();
    int hours = time / 60;
    int minutes = time % 60;
    
    System.out.println(hours + " hours and " + minutes + " minutes");

    sc.close();
  }
}