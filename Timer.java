/**
 * Timer.java
 *
 * Version:
 *    $Id: Timer.java,v 1.1 2002/10/22 21:12:53 se362 Exp $
 *
 * Revisions:
 *    $Log: Timer.java,v $
 *    Revision 1.1  2002/10/22 21:12:53  se362
 *    Initial creation of case study
 *
 */

/**
 *  This timer runs on the separate thread and during
 *  the simulation tells fasade to update the warning and normal times 
 *
 *  @invariant all variables have valid values
 *
 *  @author
 */

public class Timer extends Thread{

    private static int INTERVAL = 100;    
    private int      interval;
    private Notifier notifier;
    
    /**
     * This constaructor creates a new timer
     */    
    public Timer(){
	notifier = new Notifier( notifier.TIME_UPDATE );
	interval = INTERVAL;
    }
    
    /**
     * This constructor creates a timer with an interval
     *
     * @param inter - the new interval
     */
    public Timer( int inter ){
	notifier = new Notifier( notifier.TIME_UPDATE );
	interval = inter;
    }
    
    /**
     * This method is what executes then the thread
     * has been started
     * 
     * @roseuid 3C5AE02D03DE
     */
    public void run() {
	// Start the timer thread 
	// Notify the facade every interval
	while ( true ) {
	    try {
		sleep( interval );
	    }
	    catch ( InterruptedException e ) {
		System.err.println( "The timer malfunctioned." );
	    }
	    
	    notifier.generateActionPerformed();
	}
    }
    
    /**
     * Get the notifier.
     * 
     * @return Notifier
     * @roseuid 3C5AE4FD00C1
     */
    public Notifier getNotifier(){
	return notifier;
    }
    
}// Timer.java
