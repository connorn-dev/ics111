package edu.ics111.h10;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * A JPanel that allows two players to play the two dice pig game.
 * 
 * @author Cam Moore
 */
@SuppressWarnings("serial")
public class TwoDicePigPanel extends JPanel {
  private PlayerPanel p1;
  private PlayerPanel p2;
  private DicePanel dice;
  private JButton roll;
  private JButton hold;
  private JLabel turnLabel;
  private int turnScore;
  private int winningTotal;
  private PlayerPanel currentPlayer;

  /**
   * ActionListener for handling the Roll and Hold buttons.
   */
  private class ButtonListener implements ActionListener {
    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equalsIgnoreCase("roll")) {
        dice.roll();
        doRules();
      } else if (e.getActionCommand().equalsIgnoreCase("hold")) {
        currentPlayer.setScore(currentPlayer.getScore() + turnScore);
        turnScore = 0;
        if (currentPlayer.getScore() > winningTotal) {
          int choice = JOptionPane.showConfirmDialog(currentPlayer.getParent(),
              currentPlayer.getName() + " is the winner.\n Do you want to play again?", "Winner",
              JOptionPane.YES_NO_OPTION);
          if (choice == JOptionPane.NO_OPTION) {
            System.exit(0);
          } else {
            playGame();
          }
        }
        swapPlayers();

      }

    }

  }

  /**
   * Creates a new TwoDicePigPanel to play the game.
   * 
   */
  public TwoDicePigPanel() {
    // CAM MOORE FOR BASE CODE
    // Get user input with pop up boxes (Credit TA: #6 Micah) 
    String player1Name = JOptionPane.showInputDialog("Player One Name: ");
    String player2Name = JOptionPane.showInputDialog("Player Two Name: ");
    // Can't fix check style error because the logic would be messed up
    String scoreToWin = JOptionPane.showInputDialog("Enter Score to win: ");
    this.p1 = new PlayerPanel(player1Name);
    this.p2 = new PlayerPanel(player2Name);
    this.currentPlayer = p1;
    this.dice = new DicePanel();
    this.roll = new JButton("Roll");
    roll.addActionListener(new ButtonListener());
    this.hold = new JButton("Hold");
    hold.addActionListener(new ButtonListener());
    this.turnLabel = new JLabel("", JLabel.CENTER);
    this.turnScore = 0;
    // Change score to win to variable set by user 
    this.winningTotal = Integer.parseInt(scoreToWin);
    this.turnLabel.setText(getTurnText());
    setLayout(new BorderLayout());
    add(p1, BorderLayout.WEST);
    add(p2, BorderLayout.EAST);
    add(dice, BorderLayout.CENTER);
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(roll, BorderLayout.WEST);
    panel.add(turnLabel, BorderLayout.CENTER);
    panel.add(hold, BorderLayout.EAST);
    add(panel, BorderLayout.SOUTH);
  }


  /**
   * Returns the winningTotal.
   * 
   * @return the winningTotal
   */
  public int getWinningTotal() {
    return winningTotal;
  }


  /**
   * Sets the winningTotal.
   * 
   * @param winningTotal the winningTotal to set
   */
  public void setWinningTotal(int winningTotal) {
    this.winningTotal = winningTotal;
  }


  /**
   * Starts a game of two dice pig.
   */
  public void playGame() {
    p1.setScore(0);
    p2.setScore(0);
    turnScore = 0;
    int choice = (int) (Math.random() * 2 + 1);
    if (choice % 2 == 0) {
      currentPlayer = p2;
      p2.setHighlight(true);
      p1.setHighlight(false);
    } else {
      currentPlayer = p1;
      p2.setHighlight(false);
      p1.setHighlight(true);
    }
    dice.roll();
    doRules();
    turnLabel.setText(getTurnText());
  }


  /**
   * Applies the rules of two dice pig to a roll.
   */
  private void doRules() {
    // The Two Dice Pig Game logic
    int die1 = dice.getDie1();
    int die2 = dice.getDie2();
    if (die1 == 1 && die2 == 1) {
      currentPlayer.setScore(0);
      turnScore = 0;
      swapPlayers();
      // Label for when you roll 2 1's
      turnLabel.setText(currentPlayer.getName() 
          + " rolled a 1 and a 1: they lose there score and skip there turn.");
    } else if (die1 == 1 || die2 == 1) {
      turnScore = 0;
      swapPlayers();
      // Label for when you roll a 1
      turnLabel.setText(currentPlayer.getName() 
          + " rolled a 1, they lose their current round score.");
    } else if (die1 == die2) {
      turnScore += 2 * die1;
      dice.roll();
      doRules();
      // Label for when you roll doubles
      turnLabel.setText(currentPlayer.getName() 
          + " rolled doubles: they automatically rolled again.");
    } else {
      turnScore += die1;
      turnScore += die2;
      roll.setEnabled(true);
      hold.setEnabled(true);
      turnLabel.setText(getTurnText());
    }
  }


  /**
   * Swaps the currentPlayer.
   */
  private void swapPlayers() {
    if (currentPlayer.equals(p1)) {
      currentPlayer = p2;
      p2.setHighlight(true);
      p1.setHighlight(false);
    } else {
      currentPlayer = p1;
      p2.setHighlight(false);
      p1.setHighlight(true);
    }
    turnLabel.setText(getTurnText());
  }


  /**
   * Returns the turn information text.
   * 
   * @return The turn information text.
   */
  private String getTurnText() {
    return currentPlayer.getName() + " your turn score is " + turnScore;
  }

  /**
   * Starts the two dice pig game.
   * 
   * @param args not used.
   */
  public static void main(String[] args) {
    // Create window where user can change all values (https://stackoverflow.com/questions/23252229/jframe-position-three-buttons-one-below-another-in-the-center/23252298) 

    JFrame window = new JFrame("Two Dice Pig Game");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    TwoDicePigPanel game = new TwoDicePigPanel();
    game.playGame();
    window.setContentPane(game);
    window.pack();
    window.setVisible(true); 
  }
}
