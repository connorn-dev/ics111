package edu.ics111.h07;

/**
 * A program that simulates the game "pig dice".
 * @author narowetz
 */
public class TwoDicePigGame {

  /**
   * The game "pig dice", using two dice. 
   */
  public static void main(String[] args) {
    // Setup the game, runs the game after...
    setupGame();
  }

  private static void setupGame() {
    // Welcome message & get number of players playing
    System.out.println("Welcome to pig dice, enter the number of players playing as an integer.");
    int numOfPlayers = TextIO.getInt();
    TextIO.getln();
    
    // Make sure at there are at lease 2 players
    if (numOfPlayers >= 2) {
      // Create an array with number of player objects
      Player[] players = new Player[numOfPlayers];
      
      // For every player ask for their name and set into array 
      // (https://stackoverflow.com/questions/47281629/input-and-store-names-in-array-java)
      for (int i = 0; i < players.length; i++) {
        // Create objects in array
        System.out.print("Enter name of Player" + " " + (i + 1) + " > ");
        players[i] = new Player(TextIO.getln(), 0);
      }
      
      // Start the game
      startGame(players);
      
    } else {
      System.out.println("Please try again, there need to be at least 2 players");
    }
  }


  private static void startGame(Player[] players) {
    // Print game rules
    System.out.println("\nFor the game enter 'r' to roll and"
        + " 'h' to hold, first to 100 points wins");
    
    // Create loop for highest score, as this is how we know when the game is over 
    int highestScore = 0;
    String winnerName = "";
    while (highestScore < 99) {
      for (int i = 0; i < players.length; i++) {
        // Call player turn function and set the score
        players[i].setScore(players[i].getScore() + playerTurn(players[i]));
        System.out.println(players[i].getName() + "'s new score is: " + players[i].getScore());
        System.out.println("____________________________");
        // For loop to set the maximum value
        for (int j = 0; j < players.length; j++) {
          if (players[j].getScore() > highestScore) {
            highestScore = players[j].getScore();
            winnerName = players[j].getName();            
          }
        }
        // Break loop and end game if score 100
        if (highestScore >= 100) {
          break;
        }
      }
    }
    // End of game print out 
    System.out.println("\n$$$$$$$$$$\n" + winnerName 
        + " has won the game with " + highestScore + " points!\n$$$$$$$$$$");

  }

  private static int playerTurn(Player currentplayer) {
    // Create dice object and turn total
    int turnTotal = 0;
    boolean loopState = true;
    PairOfDice dice = new PairOfDice();
    // Print current player
    System.out.println("Currently " + currentplayer.getName() + "'s turn, with " 
        + currentplayer.getScore() + " points: ");
    
    // Get user input
    String input = TextIO.getlnString();
    
    // Loop for rolling and holding
    while (loopState) {
    
      // If r roll dice, if h skip to next player
      if (input.equals("r")) {
        input = "";
        // Roll dice
        dice.roll();
        System.out.print("You rolled a " + dice.die1 + " and a " + dice.die2 + "   >>>   ");
        turnTotal = turnTotal + dice.die1 + dice.die2;
      
        // If 1 is rolled skip turn, if 1 and 1 are rolled clear score, skip turn.
        if (dice.die1 == 1  && dice.die2 == 1) {
          System.out.println("Sorry you rolled a 1 & 1, score is reset");
          currentplayer.setScore(0);
          turnTotal = 0;
          loopState = false;
        } else if (dice.die1 == 1 || dice.die2 == 1) {
          System.out.println("Sorry you rolled a 1, turn is over");
          turnTotal = 0;
          loopState = false;
        
        // Check for doubles and roll again.
        } else if (dice.die1 == dice.die2) {
          System.out.println("You rolled a double, by rules you have automatically rolled again");
          input = "r";
          System.out.println("Turn total is now: " + turnTotal);
        // Check for every other normal condition.
        } else {
          System.out.println("Turn total is now: " + turnTotal);
          input = TextIO.getlnString();
          if (input.equals("h")) {
            loopState = false;
          }
        }
      
      } else if (input.equals("h")) {
        loopState = false; 
      } else {
        System.out.println("Error with input entered restart program");
      }
    
    }
    System.out.println("!!!Turn over, you scored " + turnTotal + " that round!!!");
    // Return score for the round
    return turnTotal;
    
  }
  
  
  
}