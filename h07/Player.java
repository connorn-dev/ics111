package edu.ics111.h07;

/**
 * The player class is used to create player objects with name and score.
 * @author narowetz
 */
public class Player {
  
  String name; 
  int score;
  
  /**
   * Creates the object Player. 
   */
  public Player(String name, int score) {
    this.name = name; 
    this.score = score; 
  }
  
  /**
   * Sets the name of the object.
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Sets the score of the object.
   */
  public void setScore(int score) {
    this.score = score;
  }
  
  /**
   * Gets the name of the object.
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Gets the score of the object.
   */
  public int getScore() {
    return this.score;
  }
  
}
