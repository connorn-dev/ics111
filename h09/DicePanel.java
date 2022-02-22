package edu.ics111.h09 ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Could not get rid of import errors with check style

/**
* Shows a pair of dice that are rolled when the user clicks on the
* program. It is assumed that the panel is 100-by-100 pixels.
* * Logic was provided by: 
* http://courses.ics.hawaii.edu/ics111f21/javanotes7.0.2-web-site/c6/ex3-ans.html
* @author narowetz / oracle
*/
public class DicePanel extends JPanel{


  /**
  * A main routine allows this class to be run as an application.
  */
  public static void main(String[] args) {
    JFrame window = new JFrame("Dice");
    DicePanel content = new DicePanel();
    window.setContentPane(content);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocation(120,70);
    window.pack();
    window.setVisible(true);
  }
  // Create object outside to account for scope issues

  private GraphicalPairOfDice die; 

  /**
  * The constructor adds a mouse listener to the panel. The listener
  * will roll the dice when the user clicks the panel. Also, the
  * background color and the preferred size of the panel are set.
  */
  public DicePanel() {
    // instantiate new object
    die = new GraphicalPairOfDice(); 
    setPreferredSize(new Dimension(100,100));
    setBackground(new Color(200,200,255));
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent evt) {
        roll();
        System.out.println("click");
      }
    });
  }
  
  /**
  * Roll the dice by randomizing their values. Tell the
  * system to repaint the panel, to show the new values.
   */
  void roll() {
    die.roll();
    repaint();
  }
  
  
  /**
  * The paintComponent method just draws the two dice and draws
  * a one-pixel wide blue border around the panel. Antialiasing
  * is turned on to make the ovals look nicer.
  */
  public void paintComponent(Graphics g) {
    super.paintComponent(g); 
    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    g.setColor(Color.BLUE);
    g.drawRect(0,0,99,99);
    g.drawRect(1,1,97,97);
    // Pairs of dice
    die.drawDie(g, 1, 10, 10); 
    die.drawDie(g, 2, 55, 55); 
  }
}