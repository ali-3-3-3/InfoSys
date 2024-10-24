/*
 * Programming Methodology
 * Problem Set 1 Exercise #03: PS1_Ex03_Freezer.java
 * 
 * This program estimates the temperature in a freezer 
 * given the elapsed time (hours) since a power failure.
 * 
 */ 

import java.util.Scanner;

class Freezer {
  
  public static void main(String[] args) {
    
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print ("Enter hours and minutes since power failure: ");
      
      // read hours and minutes one by one
      int hours = sc.nextInt();
      int minutes = sc.nextInt();
      
      // calculate temperature
      double temperature = computeTemperature(hours, minutes);
      
      System.out.println("Temperature in freezer = " + temperature);
    }
  }
  public static double computeTemperature(int hours, int minutes) {
    double a = minutes / 60.0 + hours + 2;
    return 4 * Math.pow((double)hours + (double) minutes / 60.0, 2) / a - 20;
  }
}