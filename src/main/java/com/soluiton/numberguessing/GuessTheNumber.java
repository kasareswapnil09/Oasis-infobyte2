package com.soluiton.numberguessing;

import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        int totalScore = 0;
        int rounds = 0;

        while (true) {
            rounds++;
            System.out.println("Round " + rounds);
            int roundScore = playRound();
            totalScore += roundScore;

            //  user if they want to play another round
            int option = JOptionPane.showConfirmDialog(null, "Do you want to play another round?", "Play Again", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Thanks for playing! Your total score is: " + totalScore);
                break;
            }
        }
    }

    public static int playRound() {
        int minRange = 1;
        int maxRange = 100;

        Random random = new Random();
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        int maxAttempts = 5;
        int attempts = 0;

        int score = 0;

        while (attempts < maxAttempts) {
            String guessString = JOptionPane.showInputDialog("Guess the number between " + minRange + " and " + maxRange + ":");

            if (guessString == null) {
                JOptionPane.showMessageDialog(null, "Game aborted. The correct number was: " + randomNumber);
                System.exit(0);
            }

            int guess = Integer.parseInt(guessString);

            if (guess == randomNumber) {
                score += maxAttempts - attempts;
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number. Your score for this round is: " + score);
                break;
            } else {
                if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Try a higher number. Attempts left: " + (maxAttempts - attempts - 1));
                } else {
                    JOptionPane.showMessageDialog(null, "Try a lower number. Attempts left: " + (maxAttempts - attempts - 1));
                }
            }

            attempts++;
        }

        if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "Sorry, you couldn't guess the number. The correct number was: " + randomNumber);
        }

        return score;
    }
}
