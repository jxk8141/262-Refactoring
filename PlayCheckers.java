/*

 * PlayCheckers.java

 *

 * 

 * Version:

 *   $Id: PlayCheckers.java,v 1.1 2002/10/22 21:12:53 se362 Exp $

 *

 * Revisions:

 *   $Log: PlayCheckers.java,v $
 *   Revision 1.1  2002/10/22 21:12:53  se362
 *   Initial creation of case study
 *
 */


/**
 *
 * The main class to run the game. It creates the driver and first screen
 *
 * @author
 *
 */
class PlayCheckers{
	
	/*
	* The main method to play checkers
	*
	*@param args[] the command line arguments
	* 
	*/
	
    public static void main( String args[] ){
	
	
	Driver theDriver = new Driver();
	
	Firstscreen first = new Firstscreen( theDriver.getFacade() );
	first.show();
	
    }
    
}//PlayCheckers
