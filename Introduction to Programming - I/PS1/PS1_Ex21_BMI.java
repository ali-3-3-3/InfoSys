/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #21: PS1_Ex21_BMI.java
 * 
 * This program takes in the gender, weight and height of a person
 * and calculates the BMI and returns the body type.
 * 
 */



import java.util.Scanner;
import java.lang.Math;
class BMI {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter your gender (0 for female, 1 for male): ");
    int gender = sc.nextInt();
    
    System.out.print("Enter your weight (kg) and height (m): ");
    double weight = sc.nextDouble();
    double height = sc.nextDouble();     
    
    int body = bodyType(gender, weight, height);
    if (body == -1) {
      System.out.println("Stuff yourself with more food!");
    } else if (body == 0) {
      System.out.println("Great! Maintain it!");
    } else if (body == 1) {
      System.out.println("Time to join the gym!");
    }

    sc.close();
  }
  
  // Calculate BMI and return body type
  public static int bodyType(int gender, double weight, double height) {
    
    double BMII = weight / Math.pow(height, 2);
    int body = 0;
    switch (gender) {
      case 0:
        if(BMII <= 19.0) {
          body = -1;
        }
        else if (BMII <= 24.0) {
          body = 0;
        } 
        else if (BMII > 24.0) {
          body = 1;
        }
        break;
      case 1:
        if(BMII <= 20.0) {
          body = -1;
        }
        else if (BMII <= 25.0) {
          body = 0;
        } 
        else if (BMII > 25.0) {
          body = 1;
         }
      break;
  }
    return body;
}
 }