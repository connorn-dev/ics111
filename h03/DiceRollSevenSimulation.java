package edu.ics111.h03;

/**
 * A program that calculates to number of dice rolls it takes to roll a seven. 
 * @author narowetz
 */
public class DiceRollSevenSimulation {

  /**
   * Find how many times it takes to roll a seven with two 6-sided dice. 
   */
  public static void main(String[] args) {
    
    // Welcome message to user
    System.out.println("Welcome, please type the keyword roll to start the simulation.");
    // Get input from user to start the simulation.
    String userInput = TextIO.getln();
    
    if (userInput.equals("roll")) {
      // Setup variables (dices, total of dice, and how many rolls)
      int rollOne;
      int rollTwo;
      int rollValue = 0;
      int rollCounter = 0;
      
      // Setup while loop to run dice roll until 7. 
      while (rollValue != 7) {
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
        if (rollValue == 7) {
          System.out.println("\nYou rolled a 7!, it took: " + rollCounter + " rolls.");
        }
      }
      
     
    } else {
      System.out.println("Error, please type roll to start program.");
    }
    
    
  }
}