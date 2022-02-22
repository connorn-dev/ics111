package edu.ics111.h03;

/**
 * A program that calculates to number of dice rolls it takes to a custom value between 2 and 12. 
 * @author narowetz
 */
public class DiceRollCustomSimulation {

  /**
   * Find how many times it takes to roll a custom value. 
   */
  public static void main(String[] args) {
    
    // Welcome message to user.
    System.out.println("Welcome, please type a number between 2 and 12 to run the simulation and "
        + "calculate how many dice rolls it takes to roll.");
    // Get input from user for number used in simulation.
    int userValue = TextIO.getInt();
    
    if (userValue >= 2 && userValue <= 12) {
      // Setup variables (dices, total of dice, and how many rolls).
      int rollOne;
      int rollTwo;
      int rollValue = 0;
      int rollCounter = 0;
      
      // Setup while loop to run dice roll until custom value. 
      while (rollValue != userValue) {
        // Roll both dice and assign value.
        rollOne = (int) (Math.random() * 6) + 1;
        rollTwo = (int) (Math.random() * 6) + 1;
        // Add dice values together to get roll number.
        rollValue = rollOne + rollTwo;
        // Add to roll counter.
        rollCounter++;
        // Return statement with number rolled and current roll counter. 
        System.out.println("You rolled a: " + rollValue + ", rollCounter = " + rollCounter);
        // Print statement once conditions are met. 
        if (rollValue == userValue) {
          System.out.println("\nYou rolled a " + userValue + "!, it took: " 
              + rollCounter + " rolls.");
        }
      }
      
     
    } else {
      System.out.println("Error please try again, only values 2-12 will be accepted.");
    }
    
    
  }
}