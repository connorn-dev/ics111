package edu.ics111.h06;

/**
 * A program that gives a 10 question hexadecimal quiz to the user and calculates score.
 * @author cnarowetz
 */
public class HexadecimalAdditionQuiz {

  /**
   * Create a 10 question hexadecimal quiz, get input from user, calculate score and return it. 
   */
  public static void main(String[] args) {
    // Create global variables 
    int[] hexOne = new int[10];
    int[] hexTwo = new int[10];
    int[] answer = new int[10];
    int[] userAnswers = new int[10];
    
    createQuiz(hexOne, hexTwo, answer);
    writeQuiz(hexOne, hexTwo, answer, userAnswers);
    gradeQuiz(hexOne, hexTwo, answer, userAnswers);
  }
  
  
  private static void gradeQuiz(int[] hexOne, int[] hexTwo, int[] answer, int[] userAnswers) {
    // Variable for score 
    int score = 0;
    // Reprint all Questions and Answers
    for (int j = 0; j < userAnswers.length ; j++) { 
      String correctOrWrong = "";
      // Compare two arrays together 
      if (userAnswers[j] == answer[j]) {
        correctOrWrong = "Correct";
        score++; 
      } else {
        correctOrWrong = "Wrong";
      }
      System.out.println("!! " + correctOrWrong + " !!   Q" + (j + 1) + ": " 
          + Integer.toHexString(hexOne[j])  
          + " + " + Integer.toHexString(hexTwo[j]) + " = " + Integer.toHexString(answer[j])
          + " | Your answer: " + Integer.toHexString(userAnswers[j]));
    }
    System.out.print("You scored a " + score + "/10");
  }


  private static void writeQuiz(int[] hexOne, int[] hexTwo, int[] answer, int[] userAnswers) {
    // Welcome message to user
    System.out.println("Welcome to Hexadeciaml quiz, you will "
        + "enter the value of two Hexadecimals added together. (Answer in Hexadecimals)");
    
    System.out.println("\nType start, to start the quiz!");
    // if block to start quiz
    String input = TextIO.getlnString();
    if (input.equals("start")) {
      // Variable for input
      String currentInput = ""; 
      // Loop through arrays
      int i = 0; 
      while (true) {
        // Print Questions
        System.out.println("Q" + (i + 1) + ": ");
        // Convert integer to hexadecimal different way (https://stackoverflow.com/questions/12005424/java-converting-int-to-hex-and-back-again)
        System.out.println(Integer.toHexString(hexOne[i]) + " + " + Integer.toHexString(hexTwo[i]));
        // Store answer in array
        currentInput = TextIO.getln();
        userAnswers[i] = Integer.parseInt(currentInput,16);  
        currentInput = "";
        i++; 
        if (i >= hexOne.length) {
          break;
        }
      }

     
      
    } else {
      System.out.print("Sorry, please try again...");
    }
    

  }


  // Create Quiz
  private static void createQuiz(int[] arrOne, int[] arrTwo, int[] arrTotal) {
    // Temporary variables for conversion
    String tempValOne;
    String tempValTwo; 
    // Fill arrayOne & arrayTwo with Values
    for (int i = 0; i < arrOne.length; i++) {
      arrOne[i] = (int) (Math.random() * 50) + 1;
      arrTwo[i] = (int) (Math.random() * 50) + 1;
      // Add array values together for answerArray
      tempValOne = Integer.toHexString(arrOne[i]);
      tempValTwo = Integer.toHexString(arrTwo[i]);
      // Add total for array total
      arrTotal[i] = Integer.parseInt(tempValOne,16) + Integer.parseInt(tempValTwo,16);
    }
    
  }
  
  
  
}