/**
 * Move.java
 *
 * Version:
 *    $Id: Move.java,v 1.1 2002/10/22 21:12:52 se362 Exp $
 *
 * Revisions:
 *    $Log: Move.java,v $
 *    Revision 1.1  2002/10/22 21:12:52  se362
 *    Initial creation of case study
 *
 */

import java.util.*;
import java.io.*;

/**
 * An object representation of a move.
 *
 * @author
 */
 public class Move {
	 
	private int startingLocation;	// the starting location
	private int endingLocation;	// the ending location

	/**
	 *  The player that this move is intended for.
	 */
	public Player thePlayer;

     
	/**
	 * Create a move with the starting location and 
	 * ending location passed in as paremeters.
	 *	
	 * @param startLoc The starting point of the move
	 * @param endLoc   The ending point of the move
	 * 
	 * @pre startLoc and endLoc are valid locations
	 */
	public Move( Player player, int startLoc, int endLoc ) {
	
		thePlayer = player;
		startingLocation = startLoc;
		endingLocation = endLoc;
	}

     
	/**
	 * Return the player who made this move
	 * 
	 * @return the player who made this move
	 * 
	 * @post nothing has changed 
	 * 
	 */
	public Player getPlayer() {
		return thePlayer;
	}

     
	/**
	 * Return the starting location of this move.
	 *
	 * @return The starting point of the move.
	 * 
	 * @post nothing has changed
 	 */
	public int startLocation() {
	
		return startingLocation;
	}

     
	/**
	 * Return the ending location of this move.
	 *
	 * @return The ending point of this location.
	 * 
	 * @post Nothing has changed
	 */
	public int endLocation() {
		
		return endingLocation;
	}
     
} //Move.java
