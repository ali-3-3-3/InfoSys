package Ex08;
/*
 * Programming Methodology
 * Problem Set 1 Exercise #08: OperateLifts.java
 * 
 * This program receives instructions on two
 * lifts and move them from one level to another.
 * 
 */

import java.util.*;

class OperateLifts {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    
    Lift l1 = new Lift ();
    Lift l2 = new Lift();

    System.out.print("How many instructions? ");
    int instructions = sc.nextInt();
    
    System.out.println("Enter " + instructions + " instructions:");
   

    for(int i = 0; i < instructions; i++){
      int first = sc.nextInt();
      int second = sc.nextInt();
      int third = sc.nextInt();
     

      if(first == 1){
        l1.move(second, third);
        
      } else if(first == 2){
        l2.move(second, third);
        
      }

    }
    
    System.out.println("lift 1 took " + l1.getTime() + " seconds and ended at level " + l1.getLevel());
    System.out.println("lift 2 took " + l2.getTime() + " seconds and ended at level " + l2.getLevel());

    sc.close();
  }
}