package edu.ics111.h03;

/**
 * A program that tells if even or odd.
 * @author narowetz
 */

public class EvenOrOdd {

  /**
   * tells if even or odd.
   */
  public static void main(String[] args) {
   
    System.out.println("Welcome, please enter an integer.");
    int num = TextIO.getInt();
    
    if((num % 2) == 0) {
      System.out.println("The number is even.");
    } else {
      System.out.println("The number is odd.");
    }
  
  
  }
}