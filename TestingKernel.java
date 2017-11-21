/**
 * TestingKernel.java
 *
 * Created on February 8, 2002, 1:09 PM
 *
 * Version:
 *   $Id: TestingKernel.java,v 1.1 2002/10/22 21:12:53 se362 Exp $
 *
 * Revisions:
 *   $Log: TestingKernel.java,v $
 *   Revision 1.1  2002/10/22 21:12:53  se362
 *   Initial creation of case study
 *
 */
                                      
// Not all of these are probably necessary.
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

/**
 *  This class is the system's Testing Kernel.  For now it is hard 
 *  coded, sequential tests that will be performed.
 *
 *  It tests the system and how it responds to such things as basic 
 *  moves/jumps, illegal values, and illegal moves/jumps.
 *
 *  All results will be outputted about pass/fail on the tests.
 *
 * @author
 * @version
 */
public class TestingKernel extends java.lang.Object{
    // The facade that we will manipulate and interact with.
    public Facade testFacade;

    // The driver that this program needs to call
    public Driver theDriver;
    
    // The board that we will use to check the state of the pieces with.
    public Board  testBoard;
    
    // Initial values that will be used in this program.
    public int    testTime  = 250;
    public String playerOne = "Joe";
    public String playerTwo = "Bob";
     
    /**
     * The main method.  
     * 
     * Create a new instance of the driver and then create an instance
     * of kernel, pass it that driver, and start the program from there.
     *
     * @param args Array of command line arguments. 
     */
    public static void main( String args[] ){
        // Create the driver
        Driver sampleDriver = new Driver();
        
        // Create the instance of the testing kernel.
        // Pass to it as a parameter the driver you just made.
        // This is turn should begin execution of the program.
        TestingKernel tester = new TestingKernel( sampleDriver );
    }
    
    /**
     * The constructor for this kernel which calls the other methods.
     *
     * @param aFacade The facade to manipulate in this program.
     */
    public TestingKernel( Driver aDriver ){
        //testFacade = aFacade;
        theDriver  = aDriver;
        testFacade = theDriver.getFacade();
                
        // Call the needed methods.
        setBegin();
        beginTests();
    }
    
    /**
     * Set the state of the game to initial settings.
     *
     * i.e., a generously timed local game for which to test.
     */
    public void setBegin(){
        
        try{
            // Set this game to be a local game.
            testFacade.setGameMode( testFacade.LOCALGAME );
        
            // Create players
            // createPlayer(int num, int type, String name)
            theDriver.createPlayer( 1, Player.LOCALPLAYER, playerOne );
            theDriver.createPlayer( 2, Player.LOCALPLAYER, playerTwo );
            
            // Set the names for the players.
            testFacade.setPlayerName( 1, playerOne );
            testFacade.setPlayerName( 2, playerTwo );
        
            // Give a generous time.  At this point, it will allow 
            // adequate time for this program to run, but perform a 
            // basic test on the timer.
            testFacade.setTimer( testTime, ( testTime/2 ) );
        
            //Start the game.
            testFacade.startGame();
            
        }catch( Exception e ){
            System.err.println( e.getMessage() );
        }
    }
    
    /**
     * Tests the intial values, then call the other methods.
     *
     * Handles the reporting of the results.
     */
    public void beginTests(){
        // Bool to keep track whether or not it passed the current test.
        boolean passedTest = false;
        
        // Test that it correctly set the initial values correctly.
        // Player One's Name
        passedTest = playerOne.equals( testFacade.getPlayerName( 1 ) );
        report( passedTest, "Sets Player One name", 3 );
  
        // Player Two's Name
        passedTest = playerTwo.equals( testFacade.getPlayerName( 2 ) );
        report( passedTest, "Sets Player Two name", 3 );
        
        // The Timer.
        passedTest = ( testTime == testFacade.getTimer() );
        report( passedTest, "Sets Timer", 4 );
               
        // These are intended to run in succession.  So pieces are assumed
        // to be positioned based on previous tests.  You must take note
        // of that.
        
        // Check basic moves.
        System.out.println( "Testing Basic Moves...." );
        passedTest = testBasicMoves();
        report( passedTest, "Performs Basic Moves", 3 );
                
        // Test bounds
        System.out.println( "Testing the Bounds of the board..." );
        passedTest = testBounds();
        report( passedTest, "Checks Bounds", 4 );
                
        // Test forced jumps
        System.out.println( "Testing Forced Jumps..." );
        passedTest = testForcedJump();
        report( passedTest, "Forces Jumps", 4 );
                
        // Test multiple jumps
        System.out.println( "Testing that it allows mult. jumps..." );
        passedTest = testMultJumps();
        report( passedTest, "Allows Multiple Jumps", 3 );
                
        // Test Invalid moves.
        System.out.println( "Testing invalid moves..." );
        passedTest = testInvalidMoves();
        report( passedTest, "Checks Invalid Moves", 3 );
                
        // Test offering a draw.
        // System.out.println( "Testing that if offers draw..." );
        // passedTest = testDraw();
        // report( passedTest, "Offers Draw", 3 );
        
        System.out.println( "\n" + "Testing has completed." );
    }
    
    /**
     * Test basic moves made by the checkers.  This  does not 
     * tests jumps or invalid moves.
     *
     * @return Whether or not it passed.
     */
    public boolean testBasicMoves(){
        // Boolean for whether or not it passed the test.
        boolean basMoveTest = true;        
   
        //Find out who has control of the board.
        int turn = testFacade.whosTurn();
        
        // Since game should be in initial state, make a valid, simple 
        // move.  Red goes first, so move one of their pieces.
        System.out.println( "Attempting move: 19 to 26" );
        testFacade.selectSpace( 19 );
        testFacade.selectSpace( 26 );
        
        // Stick in a manual wait to allow for enough time for the board
        // to be updated before calling it.  
        simpleWait();
                
        // Get a copy of the board object to check its state.           
        testBoard = testFacade.stateOfBoard();

        // Make the proper calls to make sure the pieces are now 
        // in the correct location and have been removed from their 
        // previous spots.
        if ( testBoard.occupied( 19 ) ){ 
            basMoveTest = false;
            System.out.println( "Did not remove the piece from 19." );
        }
        
        if( !testBoard.occupied( 26 ) ){
            basMoveTest = false;
            System.out.println( "Did not move the piece to 26." );
        }
                       
        // Make sure it is now the other player's turn.
        if( turn == testFacade.whosTurn() ){
            System.out.println( "Did not end turn correctly." );
            basMoveTest = false;
        }

        return basMoveTest;
    }
    
    /**
     * This method will attempt to make moves with out of bound values
     * to ensure the system detects these without throwing an 
     * OutOfBounds Exception.
     *
     * It will also test that the system detects making a
     * move with the same start and end positions.
     *
     * @return Whether or not it passed the test.
     */
    public boolean testBounds(){
        // Boolean for whether or not it passed the test.
        boolean boundaryTest = true;          
        
        //Find out who has control of the board.
        int turn = testFacade.whosTurn();
        
        // The pieces should be in these locations.
        // Attempt to make a move with an out of bounds end location.
        System.out.println( "Attempting move: 46 to 112" );
        testFacade.selectSpace( 46 );
        testFacade.selectSpace( 112 );
        
        // Get a copy of the board object to check its state.           
        simpleWait();
        
        testBoard = testFacade.stateOfBoard();
                
        // Piece should not have moved.  Control of the board should be
        // retained.  Check for those conditions.
        if( !testBoard.occupied( 46 ) ){ 
            System.out.println( "Incorrectly removed piece from 46." );
            boundaryTest = false; 
        }
                
        if( turn != testFacade.whosTurn() ){ 
            System.out.println( "Prematurely ended turn." );
            boundaryTest = false; 
        }
                             
        return boundaryTest;
    }
    
    /**
     * Tests for the following:  A jump is possible.  The player attempts 
     * to move elsewhere.  System must not allow move and keep state 
     * unchanged.
     *
     * @return Whether or not it passed the test.
     */
    public boolean testForcedJump(){
        // Boolean for whether or not it passed the test.
        boolean forceJumpTest = true;        
        
        // Find out who has control of the board.
        // Should be the same as the last test.
        int turn = testFacade.whosTurn();
        
        // Position the pieces to where necessary.
        System.out.println( "Attempting move: 40 to 33" );
        testFacade.selectSpace( 40 );
        testFacade.selectSpace( 33 );
               
        //Attempt to make a move which is not the forced jump.
        turn = testFacade.whosTurn();
        System.out.println( "Attempting move: 26 to 35" );
        testFacade.selectSpace( 26 );
        testFacade.selectSpace( 35 );
        
        // Piece should not have moved and control should be retained.
        simpleWait();
            
        testBoard = testFacade.stateOfBoard();
        
        if(!testBoard.occupied( 26 ) ){
            System.out.println( "Incorrectly removed piece from 26." );
            forceJumpTest = false;
        }
        
        if( turn != testFacade.whosTurn() ){ forceJumpTest = false; }
                
        // Now make the jump and check that the pieces have been 
        // moved/removed correctly.
        System.out.println( "Attempting move: 26 to 40" );
        testFacade.selectSpace( 26 );
        testFacade.selectSpace( 40 );
        
        simpleWait();
              
        testBoard = testFacade.stateOfBoard();
        
        if( testBoard.occupied( 26 ) ){
            System.out.println( "Did not move piece from 26." );
            forceJumpTest = false;
        }else if( testBoard.occupied( 33 ) ){
            System.out.println( "Did not removed jumped piece from 33." );
            forceJumpTest = false; 
        }else if( !testBoard.occupied( 40 ) ){ 
            System.out.println( "Did not move piece to 40." );
            forceJumpTest = false;
        }
        
        // Control should be turned over.  Check for that.
        if( turn == testFacade.whosTurn() ){ 
            System.out.println( "Did not end turn correctly." );
            forceJumpTest = false; 
        }
        
        return forceJumpTest;
    }
    
    /**
     * When multiple jumps are present, this tests that they are forced
     * and that the correct player keeps control of the game.
     *
     * @return Whether or not it passed the test.
     */
    public boolean testMultJumps(){
        // Boolean for whether or not it passed the test.
        boolean multJumpTest = true;        
        
        /** 
         * A high number of moves must be made for this to be set up.
         * A diagram was made to figure out this sequence.  It is:
         *
         * For now, I'm just assuming that this is all valid.
         */
        System.out.println( "Setting pieces to attempt mult. jump" );
        System.out.println( "Attempting move: 46 to 39" );
        testFacade.selectSpace( 46 );
        testFacade.selectSpace( 39 );
        simpleWait();
            
        System.out.println( "Attempting move: 23 to 30" );
        testFacade.selectSpace( 23 );
        testFacade.selectSpace( 30 );
        simpleWait();
            
        System.out.println( "Attempting move: 42 to 35" );
        testFacade.selectSpace( 42 );
        testFacade.selectSpace( 35 );
        simpleWait();
            
        System.out.println( "Attempting move: 14 to 23" );
        testFacade.selectSpace( 14 );
        testFacade.selectSpace( 23 );
        simpleWait();
            
        System.out.println( "Attempting move: 51 to 42" );
        testFacade.selectSpace( 51 );
        testFacade.selectSpace( 42 );
        simpleWait();
            
        System.out.println( "Attempting move:  7 to 14 " );
        testFacade.selectSpace( 7 );
        testFacade.selectSpace( 14 );
        simpleWait();
            
        System.out.println( "Attempting move: 60 to 51" );
        testFacade.selectSpace( 60 );
        testFacade.selectSpace( 51 );
        simpleWait();
            
        System.out.println( "Attempting move: 21 to 28" );
        testFacade.selectSpace( 21 );
        testFacade.selectSpace( 28 );
        simpleWait();
            
        // All of that should set the stage for a multiple jump.
        // Make the first jump and then check for control of the board.
        // And location of pieces.  Control should not have changed.
        int turn = testFacade.whosTurn();
        
        System.out.println( "Attempting move: 35 to 21" );
        testFacade.selectSpace( 35 );
        testFacade.selectSpace( 21 );
        
        simpleWait();
        testBoard = testFacade.stateOfBoard();
        
        if( testBoard.occupied( 28 ) ){
            System.out.println( "Did not remove piece from 28" );
            multJumpTest = false;
        }else if( !testBoard.occupied( 21 ) ){
            System.out.println( "Did not move piece to 21" );
            multJumpTest = false;
        }
        
        if( turn != testFacade.whosTurn() ){
            System.out.println( "Prematurely ended turn." );
            multJumpTest = false;
        }
        
        // At this point, player should still have control.
        // Make that second jump.
        System.out.println( "Attempting move: 21 to 7" );
        testFacade.selectSpace( 21 );
        testFacade.selectSpace( 7  );
        
        // Check that the pieces have been moved/removed
        // and that control has changed hands.
        simpleWait();
        testBoard = testFacade.stateOfBoard();
        
        if( testBoard.occupied( 14 ) ){
            System.out.println( "Did not remove piece from 14." );
            multJumpTest = false;
        }else if( !testBoard.occupied( 7 )){
            System.out.println( "Did not move piece to 7." );
            multJumpTest = false;
        }
        
        if( turn == testFacade.whosTurn() ){
            System.out.println( "Did not end turn correctly." );
            multJumpTest = false;
        }
                   
        return multJumpTest;
    }
    
    /**
     * Testing of a variety of invalid moves.
     *
     * @return Whether or not it passed the test.
     */
    public boolean testInvalidMoves(){
        // Boolean for whether or not it passed the test.
        boolean invMoveTest = true;        
        
        int turn = testFacade.whosTurn();
        
        // Test that it doesn't allow you to make a move with
        // the same starting and endling location.
        System.out.println( "Try move with " +
            "same start and end location." );
        System.out.println( "Attempting move: 23 to 23" );
        testFacade.selectSpace( 23 );
        testFacade.selectSpace( 23 );
        
        simpleWait();
        testBoard = testFacade.stateOfBoard();
        
        if( !testBoard.occupied( 23 ) ){
            System.out.println( "Incorrectly removed piece from 23." );
            invMoveTest = false;
        }
        if( turn != testFacade.whosTurn() ){
            System.out.println( "Prematurely ended turn." );
            invMoveTest = false;   
        }
        
        // Test that it doesn't allow you to move to a space
        // occupied by another one of your pieces.
        System.out.println( "Trying to move to occupied spot." );
        System.out.println( "Attempting move: 8 to 17" );
        testFacade.selectSpace( 8 );
        testFacade.selectSpace( 17 );
        
        simpleWait();
        testBoard = testFacade.stateOfBoard();
        
        if( !testBoard.occupied( 8 ) ){
            System.out.println( "Incorrectly removed piece from 8" );
            invMoveTest = false;
        }
        if( turn != testFacade.whosTurn() ){
            System.out.println( "Prematurely ended turn." );
            invMoveTest = false;   
        }   
        
        // Test that it does not allow you to jump over one
        // of your own pieces.
        System.out.println( "Trying to jump one of your own pieces." );
        System.out.println( "Attempting move: 1 to 19" );
        testFacade.selectSpace( 1 );
        testFacade.selectSpace( 19 );
        
        simpleWait();
        testBoard = testFacade.stateOfBoard();
        
        if( !testBoard.occupied( 1 ) ){
            System.out.println( "Incorrectly moved piece from 1" );
            invMoveTest = false;
        }else if( !testBoard.occupied( 10 ) ){
            System.out.println( "Incorrectly removed piece from 10." );
            invMoveTest = false;
        }else if( testBoard.occupied( 19 ) ){
            System.out.println( "Incorrectly moved piece to 19." );
            invMoveTest = false;
        }
        
        // Control of the board should not have changed.
        if( turn != testFacade.whosTurn() ){
            System.out.println( "Ended turn prematurely." );
            invMoveTest = false;   
        }
     
        // Test that it doesn't allow any invalid moves to a 
        // "random" spot on the board.
        System.out.println( "Trying to move to random location. " );
        System.out.println( "Attempting move: 5 to 37" );
        testFacade.selectSpace( 5 );
        testFacade.selectSpace( 37 );
        
        simpleWait();
        testBoard = testFacade.stateOfBoard();
        
        if( !testBoard.occupied( 5 ) ){
            System.out.println( "Incorrectly moved piece from 5." );
            invMoveTest = false;
        }else if( testBoard.occupied( 37 ) ){
            System.out.println( "Incorrectly moved piece to 37." );
            invMoveTest = false;
        }
        
        // Control of the board should not have changed.
        System.out.println( "Prematurely ended turn." );
        if( turn != testFacade.whosTurn() ){
            invMoveTest = false;   
        }
        
        // Test that it does not allow a single piece to move
        // in the wrong direction.
        System.out.println( "Trying to move backwards." );
        System.out.println( "Attempting move: 40 to 33" );
        testFacade.selectSpace( 40 );
        testFacade.selectSpace( 33 );
        
        simpleWait();
        testBoard = testFacade.stateOfBoard();
       
        if( !testBoard.occupied( 40 ) ){
            System.out.println( "Incorrectly moved piece from 40." );
            invMoveTest = false;
        }else if( testBoard.occupied( 33 ) ){
            System.out.println( "Incorrectly moved piece to 33." );
            invMoveTest = false;
        }
        
        // Control of the board should not have changed.
        if( turn != testFacade.whosTurn() ){
            System.out.println( "Ended turn prematurely" );
            invMoveTest = false;   
        }
        
        // After all of that, make a simple, valid move to ensure it
        // allows it and changes over control of the board.
        System.out.println( "Now attempt to make a simple" +
            ", valid move." );
        System.out.println( "Attempting move: 10 to 19" );
        testFacade.selectSpace( 10 );
        testFacade.selectSpace( 19 );
        
        simpleWait();
        testBoard = testFacade.stateOfBoard();
      
        if( !testBoard.occupied( 19 ) ){
            System.out.println( "Did not move piece to 19." );
            invMoveTest = false;
        }else if( testBoard.occupied( 10 ) ){
            System.out.println( "Did not move piece from 10." );
            invMoveTest = false;
        }
            
        // Control of the board should have changed.
        if( turn == testFacade.whosTurn() ){
            System.out.println( "Did not end turn correctly. " );
            invMoveTest = false;   
        }   
        
        return invMoveTest;
    }
    
    /**
     * Tests the actions of the GUI and checks to see that both players 
     * may offer draws and accept/decline.
     */
    public boolean testDraw(){
        // Boolean for whether or not it passed the test.
        boolean drawTest = true;        
        
        return drawTest;
    }
    
    /**
     * This method is for reporting.  It outputs the name of the test
     * and a Pass/Fail value along side of the test name.
     *
     * @param passFail Bool on whether or not test was passed.
     * @param name     Name of test.
     * @param tabs     The number of tabs to insert
     */
    public void report( boolean passFail, String name, int tabs ){
        // String representation of whether or not the test was passed.
        String success;
        
        // Assign a value.
        if( passFail ){
            success = "passed";
        }else{
            success = "FAILED!!!";
        }
        
        // Report the results.
        System.out.print( name + ":" );
        
        for( int i = 0; i < tabs; i++ ){
            System.out.print( "\t" );
        }
        
        System.out.print( success + "\n" + "\n" );
    }

    /**
     * This method is a generic way to put in place 
     * an artificial wait into the program.
     * This allows for the program to have a delay without 
     * having to implement anything such as Runnable.
     */
    public void simpleWait(){
        for( int i = 0; i < 2500; i++ ){
            // not the best way for a delay
            // but it allows a wait without 
            // having to deal with threads.
        }
    }
    
} // TestingKernel.java