/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package YahtzeeGame;

import java.util.Random;

/**
 *
 * @author noahelrimawi-fine
 */
public class Die {
    private int sides;
    private int value;

    public Die(){
        this.sides = 6;
        this.value = 0;
    }

    /**
     * Constructor for objects of class Dice
     *
     * @param sides the number of sides on the dice
     * @param value the value of the dice
     */
    public Die(int sides, int value) {
        this.sides = sides;
        this.value = value;
    }

    public Die(int sides) {
        this.sides = sides;
        this.value = 0;
    }

    /**
     * Rolls the dice
     * @return the value of the dice
     */
    public int roll() {
        Random rand = new Random();
        value = rand.nextInt(sides) + 1;
        return value;
    }

    /**
     * @return the value of the dice
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the number of sides on the dice
     */
    public int getSides() {
        return sides;
    }

}
