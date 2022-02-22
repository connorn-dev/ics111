package edu.ics111.h04; 

/**
 * A program that will read a text file and process the visitor information.
 * @author narowetz
 */
public class VisitorProcessor {

  /**
   * Start of the program reading and processing the data.
   */
  public static void main(String[] args) {
    // Welcome message and keyword to start program
    System.out.println("Welcome, type run to read the file and run the calcualtion");
    String userInput = TextIO.getln();
    
    if (userInput.equals("run")) {
      // Start reading file with TextIO
      TextIO.readFile("visitors.dat");
      System.out.println(".....reading file.....");
      
      // Setup Variables
      int totalVisitors = 0;
      double totalSpending = 0;
      int currentVisitors = 0;
      double currentSpending = 0;
      int noDataCountries = 0;
      double averageSpending = 0; 
      String[] data;
      
      // Setup while loop to go through file
      while (TextIO.eof() == false) {
        // Split up each line of data
        data = TextIO.getln().split(":");
        
        // Check if data line has no values
        if (data.length != 3) {
          noDataCountries++;
        } else { 
          // Assign the data in the line to variables
          // Ran into extra spaces in data, found this solution: https://stacktraceguru.com/java/remove_spaces_from_string
          currentVisitors = Integer.parseInt(data[1].trim());
          currentSpending = Double.parseDouble(data[2].trim());
          
          System.out.println(currentVisitors + " " + currentSpending);
          // Add together variables
          totalVisitors = totalVisitors + currentVisitors; 
          totalSpending = totalSpending + currentSpending;
          
          // Reset temporary variables
          currentVisitors = 0;
          currentSpending = 0;
        }
        
      }
      // Calculate Average Spending (total spending / total visitors) 
      averageSpending = totalSpending / totalVisitors;
      
      // Print the total visitors, average spending, and number of no data values
      System.out.println(".....End of File.....");
      System.out.println("Results: \nTotal Visitors: " + totalVisitors + ", Average Spending: " 
          + averageSpending + ", Number of No-Data-Countries: " + noDataCountries);
    }
  }
}
  

