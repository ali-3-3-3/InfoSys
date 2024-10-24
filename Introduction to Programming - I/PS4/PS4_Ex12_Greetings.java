/*
 * Programming Methodology
 * Problem Set 4 Exercise #12: PS4_Ex12_Greetings.java
 * 
 * This program reads age, name and gender of a person,
 * prints out corresponding greeting message.
 * 
 */

import java.util.*;

class Greetings {
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Your age? ");
    int age = sc.nextInt();
    sc.nextLine();

    System.out.print("Your name? ");
    String name = sc.nextLine();

    System.out.print("Your gender? ");
    String gender = sc.nextLine();
    
    if(gender.equals("Male")){
      if (age < 18){
        System.out.println("Hello boy " + name);
      } else {
        System.out.println("Hello Mr. " + name);
      }
    } else {
      if(age < 18){
        System.out.println("Hey girl " + name);
      } else {
        System.out.println("Hey Ms. " + name);
      }
    }

    sc.close();
  }
}