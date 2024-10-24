/*
 * Programming Methodology
 * Problem Set 4 Exercise #15: PS4_Ex15_PigLatin.java
 * 
 * This program reads in a sentence comprising words,
 * and converts the it into Pig Latin.
 * Pig Latin is a language game primarily used in English.
 * It is usually used by children, who often use it to
 * converse in (perceived) privacy from adults,
 * or simply for amusement. (From Wikipedia)
 * 
 */

import java.util.*;

class PigLatin {
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter a sentence: ");
    String line = sc.nextLine();
    String[] words = line.split(" ");
    String converted = " ";
    for (int i = 0; i < words.length - 1; i++){
      converted += convert(words[i]) + " ";
    }
    converted += convert(words[words.length - 1]);
    System.out.println("Converted:" + converted);
    sc.close();
  }
  
  // Convert a single word.
  // For a word starting with a consonant, move that first consonant
  // to the end of the word and append "ay".
  // For a word starting with a vowel, simply append "way" to the word.
  // Return the converted word.
  public static String convert(String word) {
    String vowels = "aeiou";
    if (vowels.indexOf(word.charAt(0)) != -1){
      return word + "way";
    } else {
      return word.substring(1) + word.charAt(0) + "ay";
    }

  }
}