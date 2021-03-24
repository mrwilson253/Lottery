import javax.swing.*;

/**********************
 * Jordan Wilson
 * jwilson160@cnm.edu
 * WilsonP1
 * Program 1 - Lottery
 **********************/

public class Lottery {

    public static void main(String[] args) {

        //Display header
        JOptionPane.showMessageDialog(null, "Jordan Wilson\nWilsonP1 Lottery",
                "CIS 2235", JOptionPane.INFORMATION_MESSAGE);
        //variables for tracking stats and keeping do/while
        int input;
        int winnings=0;
        int rounds=0;

        do {
            //user guess in string and integer
            String sGuess;
            int guess;

            /*
            *Generate lottery number
            *repeat digits are possible with this, player is rewarded for
            *matching one of their numbers to a repeat number.
            */
            int lottery = 100 + (int) (Math.random() * (1000-100));
            //test lottery number
            //int lottery = 147;

            //Ask for guess
            sGuess = JOptionPane.showInputDialog(null, "Enter your lottery pick (three digits): ", "Guess", JOptionPane.PLAIN_MESSAGE);
            guess = Integer.parseInt(sGuess);

            //Get digits from lottery number
            int lotteryDigitOne = lottery / 100;
            int lotteryDigitTwo = (lottery / 10) % 10;
            int lotteryDigitThree = lottery % 10;

            //adding lottery digits to array for comparison/reward
            int[] lotteryArray = new int[]{lotteryDigitOne, lotteryDigitTwo, lotteryDigitThree};

            //Get digits from guess number
            int guessDigitOne = guess / 100;
            int guessDigitTwo = (guess / 10) % 10;
            int guessDigitThree = guess % 10;

            //adding guess digits to array for comparison/reward
            int[] guessArray = new int[]{guessDigitOne, guessDigitTwo, guessDigitThree};

            //Display lottery number
            JOptionPane.showMessageDialog(null, "The lottery number is " + lottery, "Lottery number", JOptionPane.INFORMATION_MESSAGE);

            //Check the guess

            //variables to track matching numbers
            int match = 0;
            int exact = 0;

            /*
            outter loop holds a lottery digit that is compared to each guess digit on the innner loop
            once all guess digits have been compared, the outter loop moves to the next lottery digit
            and repeats comparison. This method does award the player for matching one of their guess digits
            to to a recurring lottery digit for a maximum award of 3,000.
             */
            for (int i = 0; i < 3; ++i) {
                int lotTemp = lotteryArray[i];
                for (int j = 0; j < 3; ++j) {
                    int guessTemp = guessArray[j];
                    if (lotTemp == guessTemp) {
                        if (i == j) {
                            exact++;
                            match++;
                        } else {
                            match++;
                        }
                    }
                }
            }

            //calculating winnings based on matching digits
            if (exact == 3) {
                JOptionPane.showMessageDialog(null, "Exact match! You win $10,000.", "Results", JOptionPane.ERROR_MESSAGE);
                winnings+=10000;
            } else if (match == 3 && exact != 3) {
                JOptionPane.showMessageDialog(null, "Match all digits! You win $3,000.", "Results", JOptionPane.PLAIN_MESSAGE);
                winnings+=3000;
            } else if (match == 1 || match == 2) {
                JOptionPane.showMessageDialog(null, "Match one digit! You win $1,000.", "Results", JOptionPane.PLAIN_MESSAGE);
                winnings+=1000;
            } else {
                JOptionPane.showMessageDialog(null, "Sorry! No match.", "Results", JOptionPane.PLAIN_MESSAGE);
            }

            //incrementing rounds
            rounds++;

            //checking for play again
            input = JOptionPane.showConfirmDialog(null, "Play again?");
        }while(input == 0);

        //end of game stats
        String sStats = "Rounds played: " + rounds + "\n" + "Winnings: $" + winnings;
        JOptionPane.showMessageDialog(null, sStats, "Good-Bye", JOptionPane.INFORMATION_MESSAGE);
    }
}
