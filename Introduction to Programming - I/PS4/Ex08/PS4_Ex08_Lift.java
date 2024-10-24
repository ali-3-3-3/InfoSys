package Ex08;
/*
 * Programming Methodology
 * Problem Set 1 Exercise #08: Lift.java
 * 
 * This program contains a Lift class that models a lift.
 * 
 */

class Lift {
  
  private int currLevel, distance;  // current level and travel distance
  
  // SPEED is defined as a constant and can be used in Lift class directly
  private final int SPEED = 2;  // two seconds per level
  
  // Constructor
  public Lift() {
    currLevel = 1;
    distance = 0;
  }
  
  // Move lift to fromLevel to pick up passenger and then
  // send passenger to toLevel
  public void move(int fromLevel, int toLevel) {
   distance += (Math.abs(fromLevel - currLevel) + Math.abs(toLevel-fromLevel));
   currLevel = toLevel;
  }
   
   
  
  // Return current level
  public int getLevel() {
    return currLevel;
  }
  
  // Return the time a lift has travelled
  public int getTime() {
    return distance*SPEED;
  }
}