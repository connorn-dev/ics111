package edu.ics111.h02;

// Ran into floating point error and found big decimal solution
// Source: https://www.geeksforgeeks.org/bigdecimal-class-java/
// Source: https://www.javatpoint.com/post/java-scanner-nextbigdecimal-method
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * A program that calculates the change needed after someone purchases an item. 
 * @author narowetz
 */

public class CorrectChange {

  /**
   * Class will ask user the cost of a item and the cash give, will return the change
   * needed in dollars, quarters, dimes, nickels, and penny's.
   */
  public static void main(String[] args) {
    
    // Set up getting input from user
    Scanner s = new Scanner(System.in);
    
    // Ask the user the cost of the item
    System.out.println("How much did the item cost?");
    
    // Store the item value
    BigDecimal itemValue = s.nextBigDecimal();
    
    // Ask the user how much they paid
    System.out.println("How much did you pay?");
    
    // Store the amount paid & close scanner
    BigDecimal paidValue = s.nextBigDecimal();
    s.close();
    
    
    // Calculate change needed and store it 
    BigDecimal changeNeeded = paidValue.subtract(itemValue);
    System.out.println("change needed = $" + changeNeeded);
    // Create values for each currency 
    BigDecimal dollar = new BigDecimal("1.00");
    BigDecimal quarter = new BigDecimal("0.25");
    BigDecimal dime = new BigDecimal("0.10");
    BigDecimal nickel = new BigDecimal("0.05");
    BigDecimal penny = new BigDecimal("0.01");
    
    // Create dollars, quarters, dimes, nickels, and penny variables to store needed amounts
    int dollars = 0;
    int quarters = 0; 
    int dimes = 0;
    int nickels = 0;
    int pennys = 0;
    
    
    
    
    if (changeNeeded.compareTo(BigDecimal.ZERO) == -1) {
      System.out.print("Error: Item cost was more than Money given, Change = 0");
    
    } else {
      // Create loop to go through change types(Source: https://www.w3schools.com/java/java_while_loop.asp)
      // Source: https://stackoverflow.com/questions/4164521/compare-if-bigdecimal-is-greater-than-zero
      while (changeNeeded.compareTo(BigDecimal.ZERO) == 1) {
        // Calculate dollars needed and store it
        if (changeNeeded.compareTo(dollar) >= 0) {
          changeNeeded = changeNeeded.subtract(dollar);
          dollars++;

        // Calculate quarters needed and store it 
        } else if (changeNeeded.compareTo(quarter) >= 0) {
          changeNeeded = changeNeeded.subtract(quarter);
          quarters++;
        
        // Calculate dimes needed and store it 
        } else if (changeNeeded.compareTo(dime) >= 0) {
          changeNeeded = changeNeeded.subtract(dime);
          dimes++;
        
        // Calculate nickels needed and store it 
        } else if (changeNeeded.compareTo(nickel) >= 0) {
          changeNeeded = changeNeeded.subtract(nickel);
          nickels++;
        
        // Calculate penny's needed and store it 
        } else if (changeNeeded.compareTo(penny) >= 0) {
          changeNeeded = changeNeeded.subtract(penny);
          pennys++;
        
        }
      }
    
      //Print out the results of the calculation
      System.out.println("The change is: " + dollars + " dollars, " + quarters + " quarters, "
          + dimes + " dimes, " + nickels + " nickels, " + pennys + " pennies.");
    
    }
  }
}