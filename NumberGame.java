import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Generate a number between 1 and 100
            int maxAttempts = 10;
            int attempts = 0;
            boolean numberGuessed = false;

            System.out.println("I have generated a number between 1 and 100. Try to guess it!");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    numberGuessed = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!numberGuessed) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.println("Your current score is: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
