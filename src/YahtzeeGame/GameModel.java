package YahtzeeGame;

import java.util.HashMap;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author noahelrimawi-fine
 */
public class GameModel {

    /**
     * @return the bonus
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * @return the sumUpperScores
     */
    public int getSumUpperScores() {
        return sumUpperScores;
    }

    /**
     * @return the sumLowerScores
     */
    public int getSumLowerScores() {
        return sumLowerScores;
    }

    /**
     * @return the grandTotal
     */
    public int getGrandTotal() {
        return grandTotal;
    }

    // final variable declaration
    public static final int BONUS = 35;
    public final static int NUM_UPPER_SCORE_CATS = 6;
    public final static int NUM_LOWER_SCORE_CATS = 7;
    public static final int MAX_NUM_TURNS = NUM_UPPER_SCORE_CATS + NUM_LOWER_SCORE_CATS;

    // variable declaration
    private int[] upperScoreCategories;
    private int[] lowerScoreCategories;
    private boolean[] usedUpperScoreCategories;
    private boolean[] usedLowerScoreCategories;
    private int currentTurnNum;
    private int bonus;
    private int sumUpperScores;
    private int sumLowerScores;
    private int grandTotal;


    /**
     * Creates the constructor for the GameModel
     */
    public GameModel() {
        upperScoreCategories = new int[NUM_UPPER_SCORE_CATS + 1];
        lowerScoreCategories = new int[NUM_LOWER_SCORE_CATS];

        usedUpperScoreCategories = new boolean[NUM_UPPER_SCORE_CATS + 1];
        usedLowerScoreCategories = new boolean[NUM_LOWER_SCORE_CATS];

        currentTurnNum = 1;
    }

    public void clearAllUpperScoringCats() {
        for(int i = 1; i <= NUM_UPPER_SCORE_CATS; i++) {
            upperScoreCategories[i] = 0;
        }
    }

    public void clearAllLowerScoringCats() {
        for(int i = 0; i < NUM_LOWER_SCORE_CATS; i++) {
            lowerScoreCategories[i] = 0;
        }
    }

    public void clearUsedScoringCats() {
        for(int i = 1; i <= NUM_UPPER_SCORE_CATS; i++) {
            usedUpperScoreCategories[i] = false;
        }

        for(int i = 0; i < NUM_LOWER_SCORE_CATS; i++) {
            usedLowerScoreCategories[i] = false;
        }
    }

    public boolean isOfAKind(Dice myDice, int kind) {
        HashMap<Integer, Integer> diceValues = myDice.buildFreqTable();

        return diceValues.containsValue(kind);
    }

    public boolean isFullHouse(Dice myDice) {
        HashMap<Integer, Integer> diceValues = myDice.buildFreqTable();

        return (diceValues.containsValue(2) && diceValues.containsValue(3));
    }

    public boolean isSmallStraight(Dice myDice) {
        HashMap<Integer, Integer> diceValues = myDice.buildFreqTable();
        if (diceValues.containsKey(3) && diceValues.containsKey(4)) {
            // check if the dice values contain a 1 and a 2
            if (diceValues.containsKey(1) && diceValues.containsKey(2)) {
                return true;
            }
            // check if the dice values contain a 2 and a 5
            else if (diceValues.containsKey(2) && diceValues.containsKey(5)) {
                return true;
            }
            // check if the dice values contain a 5 and a 6
            else if (diceValues.containsKey(5) && diceValues.containsKey(6)) {
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public boolean isLargeStraight(Dice myDice){
        HashMap<Integer, Integer> diceValues = myDice.buildFreqTable();
        return diceValues.containsKey(2) && diceValues.get(2) == 1 &&
                diceValues.containsKey(3) && diceValues.get(3) == 1 &&
                diceValues.containsKey(4) && diceValues.get(4) == 1 &&
                diceValues.containsKey(5) && diceValues.get(5) == 1;
    }

    // TODO: implement this method

    public static BigDecimal BinomialDistributionProbOfYahtzee(int numYahtzees, int numRolls) {
        if (numYahtzees < 0 || numYahtzees > 13 || numRolls < 1 || numRolls > 13) {
            throw new IllegalArgumentException("Invalid input");
        }

        // The probability of rolling a Yahtzee on any given roll is 6/6^5 = 6/7776 or 1/1296
        BigDecimal p = new BigDecimal("6.0").divide(new BigDecimal("7776"), MathContext.DECIMAL128);

        // The probability of not rolling a Yahtzee on any given roll is 1 - p
        BigDecimal q = BigDecimal.ONE.subtract(p, MathContext.DECIMAL128);

        // Use the binomial distribution formula to calculate the probability of rolling the
        // given number of Yahtzees:
        //   probability = (numRolls choose numYahtzees) * p^numYahtzees * q^(numRolls-numYahtzees)
        BigDecimal numerator = factorial(numRolls).multiply(p.pow(numYahtzees)).multiply(q.pow(numRolls - numYahtzees));
        BigDecimal denominator = factorial(numYahtzees).multiply(factorial(numRolls - numYahtzees));
        return numerator.divide(denominator, MathContext.DECIMAL128);
    }

    // Calculates the factorial of a given number.
    private static BigDecimal factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (n == 0 || n == 1) {
            return BigDecimal.ONE;
        }
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(new BigDecimal(i));
        }
        return result;
    }






    public void setLowerScoreCat(int index, int score) {
        lowerScoreCategories[index] = score;
    }

    public void setUpperScoreCat(int index, int score) {
        upperScoreCategories[index] = score;
    }

    public void setUsedLowerScoreCat(int index, boolean used) {
        usedLowerScoreCategories[index] = used;
    }

    public void setUsedUpperScoreCat(int index, boolean used) {
        usedUpperScoreCategories[index] = used;
    }

    public int addDice(Dice myDice) {
        int sum = 0;

        for(int i = 0; i < myDice.getNumDice(); i++) {
            sum+= myDice.getDieValue(i);
        }
        return sum;
    }

    // write a method to calculate some probabilities
    public double calculateProbabilities(Dice myDice) {
        // use the hashmap to find the highest frequency of a die value
        HashMap<Integer, Integer> diceValues = myDice.buildFreqTable();
        int highestFrequency = 0;
        int frequencyNumber = 0;
        for (int i = 1; i <= 6; i++) {
            if (diceValues.containsKey(i)) {
                if (diceValues.get(i) > highestFrequency) {
                    highestFrequency = diceValues.get(i);
                    // assign the frequency number to the key of the highest frequency
                    frequencyNumber = i;
                }
            }
        }
        double probabilityOfYahtzee = 0.0;

        // given x dice that are the same value, what is the probability of getting a yahtzee
        // if 4 dice are the same value, the probability of getting a yahtzee is 1/6
        if (highestFrequency == 4) {
            probabilityOfYahtzee = 1.0/6.0;
        }
        // if 5 dice are the same value, the probability of getting a yahtzee is 1
        else if (highestFrequency == 5) {
            probabilityOfYahtzee = 1.0;
        }
        // if 3 dice are the same value, the probability of getting a yahtzee is 1/6
        else if (highestFrequency == 3) {
            probabilityOfYahtzee = 1.0/36.0;
            // if the other two dice are the same value, and the value of the first 3 is less than 5 keep full house
            // check the frequency number is less than 5
            if (frequencyNumber < 5 && isFullHouse(myDice)) {
                // this is not true but it will work for the purposes of my game
                probabilityOfYahtzee = 1;
            }

        }
        // if 2 dice are the same value, the probability of getting a yahtzee is 1/6
        else if (highestFrequency == 2) {
            probabilityOfYahtzee = 1.0/216.0;
        }
        // if 1 dice is the same value, the probability of getting a yahtzee is 1/6
        else if (highestFrequency == 1) {
            probabilityOfYahtzee = 1.0/1296.0;
        }
        return probabilityOfYahtzee;
    }

    public void methodRecommendation(Dice myDice) {
        // create a method to recommend whether to go for yahtzee or not
        // if the probability of getting a yahtzee is greater than 1/6, go for it
        // if the probability of getting a yahtzee is less than 1/6, don't go for it
        if(calculateProbabilities(myDice) >= 1.0/6.0) {
            System.out.println("Go for yahtzee");
        }

    }

    public boolean getUsedUpperScoringCatState(int i) {
        return usedUpperScoreCategories[i];
    }

    public boolean getUsedLowerScoringCatState(int i) {
        return usedLowerScoreCategories[i];
    }

    /**
     * @return the currentTurnNum
     */
    public int getCurrentTurnNum() {
        return currentTurnNum;
    }

    public void nextTurn() {
        currentTurnNum++;
    }

    public void resetTurn() {
        currentTurnNum = 1;
    }

    public void updateTotals() {
        bonus = 0;
        sumUpperScores = 0;
        sumLowerScores = 0;
        grandTotal = 0;

        for(int i = 1; i <= NUM_UPPER_SCORE_CATS; i++) {
            sumUpperScores += upperScoreCategories[i];
        }

        if(sumUpperScores >= 63) {
            bonus = 35;
        }
        sumUpperScores += bonus;

        for(int i = 0; i < NUM_LOWER_SCORE_CATS; i++) {
            sumLowerScores += lowerScoreCategories[i];
        }

        grandTotal = sumUpperScores + sumLowerScores;
    }

    public String chooseDiceToHold(Dice myDice) {
        // create the diceValues hashMap
        HashMap<Integer, Integer> diceValues = myDice.buildFreqTable();

        // in the case of a Yahtzee, hold all dice
        if (isOfAKind(myDice, 5)) {
            return "Keep all dice";
        }
        // in the case of a large straight, hold all dice
        else if (isLargeStraight(myDice)) {
            return "Keep large straight";
        }
        // in the case of a small straight, hold all dice
        else if (isSmallStraight(myDice)) {
            return "Keep small straight";
        }
        // in the case of a full house, hold the dice if the dice values are 1, 2, 3 and 4
        else if (isFullHouse(myDice)) {
            // check if the dice values contains 3 of the 1,2,3, or 4
            if (diceValues.containsKey(1) && diceValues.get(1) == 3) {
                return "Keep full house";
            } else if (diceValues.containsKey(2) && diceValues.get(2) == 3) {
                return "Keep full house";
            } else if (diceValues.containsKey(3) && diceValues.get(3) == 3) {
                return "Keep full house";
            } else if (diceValues.containsKey(4) && diceValues.get(4) == 3) {
                return "Keep full house";
            } else {
                return "keep the three dice with the highest value and roll the other two";
            }
        }
        else if(isOfAKind(myDice, 4)) {
            return "hold the four of the same and roll the other one";
        }
        else if(isOfAKind(myDice, 3)) {
            int TotalDiceValue = myDice.addSumOfDice();

            if(diceValues.containsKey(1) && diceValues.get(1) == 3) {
                return "If aces haven't been filled, hold the three aces and roll the other two";
            }
            if(diceValues.containsKey(2) && diceValues.get(2) == 3) {
                return "If twos haven't been filled, hold the three twos and roll the other two";
            }
            if(diceValues.containsKey(3) && diceValues.get(3) == 3) {
                return "If threes haven't been filled, hold the three threes and roll the other two";
            }
            return "hold the three of the same and roll the other two";
        }
        else if(isOfAKind(myDice, 2)) {
            return "hold the two of the same and roll the other three";
        }
        // if the dice contains one value away from a small or large straight tell to hold
        else if(diceValues.containsKey(2) && diceValues.containsKey(3)
            && diceValues.containsKey(4)) {
            return "hold the dice with the values 2, 3 and 4 and roll the other two";
        }
        else {
            return "this one is on you";
        }
    }

    // write a main method to test the code
    public static void main(String[] args) {
        // use binomialProbabilityOfYahtzee to calculate the probability of getting a Yahtzee
        // using the binomial distribution
        BigDecimal probability = BinomialDistributionProbOfYahtzee(1, 10);
        System.out.println("Probability of getting a Yahtzee: " + probability);
    }



}

