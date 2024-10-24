package Ex01;
/*
 * Programming Methodology
 * Problem Set 4 Exercise #01: PS4_Ex01_MyCircle.java
 * 
 * This MyCircle class contains an attribute 'radius',
 * constructor, 2 methods to set/change radius,
 * and another method to compute the area of a circle.
 * 
 */

class MyCircle {
  
  // Attribute (Data member)
  private double radius;
  
  // This constructor creates a MyCircle object with zero radius
  public MyCircle( ) {
    
  }   
  
  // Retrieve radius of a MyCircle object
  public double getRadius() {
    return radius;
  }   
  
  // Set radius of a MyCircle object
  public void setRadius(double rad) {
    radius = rad;
  }
  
  // Compute area of a MyCircle object
  public double computeArea() {
    return Math.PI * Math.pow(radius, 2); 
  }
}