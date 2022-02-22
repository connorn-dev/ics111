package edu.ics111.h09;

// Imports for graphics 
import java.awt.Color;
import java.awt.Graphics;

/**
* This program creates a window with 2 dice and when you click it rolls them.
* Logic was provided by: 
* http://courses.ics.hawaii.edu/ics111f21/javanotes7.0.2-web-site/c6/ex3-ans.html
* @author narowetz
*/
public class GraphicalPairOfDice extends PairOfDice {
  
  /**
   * Draws the given die at x and y.
   * @param g The Graphics context.
   * @param dieNum the number of the die either 1 or 2.
   * @param x the x location for the die.
   * @param y the y location for the die.
   */
  public void drawDie(Graphics g, int dieNum, int x, int y) {
    // Set the value of val equal to the value of dice from pairofdice class
    int val;

    if (dieNum == 1) {
      val = die1;
      System.out.println("val set");
    } else {
      val = die2;
    } 
      
    // draw the die
    g.setColor(Color.white);
    g.fillRect(x, y, 35, 35);
    g.setColor(Color.black);
    g.drawRect(x, y, 34, 34);
    if (val > 1) {
      g.fillOval(x + 3, y + 3, 9, 9);
    }
    if (val > 3) {
      g.fillOval(x + 23, y + 3, 9, 9);
    }
    if (val == 6) {
      g.fillOval(x + 3, y + 13, 9, 9);
    }
    if (val % 2 == 1) {
      g.fillOval(x + 13, y + 13, 9, 9);
    }
    if (val == 6) {
      g.fillOval(x + 23, y + 13, 9, 9);
    }
    if (val > 3) {
      g.fillOval(x + 3, y + 23, 9, 9);
    }
    if (val > 1) { 
      g.fillOval(x + 23, y + 23, 9, 9);
    }
  }
}

   