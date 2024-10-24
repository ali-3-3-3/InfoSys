/*
 * Programming Methodology
 * Problem Set 1 Exercise #10: PS1_Ex10_TheeInts.java
 * 
 * This program reads three positive integers,
 * prints out their digits in hundredth position.
 * 
 */


import java.util.Scanner;
 class TheeInts {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter 3 positive integers: ");
    int first = sc.nextInt();
    int second = sc.nextInt();
    int third = sc.nextInt();

    int a = getHundredth(first);
    int b = getHundredth(second);
    int c = getHundredth(third);

    System.out.println(a + " " + b + " " + c);
    sc.close();

  }
  
  // Take a number and return the digit in hundredth position
  public static int getHundredth(int num) {
    
    return num / 100 % 10;
  }
}