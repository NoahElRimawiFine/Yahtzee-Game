package YahtzeeGame;

import java.util.*;

public class Yahtzee {
    public double threeOfAKind = 216.0/45556.0;
    public double yahtzeeOnFirstRoll = 1.0/1296.0;
    HashSet<Integer> diceSet = new HashSet<Integer>();
    // create an arraylist of the dice
    ArrayList<Integer> finalDice = new ArrayList<Integer>();

    private HashSet<int[]> comparisonCheck = new HashSet<>();
    private int points;



    public static boolean isYahtzee(ArrayList<Integer> dice) {
        // if the arraylist has 5 of the same number, return true
        if (dice.size() == 5) {
            return true;
        }
        return false;
    }

    // write a program to calculate the odds of getting a Yahtzee given a set of dice using binomial distribution
    public static double chanceOfYahtzee(int[] dice) {
        return 0;
    }

    // write a method that takes 5 dice and rolls them
    public static int[] rollDice(int numDice) {
        // roll 5 dice
        int[] dice = new int[numDice];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = (int) (Math.random() * 6 + 1);
        }
        // sort the dice
        Arrays.sort(dice);
        return dice;
    }

    public double goingForYahtzee(int[] dice) {
        // if the dice are already a Yahtzee, then the chance of getting a Yahtzee is 1
        if (isYahtzee(finalDice)) {
            return 1;
        }
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i : dice) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
        // displaying the occurrence of elements in the arraylist
        for (Map.Entry<Integer, Integer> val : hm.entrySet()) {
            System.out.println("Element " + val.getKey() + " "
                    + "occurs"
                    + ": " + val.getValue() + " times");
        }
        // first check if the final dice has any values in it
        if (finalDice.size() == 0) {
            int maxKey = 0;
            int maxValue = 0;
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (value > maxValue) {
                    maxKey = key;
                    maxValue = value;
                }
            }
            // add the max key to the final dice the number of times it occurs
            for (int i = 0; i < maxValue; i++) {
                finalDice.add(maxKey);
            }
            // if the final dice has values in it, then we need to check if the dice we are rolling are in the final dice
        } else {
            // if the dice we are rolling are in the final dice, add them to the final dice
            for (int i = 0; i < dice.length; i++) {
                if (finalDice.contains(dice[i])) {
                    finalDice.add(dice[i]);
                }
            }
        }
        System.out.println("Final Dice: " + finalDice);
        // repeat the process until the final dice has 5 dice in it
        if (finalDice.size() < 5) {
            // roll the dice again but only roll the number of dice that are not in the final dice
            goingForYahtzee(rollDice(5 - finalDice.size()));
        }
        return goingForYahtzee(dice);
    }

    // public arraylist of the dice
    public ArrayList<Integer> getFinalDice() {
        return finalDice;
    }

    public ArrayList<Integer> findFullHouse(int[] dice) {
        // full house is 3 of a kind and a pair
        // if the dice are in a fullHouse, return true

        // check if the dice are in a full house by checking if there are 3 of a kind and a pair in the hashMap
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i : dice) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
        // displaying the occurrence of elements in the arraylist
        for (Map.Entry<Integer, Integer> val : hm.entrySet()) {
            System.out.println("Element " + val.getKey() + " "
                    + "occurs"
                    + ": " + val.getValue() + " times");
        }

        // if the dice are in a full house, return true
        if (hm.containsValue(3) && hm.containsValue(2)) {
            // add the dice to the final dice
            for (int i = 0; i < dice.length; i++) {
                finalDice.add(dice[i]);
            }
            return finalDice;
        }
        // if the dice are not in a full house, then roll the dice again
        // then check if there is a pair
        // if there is a pair, then add the dice to the final dice
        // then roll the dice again

        if(hm.containsValue(2) || hm.containsValue(3)) {
            // how to get the key that contains the value 2 or 3
            for (Map.Entry<Integer, Integer> val : hm.entrySet()) {
                if (hm.get(val.getKey()) == 2 || hm.get(val.getKey()) == 3 && !finalDice.contains(val.getKey())) {
                    // add the dice to the final dice
                    for (int i = 0; i < val.getValue(); i++) {
                        finalDice.add(val.getKey());
                    }
                }
            }
        }

        // check if the final dice has a pair
        if (finalDice.size() == 2) {
            // roll the dice again
            findFullHouse(rollDice(5 - finalDice.size()));

        }
        System.out.println("Final Dice: " + finalDice);
        // now that the dice contains a pair, roll the dice again
        // if the size of the finalDice is 4, then roll until you get one of the two dice that is in the finalDice
        if (finalDice.size() == 4) {
            // roll the dice again but only roll the number of dice that are not in the final dice
            rollDice(1);
            System.out.println("Final Dice: " + finalDice);
            if (finalDice.contains(dice[0])) {
                finalDice.add(dice[0]);
            }
            return finalDice;
        }

        return finalDice;
    }

    // write a method that gets 1, 2, 3, 4, or 5 of a kind and returns the dice
    public ArrayList<Integer> getXOfAKind(int[] dice) {
        // if there is 1, 2, 3, 4, or 5 of a kind, return true
        // iterate through the hashmap and check if there is a pair, 3 of a kind, 4 of a kind, or 5 of a kind
        if (isYahtzee(finalDice)) {
            return finalDice;
        }

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i : dice) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }

        // displaying the occurrence of elements in the arraylist
        for (Map.Entry<Integer, Integer> val : hm.entrySet()) {
            System.out.println("Element " + val.getKey() + " "
                    + "occurs"
                    + ": " + val.getValue() + " times");
        }

        if(hm.containsValue(2) || hm.containsValue(3) || hm.containsValue(4) || hm.containsValue(5) && finalDice.size() == 0) {
            // how to get the key that contains the value 2 or 3
            for (Map.Entry<Integer, Integer> val : hm.entrySet()) {
                if (hm.get(val.getKey()) == 2 || hm.get(val.getKey()) == 3 || hm.get(val.getKey()) == 4 || hm.get(val.getKey()) == 5) {
                    // add the dice to the final dice
                    for (int i = 0; i < val.getValue(); i++) {
                        finalDice.add(val.getKey());
                    }
                }
            }
        }
        System.out.println("Final Dice: " + finalDice);
        if (finalDice.size() > 1) {
            // search for the dice that are the same as the finalDice by rolling the dice again
            // if the dice are the same as the finalDice, add them to the finalDice
            rollDice(5 - finalDice.size());
            for (int i = 0; i < dice.length; i++) {
                if (finalDice.contains(dice[i])) {
                    finalDice.add(dice[i]);
                }
            }
        }
        getXOfAKind(rollDice(5 - finalDice.size()));
        return finalDice;
    }

    // write a program that rolls the dice and then checks certain conditions to see if the dice are in a certain category
    // if the dice are in a certain category, then add the dice to the final dice
    // if the dice are not in a certain category, then roll the dice again
    public void runTheYahtzeeGame() {
        int[] largeStraight = {2, 3, 4, 5, 6};
        int[] largeStraight2 = {1, 2, 3, 4, 5};
        int[] smallStraight = {1, 2, 3, 4};
        int[] smallStraight2 = {2, 3, 4, 5};
        int[] smallStraight3 = {3, 4, 5, 6};
        comparisonCheck.add(largeStraight2);
        comparisonCheck.add(largeStraight);
        comparisonCheck.add(smallStraight);
        comparisonCheck.add(smallStraight2);
        comparisonCheck.add(smallStraight3);

        ArrayList<ArrayList<Integer>> arraysOfDice = new ArrayList<>();

        // roll the dice
        int[] dice = rollDice(5);
        // add to the dice to an arraylist
        ArrayList<Integer> diceList = new ArrayList<Integer>();
        //use addAll() method to add all elements of an array to an ArrayList
        for (int i = 0; i < dice.length; i++) {
            diceList.add(dice[i]);
        }

        if (isYahtzee(diceList)) {
            // iterate through the arraysOfDice and check if there is a Yahtzee in the array
            boolean flag = false;
            for(int i = 0; i < arraysOfDice.size(); i++) {
                if (isYahtzee(arraysOfDice.get(i))) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                points += 100;
            }
            else {
                points += 50;
            }
            arraysOfDice.add(diceList);
            System.out.println("Yahtzee!");
        }

        // if the dice are not in a Yahtzee, then check if the dice are in a large straight
        else if (isLargeStraight(diceList)) {
            if (!comparisonCheck.contains(largeStraight) && !comparisonCheck.contains(largeStraight2)) {
                arraysOfDice.add(diceList);
                points += 40;
                System.out.println("Large Straight!");
            }
        }

        // if the dice are not in a large straight, then check if the dice are in a small straight
        else if (isSmallStraight(diceList)) {
            // check if the arraysOfDice contains already contains a small straight
            if (!comparisonCheck.contains(smallStraight) && !comparisonCheck.contains(smallStraight2) && !comparisonCheck.contains(smallStraight3)) {
                arraysOfDice.add(diceList);
                points += 30;
                System.out.println("Small Straight!");
            }
        }
        // if the dice are not in a small straight, then check if the dice are in a full house
        else if (isFullHouse(diceList)) {
            arraysOfDice.add(diceList);
            System.out.println("Full House!");
        }
        // if the dice are not in a full house, then check if the dice are in a four of a kind
        else if (isFourOfAKind(diceList)) {
            System.out.println("Four of a Kind!");
        }
        // if the dice are not in a four of a kind, then check if the dice are in a three of a kind
        else if (isThreeOfAKind(diceList)) {
            System.out.println("Three of a Kind!");
        }
        // if the dice are not in a pair, then check if the dice are in a two pair
        else if (isTwoPair(diceList)) {
            System.out.println("Two Pair!");
        }
        // if the dice are not in a three of a kind, then check if the dice are in a pair
        else if (isPair(diceList)) {
            System.out.println("Pair!");
        }



    }

    private boolean isTwoPair(ArrayList<Integer> diceList) {
        // check if there are two pairs in the dice
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : diceList) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> val : hm.entrySet()) {
            if (hm.get(val.getKey()) == 2) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        }

        return false;

    }

    private boolean isPair(ArrayList<Integer> diceList) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : diceList) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }

        if(hm.containsValue(2)) {
            return true;
        }
        return false;
    }

    private boolean isThreeOfAKind(ArrayList<Integer> diceList) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : diceList) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }

        if(hm.containsValue(3)) {
            return true;
        }
        return false;
    }

    private boolean isFourOfAKind(ArrayList<Integer> diceList) {
        // if there is 4 of a kind, return true
        // iterate through the hashmap and check if there is a pair, 3 of a kind, 4 of a kind, or 5 of a kind
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i : diceList) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }

        if(hm.containsValue(4)) {
            return true;
        }
        return false;
    }

    private boolean isFullHouse(ArrayList<Integer> diceList) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i : diceList) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }

        // if the dice are in a full house, return true
        if (hm.containsValue(3) && hm.containsValue(2)) {
            return true;
        }
        return false;
    }

    private boolean isSmallStraight(ArrayList<Integer> diceList) {
        if(diceList.contains(1) && diceList.contains(2) && diceList.contains(3) && diceList.contains(4)) {
            return true;
        }
        else if(diceList.contains(2) && diceList.contains(3) && diceList.contains(4) && diceList.contains(5)) {
            return true;
        }
        else if(diceList.contains(3) && diceList.contains(4) && diceList.contains(5) && diceList.contains(6)) {
            return true;
        }
        return false;
    }

    private boolean isLargeStraight(ArrayList<Integer> diceList) {
        if (diceList.contains(1) && diceList.contains(2) && diceList.contains(3) && diceList.contains(4) && diceList.contains(5)) {
            return true;
        }
        else if (diceList.contains(2) && diceList.contains(3) && diceList.contains(4) && diceList.contains(5) && diceList.contains(6)) {
            return true;
        }
        return false;
    }




    public static void main(String[] args) {
        Yahtzee yahtzee = new Yahtzee();
        int[] dice = rollDice(5);
        System.out.println(yahtzee.getXOfAKind(dice));
    }
}
