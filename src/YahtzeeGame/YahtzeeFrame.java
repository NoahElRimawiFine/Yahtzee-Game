/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package YahtzeeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

/**
 *
 * @author noahelrimawi-fine
 */
public class YahtzeeFrame extends javax.swing.JFrame {
    // create final dice constants
    public static final int NUM_DICE = 5;
    public static final int NUM_SIDES = 6;

    // create the tokens used to move from one state to another
    public final static int RESET_GAME = 1;
    public final static int BEFORE_1ST_ROLL = 2;
    public final static int BEFORE_2ND_ROLL = 3;
    public final static int BEFORE_3RD_ROLL = 4;
    public final static int AFTER_3RD_ROLL = 5;
    public final static int SCORING = 6;
    public final static int GAME_OVER = 7;

    // Lower Score categories
    public final int THREE_OF_A_KIND = 0;
    public final int FOUR_OF_A_KIND = 1;
    public final int FULL_HOUSE = 2;
    public final int SMALL_STRAIGHT = 3;
    public final int LARGE_STRAIGHT = 4;
    public final int YAHTZEE = 5;
    public final int CHANCE = 6;


    /**
     * Creates new form YahtzeeFrame
     */
    public YahtzeeFrame() {
        initComponents();

        // create a single set of dice
        myDice = new Dice(NUM_DICE,NUM_SIDES);

        // intialize rollButtons array
        rollButtons = new JToggleButton[NUM_DICE];

        rollButtons[0] = diceButton1;
        rollButtons[1] = diceButton2;
        rollButtons[2] = diceButton3;
        rollButtons[3] = diceButton4;
        rollButtons[4] = diceButton5;

        // TODO: edit this
        upperScoreButtonArray = new JToggleButton[GameModel.NUM_UPPER_SCORE_CATS + 1];

        // start at index 1 instead of 0 for logic reasons (aces = 1)
        upperScoreButtonArray[1] = this.acesButton;
        upperScoreButtonArray[2] = this.twosButton;
        upperScoreButtonArray[3] = this.threesButton;
        upperScoreButtonArray[4] = this.foursButton;
        upperScoreButtonArray[5] = this.fivesButton;
        upperScoreButtonArray[6] = this.sixesButton;

        upperScoreTextFieldArray = new JTextField[GameModel.NUM_UPPER_SCORE_CATS + 1];

        upperScoreTextFieldArray[1] = this.acesTextField;
        upperScoreTextFieldArray[2] = this.twosTextField;
        upperScoreTextFieldArray[3] = this.threesTextField;
        upperScoreTextFieldArray[4] = this.foursTextField;
        upperScoreTextFieldArray[5] = this.fivesTextField;
        upperScoreTextFieldArray[6] = this.sixesTextField;

        // now create the lowerScoreArray
        lowerScoreButtonArray = new JToggleButton[GameModel.NUM_LOWER_SCORE_CATS];

        lowerScoreButtonArray[THREE_OF_A_KIND] = this.a3OfAKindButton;
        lowerScoreButtonArray[FOUR_OF_A_KIND] = this.a4OfAKindButton;
        lowerScoreButtonArray[FULL_HOUSE] = this.fullHouseButton;
        lowerScoreButtonArray[SMALL_STRAIGHT] = this.smStraightButton;
        lowerScoreButtonArray[LARGE_STRAIGHT] = this.lgStraightButton;
        lowerScoreButtonArray[YAHTZEE] = this.yahtzeeButton;
        lowerScoreButtonArray[CHANCE] = this.chanceButton;

        // now create the lowerScoreTextFieldArray
        lowerScoreTextFieldArray = new JTextField[GameModel.NUM_LOWER_SCORE_CATS];

        lowerScoreTextFieldArray[THREE_OF_A_KIND] = this.txt3OfAKind;
        lowerScoreTextFieldArray[FOUR_OF_A_KIND] = this.txt4OfAKind;
        lowerScoreTextFieldArray[FULL_HOUSE] = this.txtFullHouse;
        lowerScoreTextFieldArray[SMALL_STRAIGHT] = this.txtSmStraight;
        lowerScoreTextFieldArray[LARGE_STRAIGHT] = this.txtLgStraight;
        lowerScoreTextFieldArray[YAHTZEE] = this.txtYahtzee;
        lowerScoreTextFieldArray[CHANCE] = this.txtChance;

        // this array checks if the dice have been selected or not
        selectedDice = new boolean[NUM_DICE];

        game = new GameModel();

        manageUIState(RESET_GAME);
        manageUIState(BEFORE_1ST_ROLL);


    }

    public void manageUIState(int nextState) {
        switch (nextState) {
            case RESET_GAME:
                game.clearAllUpperScoringCats();
                game.clearAllLowerScoringCats();
                game.clearUsedScoringCats();
                this.clearAllTextBoxes();
                this.resetScoreToggleButtons();
                game.resetTurn();
                assistButton.setSelected(false);
                break;

            case BEFORE_1ST_ROLL:
                rollButton.setEnabled(true);
                clearHoldButtons();
                clearSelectedDice();
                disableAllScoreButtons();
                break;

            case BEFORE_2ND_ROLL:
                // enable the hold buttons
                enableHoldButtons();
                enableAllUnusedScoreButtons();
                break;

            case BEFORE_3RD_ROLL:
                break;

            case AFTER_3RD_ROLL:
                rollButton.setEnabled(false);
                break;

            case SCORING:
                disableAllScoreButtons();
                game.nextTurn();
                break;

            case GAME_OVER:
                JOptionPane.showMessageDialog(null, "Your score was " + game.getGrandTotal());
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid state UI state detected");
                break;
        }
        currentUIState = nextState;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        diceButton2 = new javax.swing.JToggleButton();
        diceButton3 = new javax.swing.JToggleButton();
        diceButton4 = new javax.swing.JToggleButton();
        diceButton5 = new javax.swing.JToggleButton();
        diceButton1 = new javax.swing.JToggleButton();
        rollButton = new javax.swing.JToggleButton();
        threesButton = new javax.swing.JToggleButton();
        twosButton = new javax.swing.JToggleButton();
        acesButton = new javax.swing.JToggleButton();
        foursButton = new javax.swing.JToggleButton();
        sixesButton = new javax.swing.JToggleButton();
        fivesButton = new javax.swing.JToggleButton();
        a3OfAKindButton = new javax.swing.JToggleButton();
        smStraightButton = new javax.swing.JToggleButton();
        lgStraightButton = new javax.swing.JToggleButton();
        a4OfAKindButton = new javax.swing.JToggleButton();
        chanceButton = new javax.swing.JToggleButton();
        yahtzeeButton = new javax.swing.JToggleButton();
        fullHouseButton = new javax.swing.JToggleButton();
        acesTextField = new javax.swing.JTextField();
        twosTextField = new javax.swing.JTextField();
        threesTextField = new javax.swing.JTextField();
        foursTextField = new javax.swing.JTextField();
        fivesTextField = new javax.swing.JTextField();
        sixesTextField = new javax.swing.JTextField();
        txt3OfAKind = new javax.swing.JTextField();
        txt4OfAKind = new javax.swing.JTextField();
        txtFullHouse = new javax.swing.JTextField();
        txtSmStraight = new javax.swing.JTextField();
        txtLgStraight = new javax.swing.JTextField();
        txtYahtzee = new javax.swing.JTextField();
        txtChance = new javax.swing.JTextField();
        upperScoreTextField = new javax.swing.JTextField();
        bonusTextField = new javax.swing.JTextField();
        lowerScoreTextField = new javax.swing.JTextField();
        totalGameScoreTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        gameScoreLabel = new javax.swing.JLabel();
        newGameButton = new javax.swing.JButton();
        assistButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        diceButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diceButton2ActionPerformed(evt);
            }
        });

        diceButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diceButton3ActionPerformed(evt);
            }
        });

        diceButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diceButton4ActionPerformed(evt);
            }
        });

        diceButton5.setToolTipText("");
        diceButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diceButton5ActionPerformed(evt);
            }
        });

        diceButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diceButton1ActionPerformed(evt);
            }
        });

        rollButton.setText("Roll");
        rollButton.setBorder(new javax.swing.border.MatteBorder(null));
        rollButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollButtonActionPerformed(evt);
            }
        });

        threesButton.setText("Threes");
        threesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threesButtonActionPerformed(evt);
            }
        });

        twosButton.setText("Twos");
        twosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twosButtonActionPerformed(evt);
            }
        });

        acesButton.setText("Aces");
        acesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acesButtonActionPerformed(evt);
            }
        });

        foursButton.setText("Fours");
        foursButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foursButtonActionPerformed(evt);
            }
        });

        sixesButton.setText("Sixes");
        sixesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixesButtonActionPerformed(evt);
            }
        });

        fivesButton.setText("Fives");
        fivesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fivesButtonActionPerformed(evt);
            }
        });

        a3OfAKindButton.setText("3 of a Kind");
        a3OfAKindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a3OfAKindButtonActionPerformed(evt);
            }
        });

        smStraightButton.setText("Sm Straight");
        smStraightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smStraightButtonActionPerformed(evt);
            }
        });

        lgStraightButton.setText("Lg Straight");
        lgStraightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgStraightButtonActionPerformed(evt);
            }
        });

        a4OfAKindButton.setText("4 of a Kind");
        a4OfAKindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a4OfAKindButtonActionPerformed(evt);
            }
        });

        chanceButton.setText("Chance");
        chanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chanceButtonActionPerformed(evt);
            }
        });

        yahtzeeButton.setText("Yahtzee");
        yahtzeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yahtzeeButtonActionPerformed(evt);
            }
        });

        fullHouseButton.setText("Full House");
        fullHouseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullHouseButtonActionPerformed(evt);
            }
        });

        acesTextField.setEditable(false);

        twosTextField.setEditable(false);

        threesTextField.setEditable(false);

        foursTextField.setEditable(false);

        fivesTextField.setEditable(false);

        sixesTextField.setEditable(false);

        txt3OfAKind.setEditable(false);

        txt4OfAKind.setEditable(false);

        txtFullHouse.setEditable(false);

        txtSmStraight.setEditable(false);

        txtLgStraight.setEditable(false);

        txtYahtzee.setEditable(false);

        txtChance.setEditable(false);

        upperScoreTextField.setEditable(false);

        bonusTextField.setEditable(false);

        lowerScoreTextField.setEditable(false);

        totalGameScoreTextField.setEditable(false);

        jLabel1.setText("Upper Score");

        jLabel2.setText("Bonus if > 63");

        jLabel4.setText("Total Lower Score");

        gameScoreLabel.setText("Total Game Score");

        newGameButton.setText("New Game");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        assistButton.setText("Assist");
        assistButton.setToolTipText("");
        assistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assistButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(fivesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(fivesTextField))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(foursButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(foursTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(threesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(threesTextField))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(twosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(twosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(acesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(acesTextField))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(sixesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jLabel2))
                                                                        .addGap(15, 15, 15)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(3, 3, 3)
                                                                                        .addComponent(sixesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(bonusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(upperScoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(diceButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(46, 46, 46)
                                                                .addComponent(diceButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(46, 46, 46)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(diceButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(47, 47, 47)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(chanceButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(yahtzeeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(a4OfAKindButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(fullHouseButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(lgStraightButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(smStraightButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(a3OfAKindButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(txt3OfAKind, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                                                                        .addComponent(txtFullHouse)
                                                                                        .addComponent(txtSmStraight)
                                                                                        .addComponent(txt4OfAKind)
                                                                                        .addComponent(txtLgStraight)
                                                                                        .addComponent(txtYahtzee)
                                                                                        .addComponent(txtChance)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(gameScoreLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(totalGameScoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel4)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(lowerScoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(diceButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(46, 46, 46)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(assistButton)
                                                                                        .addComponent(diceButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(newGameButton))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(diceButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(diceButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(diceButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(diceButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(diceButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(assistButton))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(acesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(acesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(a3OfAKindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(twosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(a4OfAKindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(twosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txt4OfAKind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(threesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fullHouseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(threesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtFullHouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(foursButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(smStraightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(foursTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtSmStraight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(fivesButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(lgStraightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(fivesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtLgStraight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sixesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(yahtzeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sixesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtYahtzee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(chanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(upperScoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(txtChance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(bonusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(txt3OfAKind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lowerScoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(totalGameScoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gameScoreLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newGameButton)
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void diceButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        selectedDice[0] = !selectedDice[0];
    }

    private void rollButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int rollValue;
        rollButton.setSelected(false);

        for (int i = 0; i < NUM_DICE; i++) {
            // if the die is not selected, display the value
            if (!selectedDice[i]) {
                // roll the die
                rollValue = myDice.rollDie(i);
                rollButtons[i].setText("" + rollValue);
            }
        }

        if(assistButton.isSelected()) {
            if (currentUIState != BEFORE_3RD_ROLL) {
                JOptionPane.showMessageDialog(null, game.chooseDiceToHold(myDice));
            }
        }

        switch (currentUIState) {
            case BEFORE_1ST_ROLL:
                manageUIState(BEFORE_2ND_ROLL);
                break;
            case BEFORE_2ND_ROLL:
                manageUIState(BEFORE_3RD_ROLL);
                break;
            case BEFORE_3RD_ROLL:
                manageUIState(AFTER_3RD_ROLL);
        }

    }

    private void diceButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        selectedDice[1] = !selectedDice[1];
    }

    private void diceButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        selectedDice[2] = !selectedDice[2];
    }

    private void diceButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        selectedDice[3] = !selectedDice[3];
    }

    private void diceButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        selectedDice[4] = !selectedDice[4];
    }

    private void twosButtonActionPerformed(java.awt.event.ActionEvent evt) {
        scoreUpperCategory(2);
        twosButton.setSelected(false);
    }

    public void showTotalsAndAdvanceTurn() {
        this.showTotals();

        // if it is not the end of the game
        if (game.getCurrentTurnNum() <= GameModel.MAX_NUM_TURNS) {
            manageUIState(BEFORE_1ST_ROLL);
        }

        else {
            manageUIState(GAME_OVER);
        }
    }

    private void a3OfAKindButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int score = 0;
        a3OfAKindButton.setSelected(false);

        game.setUsedLowerScoreCat(THREE_OF_A_KIND, true);
        manageUIState(SCORING);

        if(game.isOfAKind(myDice, 3)) {
            score = game.addDice(myDice);
        }

        game.setLowerScoreCat(THREE_OF_A_KIND, score);

        this.lowerScoreTextFieldArray[THREE_OF_A_KIND].setText("" + score);

        showTotalsAndAdvanceTurn();
    }

    private void acesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        scoreUpperCategory(1);
        acesButton.setSelected(false);
    }

    private void scoreUpperCategory(int category) {
        int score = 0;

        // set the category so it looks used
        game.setUsedUpperScoreCat(category, true);

        // advance the UI state to the scoring state
        manageUIState(SCORING);

        for(int i = 0; i < NUM_DICE; i++) {
            if(myDice.getDieValue(i) == category){
                score += category;
            }
        }

        // set the instance field in game model to hold score for aces
        game.setUpperScoreCat(category, score);

        // show computed score
        this.upperScoreTextFieldArray[category].setText("" + score);
        showTotalsAndAdvanceTurn();
    }

    private void a4OfAKindButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int score = 0;
        a4OfAKindButton.setSelected(false);

        game.setUsedLowerScoreCat(FOUR_OF_A_KIND, true);
        manageUIState(SCORING);

        if(game.isOfAKind(myDice, 4)) {
            score = game.addDice(myDice);
        }

        game.setLowerScoreCat(FOUR_OF_A_KIND, score);

        this.lowerScoreTextFieldArray[FOUR_OF_A_KIND].setText("" + score);
        showTotalsAndAdvanceTurn();
    }

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        manageUIState(RESET_GAME);
        manageUIState(BEFORE_1ST_ROLL);
    }

    private void threesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        scoreUpperCategory(3);
        threesButton.setSelected(false);
    }

    private void foursButtonActionPerformed(java.awt.event.ActionEvent evt) {
        scoreUpperCategory(4);
        foursButton.setSelected(false);
    }

    private void fivesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        scoreUpperCategory(5);
        fivesButton.setSelected(false);
    }

    private void sixesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        scoreUpperCategory(6);
        sixesButton.setSelected(false);
    }

    private void chanceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int score = 0;
        chanceButton.setSelected(false);

        game.setUsedLowerScoreCat(CHANCE, true);
        manageUIState(SCORING);

        score = game.addDice(myDice);

        game.setLowerScoreCat(CHANCE, score);
        this.lowerScoreTextFieldArray[CHANCE].setText("" + score);

        showTotalsAndAdvanceTurn();
    }

    private void yahtzeeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int score = 0;
        yahtzeeButton.setSelected(false);

        game.setUsedLowerScoreCat(YAHTZEE, true);
        manageUIState(SCORING);

        if(game.isOfAKind(myDice, 5)) {
            score = 50;
        }

        game.setLowerScoreCat(YAHTZEE, score);
        this.lowerScoreTextFieldArray[YAHTZEE].setText("" + score);

        showTotalsAndAdvanceTurn();
    }

    private void fullHouseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int score = 0;
        fullHouseButton.setSelected(false);

        game.setUsedLowerScoreCat(FULL_HOUSE, true);
        manageUIState(SCORING);

        if(game.isFullHouse(myDice)) {
            score = 25;
        }

        game.setLowerScoreCat(FULL_HOUSE, score);
        this.lowerScoreTextFieldArray[FULL_HOUSE].setText("" + score);

        showTotalsAndAdvanceTurn();
    }

    private void lgStraightButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int score = 0;
        lgStraightButton.setSelected(false);

        game.setUsedLowerScoreCat(LARGE_STRAIGHT, true);
        manageUIState(SCORING);

        if(game.isLargeStraight(myDice)) {
            score = 40;
        }

        game.setLowerScoreCat(LARGE_STRAIGHT, score);
        this.lowerScoreTextFieldArray[LARGE_STRAIGHT].setText("" + score);

        showTotalsAndAdvanceTurn();
    }

    private void smStraightButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int score = 0;
        smStraightButton.setSelected(false);

        game.setUsedLowerScoreCat(SMALL_STRAIGHT, true);
        manageUIState(SCORING);

        if(game.isSmallStraight(myDice)) {
            score = 30;
        }

        game.setLowerScoreCat(SMALL_STRAIGHT, score);
        this.lowerScoreTextFieldArray[SMALL_STRAIGHT].setText("" + score);

        showTotalsAndAdvanceTurn();
    }

    private void assistButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (assistButton.isSelected()) {
            assistButton.setSelected(true);
        } else {
            assistButton.setSelected(false);
        }

    }


    private void setHoldButtonsEnabledState(boolean isEnabled) {
        for (int i = 0; i < myDice.getNumDice(); i++) {
            rollButtons[i].setEnabled(isEnabled);
        }
    }

    private void clearHoldButtons() {
        for(int i = 0; i < NUM_DICE; i++) {
            rollButtons[i].setText("");
            rollButtons[i].setEnabled(false);

            rollButtons[i].setSelected(false);
        }
    }

    private void enableHoldButtons(){
        for(int i = 0; i < NUM_DICE; i++) {
            rollButtons[i].setEnabled(true);
        }
    }

    private void clearAllTextBoxes() {

        for(int i = 1; i <= GameModel.NUM_UPPER_SCORE_CATS; i++) {
            upperScoreTextFieldArray[i].setText("");
        }

        this.bonusTextField.setText("");
        this.upperScoreTextField.setText("");

        for(int i = 0; i < GameModel.NUM_LOWER_SCORE_CATS; i++) {
            lowerScoreTextFieldArray[i].setText("");
        }

        this.lowerScoreTextField.setText("");
        this.totalGameScoreTextField.setText("");

    }

    private void clearSelectedDice() {
        for (int i = 0; i < selectedDice.length; i++) {
            selectedDice[i] = false;
        }
    }

    private void disableAllScoreButtons() {
        // disable the upper score buttons
        for(int i = 1; i <= GameModel.NUM_UPPER_SCORE_CATS; i++) {
            this.upperScoreButtonArray[i].setEnabled(false);
        }

        // disable the lower score buttons
        for (int i = 0; i < GameModel.NUM_LOWER_SCORE_CATS; i++) {
            this.lowerScoreButtonArray[i].setEnabled(false);
        }
    }

    private void enableAllUnusedScoreButtons() {

        // enable the upper score toggle buttons if unused
        for(int i = 1; i <= GameModel.NUM_UPPER_SCORE_CATS; i++) {
            // if the category has not been used yet
            if(!game.getUsedUpperScoringCatState(i)) {
                this.upperScoreButtonArray[i].setEnabled(true);
            }
        }

        // enable the lower score toggle buttons if unused
        for (int i = 0; i < GameModel.NUM_LOWER_SCORE_CATS; i++) {
            // if the category has not been used
            if(!game.getUsedLowerScoringCatState(i)) {
                this.lowerScoreButtonArray[i].setEnabled(true);
            }
        }
    }

    public void resetScoreToggleButtons() {
        for(int i = 1; i <= GameModel.NUM_UPPER_SCORE_CATS; i++) {
            upperScoreButtonArray[i].setEnabled(false);
        }

        for(int i = 1; i < GameModel.NUM_LOWER_SCORE_CATS; i++) {
            lowerScoreButtonArray[i].setEnabled(false);
        }
    }

    public void showTotals() {
        game.updateTotals();
        bonusTextField.setText("" + game.getBonus());
        upperScoreTextField.setText("" + game.getSumUpperScores());
        lowerScoreTextField.setText("" + game.getSumLowerScores());
        totalGameScoreTextField.setText("" + game.getGrandTotal());
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(YahtzeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YahtzeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YahtzeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YahtzeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YahtzeeFrame().setVisible(true);
            }
        });
    }

    // this is meant to initialize the variables
    private Dice myDice;
    private JToggleButton[] rollButtons;
    private JToggleButton[] upperScoreButtonArray;
    private JToggleButton[] lowerScoreButtonArray;
    private JTextField[] upperScoreTextFieldArray;
    private JTextField[] lowerScoreTextFieldArray;
    private boolean[] selectedDice;

    private int rollNum; // will be removed later

    private GameModel game;

    private int currentUIState;
    private OptimalStrategy optimalStrategy;



    // Variables declaration - do not modify
    private javax.swing.JToggleButton a3OfAKindButton;
    private javax.swing.JToggleButton a4OfAKindButton;
    private javax.swing.JToggleButton acesButton;
    private javax.swing.JTextField acesTextField;
    private javax.swing.JToggleButton assistButton;
    private javax.swing.JTextField bonusTextField;
    private javax.swing.JToggleButton chanceButton;
    private javax.swing.JToggleButton diceButton1;
    private javax.swing.JToggleButton diceButton2;
    private javax.swing.JToggleButton diceButton3;
    private javax.swing.JToggleButton diceButton4;
    private javax.swing.JToggleButton diceButton5;
    private javax.swing.JToggleButton fivesButton;
    private javax.swing.JTextField fivesTextField;
    private javax.swing.JToggleButton foursButton;
    private javax.swing.JTextField foursTextField;
    private javax.swing.JToggleButton fullHouseButton;
    private javax.swing.JLabel gameScoreLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToggleButton lgStraightButton;
    private javax.swing.JTextField lowerScoreTextField;
    private javax.swing.JButton newGameButton;
    private javax.swing.JToggleButton rollButton;
    private javax.swing.JToggleButton sixesButton;
    private javax.swing.JTextField sixesTextField;
    private javax.swing.JToggleButton smStraightButton;
    private javax.swing.JToggleButton threesButton;
    private javax.swing.JTextField threesTextField;
    private javax.swing.JTextField totalGameScoreTextField;
    private javax.swing.JToggleButton twosButton;
    private javax.swing.JTextField twosTextField;
    private javax.swing.JTextField txt3OfAKind;
    private javax.swing.JTextField txt4OfAKind;
    private javax.swing.JTextField txtChance;
    private javax.swing.JTextField txtFullHouse;
    private javax.swing.JTextField txtLgStraight;
    private javax.swing.JTextField txtSmStraight;
    private javax.swing.JTextField txtYahtzee;
    private javax.swing.JTextField upperScoreTextField;
    private javax.swing.JToggleButton yahtzeeButton;
    // End of variables declaration

}
