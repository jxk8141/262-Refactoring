/**
 * Player.java
 *
 * Version:
 *    $Id: Player.java,v 1.1 2002/10/22 21:12:53 se362 Exp $
 *
 * Revisions:
 *    $Log: Player.java,v $
 *    Revision 1.1  2002/10/22 21:12:53  se362
 *    Initial creation of case study
 *
 */

import java.awt.*;
		   
/**
*  A class representation of the Player object.  This object
*  contains the methods needed when one of the users clicks
*  on one of the buttons within the GUI.
*
*  @author
*/

public abstract class Player {

    public enum PlayerType {
        LOCALPLAYER, NETWORKPLAYER;
    }

    // Instance of the rules class which will be used to
    // validate moves and check for game ending conditions
    // once a move has been made.
    protected Rules  theRules;	

    protected Driver theDriver;
    
    // Instance of the move class which will be
    // created when a user makes a move.
    protected Move   theMove;	
    
    protected int    playerNumber;
    protected String playerName;
    protected Color  playerColor;
    protected PlayerType type;
    
    /**
     * Create a new instance of a Player object to represent
     * one of the users.
     * 
     * @param num       The number of the player.
     * @param newRules  The rules used to validate moves.
     * @param newDriver Driver which will control this.     
     */
    public Player( int num, Rules newRules, Driver newDriver ){
	playerName   = null;
	playerColor  = null;
	playerNumber = num;
	theRules     = newRules;
	theDriver    = newDriver;
    }
    
    /**
     * Return the type of player.
     *
     * @return The type of player.
     */
    public PlayerType getType() {
	return type;
    }
    
    /**
     * Make an istance of a Move that was just made and pass it 
     * to theRules by calling its validateMove method.
     *
     * @param start The starting spot of the move.  The legal 
     *              squares on the checkers boardare numbered 
     *              from 1 to 32, left to right, top to bottom.
     * @param end   The ending spot of the move.  
     *
     * @return true If move was made, false otherwise
     */
    public boolean makeMove( int start, int end ){
	boolean retval = false;
	
	theMove = new Move(this, start, end );
	retval  = theRules.validateMove( theMove );
      
	return retval;
    }
    
    /**
     * This method is used for when a user has clicked on the 
     * "Quit" button on the GUI.  It handles exiting  the game.
     * 
     * @param the player who quit
     * @pre  game is in progress
     * @post message is sent to driver to end the game
     */
    public abstract void endOfGame( String message );
    
    /**
     * When the current player clicks the draw button, this method
     * is called in the opposite player to inform them that a draw 
     * has been offered.  This method is implemented differently for 
     * localPlayer and networkPlayer. 
     * 
     * @param the player who offered the draw
     * @pre a game is in progress
     * @pre a draw has been offered
     */
    public abstract void offerDraw( Player player ); 
    
    /**
     * When the current player accepts a draw, this method is called 
     * in the opposite player to inform them that the draw has been 
     * accepted.  This method is implemented differently for localPlayer 
     * and networkPlayer. 
     * 
     * @pre a game is in progress
     * @pre a draw has been accepted
     */
    public abstract void acceptDraw( Player player );
    
    /**
     *  Method is invoked if the other player declines a draw.
     *  It displays the dialog box for the decline of draw
     */
    public abstract void endInDeclineDraw( Player player );
    
    
    /**
     * Method that is invoked when the end of game conditions have 
     * been met.  If they have been, this method is called in both 
     * players to notify them of this with a message.  Implementation 
     * differs for local player and network player.
     *
     * @param endMessage Message indicating the end of the game.
     */
    public abstract void endInDraw( Player player ); 
   

    /**
     * Returns the number for this player
     * 
     * @pre the player has a number
     * 
     * @return playerNumber
     */
    public int getNumber(){
	return playerNumber;
    }
    
    /**
     * Returns the players name
     * 
     * @pre the player has a name
     * 
     * @return the players name
     */
    public String getName(){
	return playerName;
    }
    
    /**
     * Sets the players name
     * 
     * @param the name to be set
     */
    public void setName( String name ){
	playerName = name;
    }
    
    /**
     * Return the color of this player
     * 
     * @return the color of this player
     */
    public Color getColor() {
	return playerColor;
    }
    
    /**
     * Set the color for this player.
     * 
     * @param newColor The new color for this player.
     */
    public void setColor( Color newColor ){
	playerColor = newColor;
    }
    
    /**
     * A string representation of this object.
     * 
     * @return a String representation of this object.
     */
    public String toString(){
        return ("Player.  name = " + playerName);
    }
    
}//Player.java
