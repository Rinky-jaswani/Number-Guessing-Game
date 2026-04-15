import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("=============================");
        System.out.println("   NUMBER GUESSING GAME   ");
        System.out.println("=============================");

        while (playAgain) {
            
            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            roundsPlayed++;
            System.out.println("\nRound " + roundsPlayed + " — I have picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!\n");

            
            while (attemptsUsed < maxAttempts) {
                int attemptsLeft = maxAttempts - attemptsUsed;
                System.out.print("Attempts left: " + attemptsLeft + " | Your guess: ");

                
                while (!scanner.hasNextInt()) {
                    System.out.print("Please enter a valid number: ");
                    scanner.next(); 
                }
                int userGuess = scanner.nextInt();
                attemptsUsed++;

                
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("  Hint: Please guess between 1 and 100!");
                    attemptsUsed--; 
                    continue;
                }

                
                if (userGuess == secretNumber) {
                    guessedCorrectly = true;
                    int pointsEarned = (maxAttempts - attemptsUsed + 1) * 10;
                    totalScore += pointsEarned;

                    System.out.println("\n  Correct! The number was " + secretNumber + "!");
                    System.out.println("  You guessed it in " + attemptsUsed + " attempt(s).");
                    System.out.println("  Points earned this round: " + pointsEarned);
                    System.out.println("  Total score: " + totalScore);
                    break;

                } else if (userGuess < secretNumber) {
                    
                    int diff = secretNumber - userGuess;
                    if (diff > 30) {
                        System.out.println("  Way too low! Go much higher.");
                    } else if (diff > 10) {
                        System.out.println("  Too low! Go higher.");
                    } else {
                        System.out.println("  Close! A little higher.");
                    }

                } else {
                    
                    int diff = userGuess - secretNumber;
                    if (diff > 30) {
                        System.out.println("  Way too high! Go much lower.");
                    } else if (diff > 10) {
                        System.out.println("  Too high! Go lower.");
                    } else {
                        System.out.println("  Close! A little lower.");
                    }
                }
            }

            
            if (!guessedCorrectly) {
                System.out.println("\n  Out of attempts! The number was: " + secretNumber);
                System.out.println("  Total score: " + totalScore);
            }

            
            System.out.print("\nPlay again? (yes / no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        
        System.out.println("\n=============================");
        System.out.println("   GAME OVER — Thanks for playing!");
        System.out.println("   Rounds played : " + roundsPlayed);
        System.out.println("   Final score   : " + totalScore);
        System.out.println("=============================");

        scanner.close();
    }
}
