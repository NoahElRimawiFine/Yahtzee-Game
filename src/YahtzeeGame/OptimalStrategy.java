package YahtzeeGame;

import java.util.HashMap;

public class OptimalStrategy {

    private GameModel game;


    // the basic solution that has been used will consist of four parts
    // if there is one or two dice rolls left, calculate how many dice has to be rerolled to get each combination

    // write a method that will calculate the shortest distance to achieving every one of the remaining categories
    // given the current dice rolls

    public static final int NUM_SIDES = 5;
    public void calculateShortestDistance(Dice myDice, int rollsLeft) {
        // get the current dice rolls using a hashmap
        HashMap<Integer, Integer> diceValues = myDice.buildFreqTable();
        // if there is one roll left, calculate the shortest distance to achieving each category

        if (rollsLeft == 2 && diceValues.containsValue(2)) {
            // calculate the shortest distance to achieving a 3 of a kind



        }
    }

    // write a method to calculate binomial coefficient
    public int binomialCoefficient(int n, int k) {
        // if k is 0, return 1
        if (k == 0) {
            return 1;
        }
        // if k is equal to n, return 1
        if (k == n) {
            return 1;
        }
        // if k is greater than n, return 0
        if (k > n) {
            return 0;
        }
        // return the binomial coefficient
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }

    // write a method to create a transition matrix with the probabilities of rolling each value
    public double[][] createTransitionMatrix() {
        // create a transition matrix
        double[][] transitionMatrix = new double[NUM_SIDES][NUM_SIDES];
        // fill the transition matrix with the probabilities of rolling each value
        // if we have 5 dice all with the same number the probability of keeping yahtzee is 1
        transitionMatrix[4][4] = 1;
        // if we have 4 dice all with the same number the probability of yahtzee is 1/6
        transitionMatrix[3][4] = 1.0 / 6;
        transitionMatrix[3][3] = 5.0 / 6;
        // if we have 3 dice all with the same number the probability of yahtzee is (1/6)(1/6)
        transitionMatrix[2][4] = 1.0 / 36;
        transitionMatrix[2][3] = 10.0 / 36;
        transitionMatrix[2][2] = 25.0 / 36;
        // if we have 2 dice all with the same number the probability of yahtzee is (1/6)(1/6)(1/6)
        transitionMatrix[1][4] = 1.0 / 216; // 1/6^3
        transitionMatrix[1][3] = 15.0 / 216;
        transitionMatrix[1][2] = 80.0 / 216;
        transitionMatrix[1][1] = 120.0 / 216;
        // if we have 1 dice all with the same number the probability of yahtzee is (1/6)(1/6)(1/6)(1/6)
        transitionMatrix[0][4] = 1.0 / 1296;
        transitionMatrix[0][3] = 25.0 / 1296;
        transitionMatrix[0][2] = 250.0 / 1296;
        transitionMatrix[0][1] = 900.0 / 1296;
        transitionMatrix[0][0] = 120.0 / 1296;

        return transitionMatrix;
    }

    public String chooseDiceToHold(Dice myDice) {
        // create the diceValues hashMap
        HashMap<Integer, Integer> diceValues = myDice.buildFreqTable();

        // in the case of a Yahtzee, hold all dice
        if (game.isOfAKind(myDice, 5)) {
            return "Keep all dice";
        }
        // in the case of a large straight, hold all dice
        else if (game.isLargeStraight(myDice)) {
            return "Keep large straight";
        }
        // in the case of a small straight, hold all dice
        else if (game.isSmallStraight(myDice)) {
            return "Keep small straight";
        }
        // in the case of a full house, hold the dice if the dice values are 1, 2, 3 and 4
        else if (game.isFullHouse(myDice)) {
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
        else if(game.isOfAKind(myDice, 4)) {
            return "hold the four of the same and roll the other one";
        }
        else if(game.isOfAKind(myDice, 3)) {
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
        else if(game.isOfAKind(myDice, 2)) {
            return "hold the two of the same and roll the other three";
        }
        else {
            return "roll all dice";
        }
    }



    // write a method to calculate the probability of rolling a certain value
    // given the current dice rolls

    // write a method to print out the transition matrix
    public void printMatrix(double[][] matrix) {
        // print out the createTransitionMatrix
        // loop through the rows
        for (int i = 0; i < matrix.length; i++) {
            // loop through the columns
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    // before each throw calculate the percentage of getting each category combination in the following one or two throws
    // combining the percentage calculation with the value one can get if scoring that combination
    // when the last throw has been made, put the obtained value in the category that gives the highest score


    // write a method to calculate the probability of rolling a certain value
    // TODO: these methods are a work in progress
    public double calculateYahtzeeProbability(Dice myDice) {
        HashMap<Integer, Integer> diceValues = myDice.buildFreqTable();
        int numDice = myDice.getNumDice();
        int numDiceWithSameValue = 0;
        int numDiceWithDifferentValue = 0;
        double probability = 0.0;
        double probabilityOfSameValue = 0.0;
        double probabilityOfDifferentValue = 0.0;
        double probabilityOfYahtzee = 0.0;

        // calculate the probability of getting a Yahtzee
        for (int i = 1; i <= 6; i++) {
            if (diceValues.containsKey(i)) {
                numDiceWithSameValue = diceValues.get(i);
                numDiceWithDifferentValue = numDice - numDiceWithSameValue;
                probabilityOfSameValue = (double) numDiceWithSameValue / numDice;
                probabilityOfDifferentValue = (double) numDiceWithDifferentValue / numDice;
                probability = probabilityOfSameValue * probabilityOfDifferentValue;
                probabilityOfYahtzee += probability;
            }
        }
        return probabilityOfYahtzee;
    }


    public static void main(String[] args) {
        // use binomial coefficient to calculate the number of combinations
        // use the number of combinations to calculate the probability of getting each combination
        OptimalStrategy optimalStrategy = new OptimalStrategy();
        System.out.println(optimalStrategy.binomialCoefficient(7, 3));
        // create a transition matrix
        double[][] transitionMatrix = optimalStrategy.createTransitionMatrix();
        // print out the transition matrix
        optimalStrategy.printMatrix(transitionMatrix);

    }

}
