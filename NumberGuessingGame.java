import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secretNumber;
        int range = 100;
        int maxAttempts = 5;
        int score = 0;
        int totalAttempts = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number Game!");

        while (playAgain) {
            secretNumber = random.nextInt(range) + 1;
            System.out.println("I'm thinking of a number between 1 and " + range + ". Can you guess it?");

            int attempts = 0;
            int guess = 0;

            while (guess != secretNumber && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number.");
                    int points = maxAttempts - attempts + 1;
                    score += points;
                    System.out.println("You earned " + points + " points.");
                }
            }

            if (attempts == maxAttempts && guess != secretNumber) {
                System.out.println("Sorry, you've reached the maximum number of attempts.");
                System.out.println("The secret number was: " + secretNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            if (playAgainInput.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }

        System.out.println("Game over! Your total score is " + score + " with " + totalAttempts + " attempts.");
        System.out.println("Thank you for playing!");
    }
}
