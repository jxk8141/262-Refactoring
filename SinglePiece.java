/**
 * SinglePiece.java
 *
 * Version:
 *   $Id: SinglePiece.java,v 1.1 2002/10/22 21:12:53 se362 Exp $
 *
 * Revisions:
 *   $Log: SinglePiece.java,v $
 *   Revision 1.1  2002/10/22 21:12:53  se362
 *   Initial creation of case study
 *
 */

import java.awt.*;
import java.util.*;

/**
 * This is a class representing a single piece (a piece that has not been
 * kinged yet)
 *
 * @author
 *
 */
public class SinglePiece extends Piece {
	
	
   private static int SINGLE = 0; // this is a single type
   private int type; // the type of the piece
   
   /**
    * This constructor creates a single piece checker object
    * 
    * @param c - the color of this single piece
    * @param pc - the possible captures of this single piece
    * @param pm - the possible moves of this single piece
    */
   public SinglePiece( Color c  ) {
 
	    super( c );
		type = SINGLE;
   }
   
   /**
    * This method returns that the type of the checker is single
    * 
    * @return type which is 0 for single
    */
   public int getType() {
 
	   return type;
   }
   
}// SinglePiece
