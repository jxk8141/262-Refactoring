/**
 * Notifier.java
 *
 * Version:
 *     $Id: Notifier.java,v 1.1 2002/10/22 21:12:53 se362 Exp $
 *
 * Revisions:
 *     $Log: Notifier.java,v $
 *     Revision 1.1  2002/10/22 21:12:53  se362
 *     Initial creation of case study
 *
 */

import java.awt.*;
import java.awt.event.*;

/**
 *  
 *
 *  @invariant all variables have valid values
 *
 *  @author
 */
public class Notifier extends Component {

    public final static String TIME_UPDATE = "time update";
    String ID;                       // The ID of this object
    ActionListener actionListener;   // registered actionlistener objects
   
    /**
     * Create a new instance of this class to notify other object
     *
     * @param ID the id of this object
     */
    public Notifier( String ID ) {

		this.ID = ID;

    }
   
    /**
     * Other objects register to be notified by this notifier
     *
     * @param listener the listener to be added
     */
    public void addActionListener( ActionListener listener ) {
		
		// generate action listener for this event
        actionListener = AWTEventMulticaster.add( actionListener, listener );
    
    }

    /**
     * Timer calls this method to fire a Timer event
     */
    public void generateActionPerformed() {
	
	    // generate ne waction based on the notifier
        actionListener.actionPerformed(
			new ActionEvent ( this, ActionEvent.ACTION_PERFORMED, ID ) );

    }

}
