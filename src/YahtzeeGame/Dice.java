package YahtzeeGame;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author noahelrimawi-fine
 */
public class Dice {
    private int sides;
    private int numDice;
    private int value;

    private Die[] rolls; // array to hold the values of each die

    public Dice() {
        this.numDice = 2;
        this.sides = 6;
        this.rolls = null;
    }

    /**
     * Constructor for objects of class Dice
     * @param sides the number of sides on the dice
     * @param numDice the value of the dice
     */

    public Dice(int numDice, int sides) {
        this.sides = sides;
        this.numDice = numDice;
        // create an array to hold all the dice
        this.rolls = new Die[numDice];

        // initialize the array of dice and loop through them
        for (int i = 0; i < numDice; i++) {
            rolls[i] = new Die(sides);
        }

    }

    /**
     * Rolls the dice
     * @return the value of the dice
     */
    public int roll() {
        value = 0;
        for (int i = 0; i < numDice; i++) {
            value += rollDie(i);
        }
        return value;
    }

    /**
     * obtains the value of a single ide in the array
     * @param die the index of the die in the array
     * to get the value of the die
     * @return the value of the dice
     */
    public int getDieValue(int die) {
        return rolls[die].getValue();
    }

    /**
     * rolls a single die in the set of dice
     * @param die the index of the die in the array
     * @return the value of the dice that was rolled
     */
    public int rollDie(int die) {
        // roll the die
        return rolls[die].roll();
    }

    /**
     * gets the number of sum of all the dice
     * @return the sum of all the dice
     */
    public int addSumOfDice() {
        int sum = 0;
        for (int i = 0; i < numDice; i++) {
            sum += rolls[i].getValue();
        }
        return sum;
    }

    public HashMap<Integer, Integer> buildFreqTable() {
        // create a hashmap to hold the frequency of each value in the dice
        HashMap<Integer, Integer> diceValues = new HashMap<>();
        // loop through the dice and add the values to the hashmap
        for (int i = 0; i < numDice; i++) {
            // get the value of the die
            int dieValue = rolls[i].getValue();
            // check if the value is in the hashmap
            if (diceValues.containsKey(dieValue)) {
                // if it is, increment the value
                diceValues.put(dieValue, diceValues.get(dieValue) + 1);
            } else {
                // if it is not, add it to the hashmap
                diceValues.put(dieValue, 1);
            }
        }
        return diceValues;
    }



    /**
     * gets the number of the dice
     * @return the number of the dice
     */
    public int getNumDice() {
        return numDice;
    }

    public int getValue() {
        return value;
    }

    public int getSides() {
        return sides;
    }

    public Die[] getRolls() {
        return rolls;
    }
    
    // change for encapsulation purposes?
    public void setValue(int value) {
        this.value = value;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    @Override
    public String toString() {
        return "Dice [sides=" + sides + ", value=" + value + "]";
    }

}

