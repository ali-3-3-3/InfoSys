/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #25: PS1_Ex25_Packing.java
 * 
 * This program reads the size of a tray and a slab, and computes the minimum
 * unused area of the tray after placing the slabs.
 * 
 */



import java.util.*;

 class Packing {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter size of tray: ");
    int tlength = sc.nextInt();
    int twidth = sc.nextInt();
    
    System.out.print("Enter size of slab: ");
    int slength = sc.nextInt();
    int swidth = sc.nextInt();
    
    System.out.println("Minimum unused area = " + area(tlength, twidth, slength, swidth));
    sc.close();
  }

  public static int area(int tl, int tw, int sl, int sw){
    int ver1 = tl * tw - ((tl/sl) * (tw/sw) * (sl * sw));

    int ver2 = tl * tw - ((tl/sw) * (tw/sl) * (sl * sw));

    if (ver1 > ver2){
      return ver2;
    } else {
      return ver1;
    }
  }
}