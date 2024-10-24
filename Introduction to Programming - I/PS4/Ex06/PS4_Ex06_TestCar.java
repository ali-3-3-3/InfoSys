package Ex06;
/*
 * Programming Methodology
 * Problem Set 4 Exercise #06: PS4_Ex06_Car.java
 * 
 * This program uses Car class. It reads in a car's information,
 * and creates a Car object. It then reads a list of trips, updates
 * the odometer reading, and computes the average distance travelled per trip.
 * 
 */

import java.util.*;

class TestCar {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
        
    System.out.print("Enter model: ");
    String model = sc.nextLine();
    
    System.out.print("Enter colour: ");
    String clr = sc.next();
    
    System.out.print("Enter odometer value: ");
    double odm = sc.nextDouble();
    
    // create a car object with 3 values read
    Car car = new Car(model, clr, odm);
    
    System.out.print("Enter the number of trips: ");
    int trips = sc.nextInt();
    
    // compute the total distance travelled
    double dist;
    double totalDist = 0;
    for (int i = 1; i <= trips; i++){
        System.out.print("Distance for trip " + i + ": ");
        dist = sc.nextDouble();
        totalDist += dist;
        car.updateOdometer(dist);
    }
    
    // update car with the total distance
    System.out.println("Model: " + model);
    System.out.println("Colour: " + clr);
    if (car.getOdometer() > 999.0){
      System.out.println("Odometer: " + (car.getOdometer()-1000));
    } else {
      System.out.println("Odometer: " + car.getOdometer());
    }
    
    
    System.out.println("Trips: " + trips);
    System.out.println("Distance per trip: " + (totalDist / trips));

    sc.close();
  }
}