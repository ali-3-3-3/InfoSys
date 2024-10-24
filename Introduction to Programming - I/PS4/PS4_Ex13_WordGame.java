/*
 * Programming Methodology
 * Problem Set 4 Exercise #13: PS4_Ex13_WordGame.java
 * 
 * This program reads in a word and computes
 * the total points of all the letters in the word.
 * 
 */

import java.util.*;

class WordGame {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a word: ");
    String word = sc.next();
    
    System.out.println("Total score = " + computeScore(word));
    sc.close();
  }
  
  // Compute total score of letters in a word
  public static int computeScore(String word) {
    int points = 0;
    for (int i = 0; i < word.length(); i++){
      switch(word.charAt(i)){
        case 'A': case 'E': case 'I': case 'L': case 'N': case 'O': case 'R': case 'S': case 'T': case 'U':
          points++;
          break;
        case 'D': case 'G':
          points += 2;
          break;
        case 'B': case 'C': case'M': case 'P':
          points += 3;
          break;
        case 'F': case 'H': case 'V': case 'W': case 'Y':
          points += 4;
          break;
        case 'K':
          points+= 5;
        case 'J': case 'X':
          points += 8;
          break;
        case 'Q': case 'Z':
          points += 10;
          break;
      }
    }
    return points;
  }
}