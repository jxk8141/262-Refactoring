/**
 * Board.java
 *
 * Version:
 *     $Id: Board.java,v 1.1 2002/10/22 21:12:52 se362 Exp $
 *
 * Revisions:
 *     $Log: Board.java,v $
 *     Revision 1.1  2002/10/22 21:12:52  se362
 *     Initial creation of case study
 *
 */
import java.util.*;
import java.awt.*;


/**
 *  This class represents the board on which checkers is being played.
 *  The board holds a collection of pieces.
 *
 *  @invariant all variables have valid values
 *
 *  @author
 */
public class Board {

   private Piece pieces[]; // the pieces that are on the board
   public static int SINGLE = 0;
   public static int KING = 1;


   /**
    * This constructor creates a new board at the beginning of the game
    */

   public Board() {
  
	   // create a array of size 64, generate piece objects and
	   // put them in the correct location in the array
	   // Set the values of numWhites and numBlues to 12 each
	   pieces = new Piece[64];

	   // create blue pices
	   pieces[1] = new SinglePiece( Color.blue );
	   pieces[3] = new SinglePiece( Color.blue );
	   pieces[5] = new SinglePiece( Color.blue );
	   pieces[7] = new SinglePiece( Color.blue );
	   pieces[8] = new SinglePiece( Color.blue );
	   pieces[10] = new SinglePiece( Color.blue );
	   pieces[12] = new SinglePiece( Color.blue );
	   pieces[14] = new SinglePiece( Color.blue );
	   pieces[17] = new SinglePiece( Color.blue );
	   pieces[19] = new SinglePiece( Color.blue );
	   pieces[21] = new SinglePiece( Color.blue );
	   pieces[23] = new SinglePiece( Color.blue );

	   // create the white pieces
	   pieces[40] = new SinglePiece( Color.white );
	   pieces[42] = new SinglePiece( Color.white );
	   pieces[44] = new SinglePiece( Color.white );
	   pieces[46] = new SinglePiece( Color.white );
	   pieces[49] = new SinglePiece( Color.white );
	   pieces[51] = new SinglePiece( Color.white );
	   pieces[53] = new SinglePiece( Color.white );
	   pieces[55] = new SinglePiece( Color.white );
	   pieces[56] = new SinglePiece( Color.white );
	   pieces[58] = new SinglePiece( Color.white );
	   pieces[60] = new SinglePiece( Color.white );
	   pieces[62] = new SinglePiece( Color.white );

   }

   

   /**
    * Move the piece at the start position to the end position
    * 
    * @param start - current location of the piece
    * @param end - the position where piece is moved
    * 
    * @return -1 if there is a piece in the end position
    */
   public int movePiece(int start, int end) {


	   int returnValue = 0;	

	   // check if the end position of the piece is occupied
	   if( occupied( end ) ) {
	   	
	   	   // if it is return -1
	   	   returnValue = -1;


	   // if it is not set a start position in the array to null
	   // put a piece object at the end position in the array
	   // that was at the start positon before
	   } else {
	   	
		   pieces[end] = pieces[start];
		   pieces[start] = null;


	   }

	   return returnValue;

   }

   

   /**
    * This method checks if the space on the board contains a piece
    * 
    * @param space - the space that needs to be checked
    * 
    * @return true or false depending on the situation
    */
   public boolean occupied(int space) {

	   boolean returnValue = true;

	   // if it's in the bounds of the array,
	   	   // return true if the space is occupied
	   	   // false if the space is empty
	   // if it's outside the bounds of the array,
	   	   // return true
           
	   if ( space >= 1 && space <= 63 && pieces[space] == null ) {
	   	   returnValue = false;
	   }
	   
	   return returnValue;
	   
   }

   
   /**
    * This method removes piece at the position space
    * 
    * @param space - the positon of the piece to be removed
    */
   public void removePiece(int space) {
   
	   // go to the space position in the array
	   // set it equal to null
	   
	   pieces[ space ] = null;

   }
   
   
   /**
    * This method creates a king piece 
    * 
    * @param space - the psotion at which the king piece is created 
    */
   public void kingPiece(int space) {
   
	   // create a new king piece
	   // go to the space position in the array and place it there
	   // if the position is not ocupied
	   Color color = pieces[space].getColor();
	   Piece piece = new KingPiece( color );
	   pieces[space] = piece;
	   
   }
   
   
   /**
    * This method returns the color of the piece at a certain space
    * 
    * @param space - the position of the piece on the board
    * 
    * @return the color of this piece
    */
   public Color colorAt(int space) {
	   
	   Color returnValue = null;
	   // go to the space position in the array
	   // check if there is a piece at that position
	   // if there is none, return null
	   // else retrun the color of the piece
	   
	   if( occupied( space ) ) {
		   
		   returnValue = pieces[space].getColor();
		   
	   }
   
       return returnValue;
	   
   }
   

   /**
    * This method returns the piece at the certain position
    * 
    * @param space - the space of the piece
    * 
    * @return the piece at that space
    */
   public Piece getPieceAt(int space) {

	   Piece returnValue = new SinglePiece(Color.red);
	   
	   try{
	   	   // check if there is piece at space position
	   	   // if there is none, return null
	   	   // else return the piece at that position
	   
	      if( occupied(  space ) ) {
		   
	   	   	   returnValue = pieces[space];
                           
	   	   }
	   
	   } catch( ArrayIndexOutOfBoundsException e ) {
	   
                          
	   } catch( NullPointerException e ) {
	   	
           
	   }
	   
      return returnValue;
	   
   }
   
   
   
   /**
    * This method returns if there is a piece of color on the board
    * 
    * @param color - the color of the piece
    * 
    * @return true if there is a piece of color left on the board
    *				else return false	
    */
   public boolean hasPieceOf( Color color) {
   	

	   boolean returnValue = false;

	   // go through the whole array
	   // if there is a piece of color in the arrar return true
	   // else return false
	   for( int i =1; i < pieces.length; i++ ) {
		   
	   	   if( pieces[i] != null && pieces[i].getColor() == color ) {

                  
	   	   	   	   returnValue = true;
	   	   	   	   i = pieces.length;
	   	   	   }
	   }

           
      return returnValue;
	   
   }
   

   /**
    * This method returns the size of the board
    * 
    * @return the size of the board, always 64
    */
   public int sizeOf() {
       return 64;
   }
   
   
   
   /**
    * This method returns a vector containing all blue Pieces
    * 
    * @return blue pieces on the board
    */
   public Vector bluePieces() {
   
      Vector bluePieces = new Vector();
      
      for ( int i = 0; i < 64; i++ ) {
          if ( occupied( i ) ) {
              if ( pieces[ i ].getColor() == Color.blue ) {
                  bluePieces.addElement( pieces[ i ] );
              }
          }                 
      }
      
      return bluePieces;
      
  }
 
 
   /**
    * This method returns a vector containing all white Pieces
    * 
    * @return white pieces on the board
    */
  public Vector whitePieces() {
      
      Vector whitePieces = new Vector();
      
      for ( int i = 0; i < 64; i++ ) {
          if ( occupied( i ) ) {
              if ( pieces[ i ].getColor() == Color.white ) {
                  whitePieces.addElement( pieces[ i ] );
              }
          }                 
      }
      
      return whitePieces;
 }
 
}//Board

