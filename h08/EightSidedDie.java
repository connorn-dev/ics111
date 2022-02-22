package edu.ics111.h08;

// Definition: EightSidedDice is a class which represents a structure for objects to be created 
// With the roll function assigning the objects value to a random number 1-8, 
// and the getValue function returning the value of the variable value. 
public class EightSidedDie {

  private int value;
  
  public void roll() {
    value = (int)(Math.random() * 8) + 1;
  }
  
  public int getValue() {
    return value; 
  }
}
