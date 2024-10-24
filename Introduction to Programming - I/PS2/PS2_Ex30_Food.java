/*
 * Programming Methodology
 * Problem Set 2 Exercise #30: PS2_Ex30_Food.java
 * 
 * This program reads the budget and the cost of fast-food 
 * and health-food meals and calculates the number of fast
 * -food and health-food meals that can be bought within the budget.
 * 
 */

import java.util.*;

class Food {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter budget: $");
    int budget = sc.nextInt();
    
    System.out.print("Enter fast-food cost per meal: $");
    int ffcost = sc.nextInt();
    
    System.out.print("Enter health-food cost per meal: $");
    int hfcost = sc.nextInt();

    int hfnum = budget / hfcost;
    int totalhfcost = hfnum * hfcost;
    int ffnum = (budget - totalhfcost) / ffcost;
    int totalffcost = ffnum * ffcost;
    int totalcost = totalhfcost + totalffcost;

    while (totalhfcost >= 0) {
      if(totalcost == budget){
        break;
      }

      totalhfcost -= hfcost;
      totalffcost = ((budget - totalhfcost) / ffcost) * ffcost;
      
      if(totalhfcost > 0 && totalhfcost + totalffcost > totalcost && totalhfcost + totalffcost <= budget){
        totalcost = totalhfcost + totalffcost;
        hfnum = totalhfcost / hfcost;
        ffnum = totalffcost / ffcost;
      }
    }
    
    System.out.println("Number of fast-food meals = " + ffnum);
    System.out.println("Number of health-food meals = " + hfnum);
    sc.close();
  }
}