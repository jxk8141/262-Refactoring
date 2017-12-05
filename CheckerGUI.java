/*
 * CheckerGUI.java
 * 
 * The actual board.
 *
 * Created on January 25, 2002, 2:34 PM
 * 
 * Version
 * $Id: CheckerGUI.java,v 1.1 2002/10/22 21:12:52 se362 Exp $
 * 
 * Revisions
 * $Log: CheckerGUI.java,v $
 * Revision 1.1  2002/10/22 21:12:52  se362
 * Initial creation of case study
 *
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.net.*;

/**
 * Used to create an Object representing the GUI used to play checkers, including the board, labels and other buttons.
 */
public class CheckerGUI extends JFrame implements ActionListener {

    //***CheckerGUI Class Variables***//
    private static Facade theFacade;
    private Vector possibleSquares = new Vector();
    private int timeRemaining;
    private JButton[] jButtons;
    private JLabel PlayerOneLabel, PlayerTwoLabel, timeRemainingLabel, secondsLeftLabel, warningLabel, whosTurnLabel;
    private JButton ResignButton, DrawButton;
    private GridBagConstraints gridBagConstraints;
    private static String playerOnesName = "";
    private static String playerTwosName = "";

    /**
     * Constructor, creates the GUI and all its components
     *
     * @param facade the facade for the GUI to interact with
     * @param name1  the first players name
     * @param name2  the second players name
     */
    CheckerGUI(Facade facade, String name1, String name2) {
        super("Checkers");

        playerOnesName = trimName(name1);
        playerTwosName = trimName(name2);
        theFacade = facade;

        register();
        initComponents();
        pack();
        update();
        //updateTime();
    } //CheckerGUI

    /**
     * Helper method to trim player name
     *
     * @param name  the player name
     * @return the trimmed name
     */
    private String trimName(String name) {
        //long names mess up the way the GUI displays
        //this code shortens the name if it is too long
        if (name.length() > 7) {
            return name.substring(0, 7);
        } else {
            return name;
        }
    } //trimName

    /**
     * This method handles setting up the timer
     */
    private void register() {
        try {
            theFacade.addActionListener(this);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    } //register

    /**
     * This method is called from within the constructor to
     * initialize the form. It initializes the components.
     */
    private void initComponents() {
        jButtons = new JButton[64];

        PlayerOneLabel = new JLabel();
        PlayerTwoLabel = new JLabel();
        whosTurnLabel = new JLabel();

        warningLabel = new JLabel();
        timeRemainingLabel = new JLabel();
        secondsLeftLabel = new JLabel();

        ResignButton = new JButton();
        ResignButton.addActionListener(this);

        DrawButton = new JButton();
        DrawButton.addActionListener(this);

        initGrid();
    } //initComponents

    /**
     * Called from initComponents to add the buttons to the Vector of squares
     * and add an action listener to the components
     */
    private void initGrid() {
        this.setResizable(false);
        jAddActionListeners();
        possibleSquares = addButtons(jButtons);

        //sets the layout and adds listener for closing window
        getContentPane().setLayout(new GridBagLayout());
        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent evt) {
                                  exitForm();
                              }
                          }
        );

        populateCheckerboard();
        addPlayerNames();
        addLabels();
        addMiscButtons();
    } //initGrid

    /**
     * Fills jButtons array with JButtons and adds an action listener
     */
    private void jAddActionListeners() {
        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i] = new JButton();
            jButtons[i].addActionListener(this);
        }
    } //jAddActionListeners

    /**
     * Populates a vector with the elements of a JButton array
     * @param buttons the JButton array
     * @return the vector
     */
    private Vector addButtons(JButton[] buttons) {
        Vector vector = new Vector();
        vector.addAll(Arrays.asList(buttons));
        return vector;
    } //addButtons

    /**
     * Adds the checkerboard buttons to the GUI
     */
    private void populateCheckerboard() {
        gridBagConstraints = new java.awt.GridBagConstraints();
        int i = 0;
        int wb = 0;
        for (int y = 1; y < 9; y++) {
            for (int x = 0; x < 8; x++) {
                jButtons[i].setPreferredSize(new Dimension(80, 80));
                jButtons[i].setActionCommand(Integer.toString(i));
                if (wb == 0) {
                    jButtons[i].setBackground(Color.white);
                    wb++;
                } else if (wb == 1) {
                    jButtons[i].setBackground(new Color(204, 204, 153));
                    wb--;
                }
                gridBagConstraints.gridx = x;
                gridBagConstraints.gridy = y;
                getContentPane().add(jButtons[i], gridBagConstraints);
                i++;
            }
            if (wb == 0) wb++;
            else if (wb == 1) wb--;
        }
    } //populateCheckerboard

    /**
     * Adds the player names to the GUI
     */
    private void addPlayerNames() {
        gridBagConstraints = new java.awt.GridBagConstraints();

        PlayerOneLabel.setText("Player 1:     " + playerOnesName);
        PlayerOneLabel.setForeground(Color.black);

        PlayerTwoLabel.setText("Player 2:     " + playerTwosName);
        PlayerTwoLabel.setForeground(Color.black);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        getContentPane().add(PlayerTwoLabel, gridBagConstraints);
        gridBagConstraints.gridy = 9;
        getContentPane().add(PlayerOneLabel, gridBagConstraints);
    } //addPlayerNames

    /**
     * Add the labels to the GUI
     */
    private void addLabels() {
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;

        whosTurnLabel.setText("");
        whosTurnLabel.setForeground(new Color(0, 100, 0));

        warningLabel.setText("");
        warningLabel.setForeground(Color.red);

        timeRemainingLabel.setText("Time Remaining:");
        timeRemainingLabel.setForeground(Color.black);

        String timeLeft = "";
        secondsLeftLabel.setText(timeLeft + " sec.");
        secondsLeftLabel.setForeground(Color.black);

        getContentPane().add(whosTurnLabel, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        getContentPane().add(warningLabel, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridy = 3;
        getContentPane().add(timeRemainingLabel, gridBagConstraints);

        gridBagConstraints.gridy = 4;
        getContentPane().add(secondsLeftLabel, gridBagConstraints);
    } //addLabels

    /**
     * Adds the resign and draw buttons to the GUI
     */
    private void addMiscButtons() {
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;

        ResignButton.setActionCommand("resign");
        ResignButton.setText("Resign");

        DrawButton.setActionCommand("draw");
        DrawButton.setText("Draw");

        gridBagConstraints.gridy = 7;
        getContentPane().add(ResignButton, gridBagConstraints);

        gridBagConstraints.gridy = 6;
        getContentPane().add(DrawButton, gridBagConstraints);
    } //addMiscButtons

    /**
     * Exit the Application
     */
    private void exitForm() {
        theFacade.pressQuit();
    } //exitForm

    /**
     * Takes care of input from users, handles any actions performed
     *
     * @param e the event that has occurred
     */
    public void actionPerformed(ActionEvent e) {
        try {
            //if a square gets clicked
            if (e.getActionCommand().equals("1") ||
                    e.getActionCommand().equals("3") ||
                    e.getActionCommand().equals("5") ||
                    e.getActionCommand().equals("7") ||
                    e.getActionCommand().equals("8") ||
                    e.getActionCommand().equals("10") ||
                    e.getActionCommand().equals("12") ||
                    e.getActionCommand().equals("14") ||
                    e.getActionCommand().equals("17") ||
                    e.getActionCommand().equals("19") ||
                    e.getActionCommand().equals("21") ||
                    e.getActionCommand().equals("23") ||
                    e.getActionCommand().equals("24") ||
                    e.getActionCommand().equals("26") ||
                    e.getActionCommand().equals("28") ||
                    e.getActionCommand().equals("30") ||
                    e.getActionCommand().equals("33") ||
                    e.getActionCommand().equals("35") ||
                    e.getActionCommand().equals("37") ||
                    e.getActionCommand().equals("39") ||
                    e.getActionCommand().equals("40") ||
                    e.getActionCommand().equals("42") ||
                    e.getActionCommand().equals("44") ||
                    e.getActionCommand().equals("46") ||
                    e.getActionCommand().equals("49") ||
                    e.getActionCommand().equals("51") ||
                    e.getActionCommand().equals("53") ||
                    e.getActionCommand().equals("55") ||
                    e.getActionCommand().equals("56") ||
                    e.getActionCommand().equals("58") ||
                    e.getActionCommand().equals("60") ||
                    e.getActionCommand().equals("62")) {
                //call selectSpace with the button pressed
                theFacade.selectSpace(Integer.parseInt(e.getActionCommand()));
            //if draw is pressed
            } else if (e.getActionCommand().equals("draw")) {
                //does sequence of events for a draw
                theFacade.pressDraw();
            //if resign is pressed
            } else if (e.getActionCommand().equals("resign")) {
                //does sequence of events for a resign
                theFacade.pressQuit();
            //if the source came from the facade
            } else if (e.getSource().equals(theFacade)) {
                //if its a player switch event
                if ((e.getActionCommand()).equals(Facade.playerSwitch)) {
                    //set a new time
                    timeRemaining = theFacade.getTimer();
                //if it is an update event
                } else if ((e.getActionCommand()).equals(Facade.update)) {
                    //update the GUI
                    update();
                } else {
                    throw new Exception("unknown message from facade");
                }
            }
        //catch various Exceptions
        } catch (NumberFormatException excep) {
            System.err.println(
                    "GUI exception: Error converting a string to a number");
        } catch (NullPointerException exception) {
            System.err.println("GUI exception: Null pointerException "
                    + exception.getMessage());
            exception.printStackTrace();
        } catch (Exception except) {
            System.err.println("GUI exception: other: "
                    + except.getMessage());
            except.printStackTrace();
        }
    } //actionPerformed

    /**
     * Updates the GUI reading the pieces in the board
     * Puts pieces in correct spaces, updates whos turn it is
     */
    private void update() {
        if (checkEndConditions()) {
            theFacade.showEndGame(" ");
        }
        //the board to read information from
        Board board = theFacade.stateOfBoard();
        //a temp button to work with
        JButton temp;

        //go through the board
        for (int i = 1; i < board.sizeOf(); i++) {
            // if there is a piece there
            if (board.occupied(i)) {
                //check to see if color is blue
                if (board.colorAt(i) == Color.blue) {
                    //if there is a  single piece there
                    if ((board.getPieceAt(i)).getType() == Board.SINGLE) {
                        //show a blue single piece in that spot board
                        temp = (JButton) possibleSquares.get(i);
                        //get the picture from the web
                        try {
                            temp.setIcon(
                                    new ImageIcon(new URL("file:BlueSingle.gif")));
                        } catch (MalformedURLException e) {
                            System.out.println(e.getMessage());
                        }
                    //if there is a kinged piece there
                    } else if ((board.getPieceAt(i)).getType() == Board.KING) {
                        //show a blue king piece in that spot board
                        temp = (JButton) possibleSquares.get(i);
                        //get the picture formt the web
                        try {
                            temp.setIcon(new ImageIcon(new URL("file:BlueKing.gif")));
                        } catch (Exception e) {}
                    }
                //check to see if the color is white
                } else if (board.colorAt(i) == Color.white) {
                    //if there is a single piece there
                    if ((board.getPieceAt(i)).getType() == Board.SINGLE) {
                        //show a blue single piece in that spot board
                        temp = (JButton) possibleSquares.get(i);
                        //get the picture from the web
                        try {
                            temp.setIcon(new ImageIcon(new URL("file:WhiteSingle.gif")));
                        } catch (Exception e) {}
                    //if there is a kinged piece there
                    } else if ((board.getPieceAt(i)).getType() == Board.KING) {
                        //show a blue king piece in that spot board
                        temp = (JButton) possibleSquares.get(i);
                        //get the picture from the web
                        try {
                            temp.setIcon(new ImageIcon(new URL("file:WhiteKing.gif")));
                        } catch (Exception e) {}
                    }
                }
            //if there isnt a piece there
            } else {
                //show no picture
                temp = (JButton) possibleSquares.get(i);
                temp.setIcon(null);
            }
        }

        //update who's turn it is
        if (theFacade.whosTurn() == 2) {
            PlayerTwoLabel.setForeground(Color.red);
            PlayerOneLabel.setForeground(Color.black);
            whosTurnLabel.setText(playerTwosName + "'s turn ");
        } else if (theFacade.whosTurn() == 1) {
            PlayerOneLabel.setForeground(Color.red);
            PlayerTwoLabel.setForeground(Color.black);
            whosTurnLabel.setText(playerOnesName + "'s turn");
        }
    } //update

    /**
     * Updates the timer
     * Not currently used in the program
     */
    public void updateTime() {
        if (theFacade.getTimer() > 0) {
            // if the time has run out but not in warning time yet
            // display warning and count warning time
            if (timeRemaining <= 0 && (warningLabel.getText()).equals("")) {
                timeRemaining = theFacade.getTimerWarning();
                warningLabel.setText("Time is running out!!!");
            // if the time has run out and it was in warning time quit game
            } else if (timeRemaining <= 0 && !(warningLabel.getText()).equals("")) {
                theFacade.pressQuit();
            } else {
                timeRemaining--;
            }
            secondsLeftLabel.setText(timeRemaining + " sec.");
        } else {
            secondsLeftLabel.setText("*****");
        }
    } //updateTime

    /**
     * Checks the ending conditions for the game
     * see if there a no pieces left
     *
     * @return the return value for the method
     *      true if the game should end
     *      false if game needs to continue
     */
    private boolean checkEndConditions() {
        //the return value
        boolean retVal = false;
        try {
            //the number of each piece left
            int whitesGone = 0, bluesGone = 0;
            //the board to work with
            Board temp = theFacade.stateOfBoard();
            //go through all the spots on the board
            for (int i = 1; i < temp.sizeOf(); i++) {
                //if there is a piece there
                if (temp.occupied(i)) {
                    //if its a blue piece there
                    if ((temp.getPieceAt(i)).getColor() == Color.blue) {
                        // increment number of blues
                        bluesGone++;
                    //if the piece is white
                    } else if ((temp.getPieceAt(i)).getColor() == Color.white) {
                        //increment number of whites
                        whitesGone++;
                    }
                }
            } //end of for loop
            //if either of the number are 0
            if (whitesGone == 0 || bluesGone == 0) {
                retVal = true;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return retVal;
    } //checkEndConditions

} //checkerGUI.java