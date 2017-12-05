/**
 * Driver.java
 *
 * Version
 *    $Id: Driver.java,v 1.1 2002/10/22 21:12:52 se362 Exp $ 
 *
 * Revisions:
 *    $Log: Driver.java,v $
 *    Revision 1.1  2002/10/22 21:12:52  se362
 *    Initial creation of case study
 *
 */

import java.awt.*;
import java.net.*;
import javax.swing.*;

/**
 *
 * This class is a part of the main functionality of the checkers 
 * game. This class contains the main method to start the game, it 
 * creates all necessary classes as informaton is provided. Its 
 * functions include knowing whose turn it is, remembering multiple 
 * jumps, relaying end of game conditions and ending the game.
 *
 * @author
 *
 */

public class Driver {
    private Player playerOne;
    private Player playerTwo;
    private Facade.GameType gameType;
    private Player activePlayer;
    private Player passivePlayer;
    private boolean runningTimer;
    private Timer theTimer;
    private Facade facade;
    private Rules rules;
    private Network network;

    /**
     * Constructor
     * Create the driver, which in turn creates the rest of
     * the system.
     */
    public Driver() {
        // Create the board
        Board theBoard = new Board();

        rules = new Rules(theBoard, this);
        facade = new Facade(theBoard, this);
        network = new Network(this);
    }

    /**
     * Return the facade the GUI will talk to.
     *
     * @return A facade to talk to the GUI.
     */
    public Facade getFacade() {
        return this.facade;
    }

    /**
     * This method is called after a move has been checked.
     * Changes active player when a final succesful jump has
     * been made, resets the timer when appropriate, and tells
     * the appropriate player whos turn it is to make a move.
     *
     * @param player The player whose turn it will now be
     * @param space  The space on the board from which a multiple
     *               jump has to be made
     */
    public void endTurn(Player player, int space) {

        // Check to see if player passed in was the active player
        // If player passed in was active player, check for multiple
        // jump (space is none negative)
        if (activePlayer == player) {

            // Inform the player that the move was not valid,
            // or to make antoher jump
            if (space < 0) {
                JOptionPane.showMessageDialog(null,
                        activePlayer.getName() + " made an illegal move",
                        "Invalid Move", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        activePlayer.getName() + " please make" +
                                " another jump", "Multiple Jump Possible",
                        JOptionPane.INFORMATION_MESSAGE);

                // Get the GUI to update
                facade.setPlayerModes(activePlayer, passivePlayer);

                // If game is networked tell networked player to send
                // the move
                network.sendMove(activePlayer);
            }
        } else if (passivePlayer == player) {
            // If game is networked, tell networked player to send move
            network.askForMove(activePlayer);

            // Inform the other player to make a move and
            // tell facade to update any listining GUIs and
            // reset the timer

            Player tempHold = activePlayer;
            activePlayer = passivePlayer;
            passivePlayer = tempHold;

            facade.setPlayerModes(activePlayer, passivePlayer);
        }

    }

    /**
     * This method ends the checkers game due to whatever reason neccessary
     * ie. a draw, someone quitting, or a victory.
     *
     * @param message the message to send to all players regarding the
     *                reason for ending the game
     */
    public void endGame(String message) {

        // Call endOfGame on both players with the given message
        playerOne.endOfGame(message);
        playerTwo.endOfGame(message);

        // When players have acknowledged the end of game
        // call System.exit()
        System.exit(0);
    }

    /**
     * This method creates the correct players for a game.
     *
     * @param type the type of player to be created (0 - local, 1 - network)
     * @param name the name of the player
     * @param num  the player's number
     */
    public void createPlayer(int num, int type, String name) {
        Player temp = null;

        if (type == Player.LOCALPLAYER) {
            temp = new LocalPlayer(num, rules, this);
            temp.setName(name);
        } else if (type == Player.NETWORKPLAYER) {
            temp = new NetworkPlayer(num, rules, this);
            temp.setName(name);
        }

        if (num == 1) {
            playerOne = temp;
        } else {
            playerTwo = temp;
        }
    }

    /**
     * Set the name for the player using the passed in values.
     *
     * @param num  The player's number (1 or 2)
     * @param name The name to assign to the player.
     */
    public void setPlayerName(int num, String name) {
        if (num == 1) {
            playerOne.setName(name);
        } else {
            playerTwo.setName(name);
        }
    }

    /**
     * Set the color for a player using the passed in value.
     *
     * @param num   The player's number (1 or 2)
     * @param color The color to assign to the player.
     */
    public void setPlayerColor(int num, Color color) {
        if (num == 1) {
            playerOne.setColor(color);
        } else {
            playerTwo.setColor(color);
        }
    }

    /**
     * This method ends the game in a draw, alerting both players
     * that the draw has taken place
     */
    public void endInDraw(Player player) {
        // Calls endOfGame with a message that game ended in a draw.
        endGame(player.getName() + "'s draw offer was accepted. \n\n"
                + "Game ended in a draw.");
    }

    /**
     * This method is called if a draw has been offered
     *
     * @param the player who offered the draw
     */
    public void drawOffered(Player player) {

        if (player.getNumber() == playerOne.getNumber()) {
            playerTwo.acceptDraw(player);
        } else if (player.getNumber() == playerTwo.getNumber()) {
            playerOne.acceptDraw(player);
        }

    }

    /**
     * The offer for a draw has been made.  This method declines
     * that offer, meaning the game will continue.
     *
     * @param player The player declining the draw.
     */
    public void declineDraw(Player player) {
        if (gameType == Facade.GameType.LOCAL_GAME) {
            player.endInDeclineDraw(player);
        } else {
            playerOne.endInDeclineDraw(player);
            playerTwo.endInDeclineDraw(player);
        }
    }

    /**
     * Ends the game as a result of a player quitting, notifying
     * each player
     *
     * @param player player who quit
     */
    public void endInQuit(Player player) {
        playerOne.endOfGame(player.getName() + " quit the game");
        playerTwo.endOfGame(player.getName() + " quit the game");
    }

    /**
     * This method creates the timer to be used, if one is desired
     * to be used. It will also set the number of seconds for each
     * turn.
     *
     * @param time    : the number of seconds for each turn
     * @param warning : whether or not a player will be warned
     *                that their turn is going to end
     */
    public void setTimer(int time, int warning) {
        // If values are negative, set runningTimer to false
        // If they are positive values, create the Timer and
        // notifier with the times

        if (time < 0) {
            runningTimer = false;
        } else {
            runningTimer = true;
            theTimer = new Timer();
        }

    }

    /**
     * This method sets the colors of pieces that each player
     * will be
     */
    private void selectColors() {
        // Randomly select color for each player and call the
        // setColor() method of each
        if (Math.random() > .5) {
            playerOne.setColor(Color.blue);
            playerTwo.setColor(Color.white);
        } else {
            playerOne.setColor(Color.white);
            playerTwo.setColor(Color.blue);
        }
    }

    /**
     * This method will start the game play. Letting the first person
     * move their piece and so on
     */
    public void startGame() {
        selectColors();
        network.start(playerOne, playerTwo);

        // Tell player with the correct color to make a move
        if (playerOne.getColor() == Color.white) {
            activePlayer = playerOne;
            passivePlayer = playerTwo;
        } else {
            activePlayer = playerTwo;
            passivePlayer = playerOne;
        }

        facade.setPlayerModes(activePlayer, passivePlayer);
    }

    /**
     * This method sets the host the player will play against in case of
     * a game over a network.
     *
     * @param host the host of the game to be played
     */
    public void setHost(URL host) {
        // Call connectToHost in player two with the URL
        network.setHost(playerOne, host);
        network.setHost(playerTwo, host);
    }

    /**
     * Return the player whos turn it is not
     *
     * @return the player whose turn it is not
     */
    public Player getOppositePlayer() {
        // Returns the player whos getTurnStatus is false
        return passivePlayer;
    }

    /**
     * Select the type of game
     * @param newMode Mode (0 local, 1 host, 2 client) of the game
     */
    public void setGameMode(Facade.GameType newMode) {
        // Set the value of mode
        gameType = newMode;
    }

    /**
     * Return the integer representing the type of game
     *
     * @return Type of game
     */
    public Facade.GameType getGameMode() {
        return gameType;
    }
}
