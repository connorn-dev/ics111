package edu.ics111.h08;

/**
 * A program that gives a 10 question hexadecimal quiz to the user and calculates score,
 *  but uses pre built class. 
 * @author narowetz
 */
public class HexadecimalAdditionQuiz {

  /**
   * Create a 10 question hexadecimal quiz, get input from user, calculate score and return it. 
   */
  public static void main(String[] args) {
  
    // Create array of HexQuestion objects and user answers
    HexAdditionQuestion[] answers = new HexAdditionQuestion[10];
    int[] userAnswers = new int[10];
  
    // Welcome message
    System.out.println("Welcome to Hexadeciaml quiz, you will "
        + "enter the value of two Hexadecimals added together. (Answer in Hexadecimals)"
        + "\n\nType 'start' to begin the quiz.");
    
    // Create the quiz
    createQuiz(answers);
    
    // Start quiz after user input
    if (TextIO.getlnString().equals("start")) {
      startQuiz(answers, userAnswers);
    } else {
      System.out.println("Please try again and use keyword 'start'.");
    }
  
  }

  private static void gradeQuiz(HexAdditionQuestion[] answers, int[] userAnswers) {
    // Score variable
    int score = 0;
    
    // loop through arrays and compare values
    for (int i = 0; i < userAnswers.length; i ++) {
      if (answers[i].correctAnswerAsHex().equals(Integer.toHexString(userAnswers[i]))) {
        System.out.println("!! Correct !! |Correct Answer: " + answers[i].correctAnswerAsHex() 
            + "| Your Answer: " + Integer.toHexString(userAnswers[i]));
        score++;
      } else {
        System.out.println("!! Wrong !! |Correct Answer: " + answers[i].correctAnswerAsHex() 
            + "| |Your Answer: " + Integer.toHexString(userAnswers[i]) + "|");
      }
    }
    System.out.println("\nYou scored a " + score + "/10");
    
  }
  
  private static void startQuiz(HexAdditionQuestion[] answers, int[] userAnswers) {
    // Ask Question and wait for response
    for (int i = 0; i < answers.length; i++) {
      System.out.println("Q" + (i + 1) + ": " + answers[i].getQuestion());
      userAnswers[i] = Integer.parseInt(TextIO.getlnString(),16);
    }
    // End quiz by returning score, correct and wrong answers
    gradeQuiz(answers, userAnswers);
  }

  private static void createQuiz(HexAdditionQuestion[] answers) {
    
    // Loop through array and fill with new arrays
    for (int i = 0; i < answers.length; i++) {
      answers[i] = new HexAdditionQuestion();
    }
    
  }
}