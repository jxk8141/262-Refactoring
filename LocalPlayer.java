/**
 * LocalPlayer.java
 *
 * Version:
 *   $Id: LocalPlayer.java,v 1.1 2002/10/22 21:12:52 se362 Exp $
 *
 * Revisions:
 *   $Log: LocalPlayer.java,v $
 *   Revision 1.1  2002/10/22 21:12:52  se362
 *   Initial creation of case study
 *
 */

import java.awt.*;
import javax.swing.*;

/**
 *  This class inherits from the player. 
 *  This class identifies that the local player 
 *  is the second player in the game.
 *
 *  @author
 */

public class LocalPlayer extends Player {
    
    /**
     * This is a default constructor for this object
     */
    public LocalPlayer( int num, Rules rules, Driver theDriver ){
	super( num, rules, theDriver );
	type = Player.PlayerType.LOCALPLAYER;
    }

    public LocalPlayer(Builder builder){
		super( builder.getNum(), builder.getRules(), builder.getDriver());
		type = PlayerType.LOCALPLAYER;
	}
    
    /**
     * When the current player clicks the draw button, this method 
     * is called in the opposite player to inform them that a draw 
     * has been offered. An actionEvent is generated to let the GUI 
     * know.
     */
    public void offerDraw( Player player ){
	theDriver.drawOffered( this );
    }
    
    /**
     * When the current player accepts a draw, this method is called 
     * in the opposite player to inform them that the draw has been 
     * accepted.  An actionEvent is generated to let the GUI know and 
     * endGame is called in theDriver.
     */
    public void acceptDraw( Player player ){
	
	int selected = JOptionPane.showConfirmDialog( null, player.getName()
		   	      + " has requested a draw."
	       		      + "\n\nWill you agree to a"
	      		      + " draw?",
	       		      "Draw offer",
	     	       	      JOptionPane.YES_NO_OPTION );
	
	if ( selected == JOptionPane.YES_OPTION ) {
	    theDriver.endInDraw( player );
	} else if ( selected == JOptionPane.NO_OPTION ) {
	    theDriver.declineDraw( player );
	} else {
	    theDriver.declineDraw( player );
	}
    }
    
    /**
     *  Method is invoked if the other player declines a draw.
     */
    public void endInDeclineDraw( Player player ){
	
	JOptionPane.showMessageDialog( null,
       	            player.getName() + " has declined the draw offer."
                    + "\n\nClick OK to continue the game.",
	            "Draw declined",
	            JOptionPane.INFORMATION_MESSAGE );
	
    }
    
    /**
     * Method that is invoked when the end of game conditions have 
     * been met.  Fire off an action event to tell the GUI to display 
     * endMessage in a dialogue box.  When the user clicks OK, call 
     * endGame in theDriver.
     *
     * @param endMessage  Message indicating the end of the game.
     */
    public void endOfGame( String endMessage ){
	
	JOptionPane.showMessageDialog( null,
               "Game has ended because: "
       	       + endMessage,
       	       "Game Over",
	       JOptionPane.INFORMATION_MESSAGE );
	
	System.exit( 0 );
	
    }
    
    /**
     * Method that is invoked when the end of game conditions have 
     * been met.  If they have been, this method is called in both 
     * players to notify them of this with a message.  Implementation 
     * differs for local player and network player.
     *
     * @param endMessage  Message indicating the end of the game.
     */
    public void endInDraw( Player player ){
	
	// This display end of game dialog telling that a game has 
	// ended in a draw
	JOptionPane.showMessageDialog( null,
       	       player.getName() + " accepted a draw."
	       + "\n\nClick OK to end the program.",
      	       "Game Over",
               JOptionPane.INFORMATION_MESSAGE );
	
	System.exit( 0 );
    }
    
}//LocalPlayer.java

