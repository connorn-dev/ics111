package edu.ics111.h08;

/**
 * Represents a HexAdditionQuestion.
 *
 * @author Cam Moore
 *
 */
public class HexAdditionQuestion {
  private int a1;
  private int b1;

  /**
   * Creates a new HexAdditionQuestion.
   *
   */
  public HexAdditionQuestion() { // constructor
    a1 = (int)(Math.random() * 50 + 1);
    b1 = (int)(Math.random() * 50); 
  }

  /**
   * Returns the question.
   * @return the question.
   */
  public String getQuestion() {
    return "What is " + asHex(a1) + " + " + asHex(b1) + " ?";
  }

  /**
   * Returns the correct answer.
   * @return the correct answer.
   */
  public int getCorrectAnswer() {
    return a1 + b1;
  }

  /**
   * Returns the correct answer as a Hex String.
   * @return the correct answer as a Hex String.
   */
  public String correctAnswerAsHex() {
    return Integer.toHexString(a1 + b1);
  }

  private String asHex(int val) {
    return Integer.toHexString(val);
  }
}