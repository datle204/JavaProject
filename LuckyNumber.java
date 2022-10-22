import java.util.*; 
// import java.util.Scanner;
// import java.util.List;
// import java.util.ArrayList;

public class LuckyNumber {

    // check if user play or not
    static boolean game = true;

    // New total guess per game
    static int newTotalGuess = 0;

    // Total games
    static int totalGame = 1;

    // Total guesses
    static int totalGuess = 0;

    // Create list of guesses
    static List<Integer> bestResult = new ArrayList<Integer>();
    public static void main(String[] args) {
        

        // Create Random Number
        while(game == true){
            // random lucky number
            int luckyNumber = (int) (Math.random() * 101);
            System.out.println("I'm thinking of a number between 0 and 100...");
            guessLuckyNumber(totalGame, luckyNumber);
        }
    }
    public static void guessLuckyNumber(int totalGame, int luckyNumber) {
        // System.out.println("newTotalGuess: "+ newTotalGuess);
        // User input
        Scanner console = new Scanner(System.in);
      
            System.out.print("Your Guess? ");
            int guessNumber = console.nextInt();
            // Check user number
            if (guessNumber < luckyNumber) {
                System.out.println("It's higher.");
                // Increase total guesses
                newTotalGuess += 1;
                
                // Reset function guessNumber
                guessLuckyNumber(totalGame,luckyNumber);
            } else if (guessNumber > luckyNumber) {
                System.out.println("It's lower.");
                // Increase total guesses
                newTotalGuess += 1;
                
                // Reset function guessNumber
                guessLuckyNumber(totalGame,luckyNumber);
            } else {
                // Increase total guesses
                newTotalGuess += 1;
                // Count totalGuess per game;
                totalGuess += newTotalGuess;
                bestResult.add(newTotalGuess);
                System.out.println("You got it right in " + newTotalGuess + " guesses!");
                // Reset newTotalGuess
                newTotalGuess = 0;
                restartGame(totalGuess, totalGame, newTotalGuess, luckyNumber);
                    
            }
    }
    
    public static void restartGame(int totalGuess, int totalGame, int newTotalGuess, int luckyNumber){
        // System.out.println("totalGuess: " + totalGuess);
        // System.out.println("totalGame: " + totalGame);
        
        Scanner console = new Scanner(System.in);
        
        System.out.print("Do you want to play again? ");
        String userInput = console.nextLine();
        // Check user input
        if (userInput.equals("Y") || userInput.equals("y") || userInput.equals("yes") || userInput.equals("YES")
                || userInput.equals("Yes")) {
            // Increase totalGame
            totalGame += 1;
            // Set game is true
            game = true;
            luckyNumber = (int) (Math.random() * 101);
            System.out.println("I'm thinking of a number between 0 and 100...");
            guessLuckyNumber(totalGame,luckyNumber);

        }else if(userInput.equals("N") || userInput.equals("n") || userInput.equals("no") || userInput.equals("No")
                || userInput.equals("No")){
            // Set game is false, ended while loop
            game = false;
            System.out.println();
            printResult(totalGuess, totalGame);
        }
    }

    public static void printResult(int totalGuess, int totalGame) {
        // change int to float;
        Float avgGuess = (Float.valueOf(totalGuess)/totalGame);
        // Sort list best result
        Collections.sort(bestResult);  
        
        System.out.println("Overall results:");
        System.out.println("Total games = "+ totalGame);
        System.out.println("Total guesses = "+ totalGuess);
        System.out.println("Guesses/game = "+ avgGuess);
        // Get first element of list
        System.out.println("Best game = "+ bestResult.get(0));
    }
}
