/*
 * CheckerGUI.java
 * 
 * The actual board.
 *
 * Created on January 25, 2002, 2:34 PM
 * 
 * Version
 * $Id: CheckerGUI.java,v 1.1 2002/10/22 21:12:52 se362 Exp $
 * 
 * Revisions
 * $Log: CheckerGUI.java,v $
 * Revision 1.1  2002/10/22 21:12:52  se362
 * Initial creation of case study
 *
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.net.*;

/**
 *
 * @author
 * @version 
 */

public class CheckerGUI extends JFrame implements ActionListener{
    
    //the facade for the game
    
    private static Facade theFacade; //the facade
    private Vector possibleSquares = new Vector();//a vector of the squares
    private int timeRemaining;//the time remaining

    private JButton[] jButtons;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JButton jButton10;
    private JButton jButton11;
    private JButton jButton12;
    private JButton jButton13;
    private JButton jButton14;
    private JButton jButton15;
    private JButton jButton16;
    private JButton jButton17;
    private JButton jButton18;
    private JButton jButton19;
    private JButton jButton20;
    private JButton jButton21;
    private JButton jButton22;
    private JButton jButton23;
    private JButton jButton24;
    private JButton jButton25;
    private JButton jButton26;
    private JButton jButton27;
    private JButton jButton28;
    private JButton jButton29;
    private JButton jButton30;
    private JButton jButton31;
    private JButton jButton32;
    private JButton jButton33;
    private JButton jButton34;
    private JButton jButton35;
    private JButton jButton36;
    private JButton jButton37;
    private JButton jButton38;
    private JButton jButton39;
    private JButton jButton40;
    private JButton jButton41;
    private JButton jButton42;
    private JButton jButton43;
    private JButton jButton44;
    private JButton jButton45;
    private JButton jButton46;
    private JButton jButton47;
    private JButton jButton48;
    private JButton jButton49;
    private JButton jButton50;
    private JButton jButton51;
    private JButton jButton52;
    private JButton jButton53;
    private JButton jButton54;
    private JButton jButton55;
    private JButton jButton56;
    private JButton jButton57;
    private JButton jButton58;
    private JButton jButton59;
    private JButton jButton60;
    private JButton jButton61;
    private JButton jButton62;
    private JButton jButton63;
    private JButton jButton64;
    private JLabel PlayerOnelabel;
    private JLabel playerTwoLabel;
    private JLabel timeRemainingLabel;
    private JLabel secondsLeftLabel;
    private JButton ResignButton;
    private JButton DrawButton;
    private JLabel warningLabel, whosTurnLabel;
    
    //the names and time left
    private static String playerOnesName="", playerTwosName="", timeLeft="";

    /** 
     *
     * Constructor, creates the GUI and all its components
     *
     * @param facade the facade for the GUI to interact with
     * @param name1 the first players name
     * @param name2 the second players name
     *
     */

    public CheckerGUI( Facade facade, String name1, String name2 ) {

        super("Checkers");

        playerOnesName = trimName(name1);
        playerTwosName = trimName(name2);
        theFacade = facade;
        register();
        
        initComponents ();
        pack ();
        update();
        //updateTime();
    }

    private String trimName(String name) {
        //long names mess up the way the GUI displays
        //this code shortens the name if it is too long
        if(name.length() > 7 ){
            return name.substring(0,7);
        }else{
            return name;
        }
    }
    
    
    /*
     * This method handles setting up the timer
     */
    
    private void register() {
	
        try{
	    theFacade.addActionListener( this );
	  
        }catch( Exception e ){
            
            System.err.println( e.getMessage() );
         
        }
    }

    private Vector addButtons(JButton[] buttons) {
        Vector vector = new Vector();
        for(JButton b : buttons) {
            vector.add(b);
        }
        return vector;
    }

    /**
     * This method is called from within the constructor to
     * initialize the form. It initializes the components
     * adds the buttons to the Vecotr of squares and adds
     * an action listener to the components 
     *
     */
    private void initComponents() {
        
	    this.setResizable( false );
        jButtons = new JButton[64];
        for(JButton b : jButtons) {
            b.addActionListener(this);
        }
	    possibleSquares = addButtons(jButtons);


        jButton1 = new JButton( );
        possibleSquares.add(jButton1);
        jButton1.addActionListener( this );

        jButton2 = new JButton();
	possibleSquares.add(jButton2);
        jButton2.addActionListener( this );

        jButton3 = new JButton();
	possibleSquares.add(jButton3);
        jButton3.addActionListener( this );

        jButton4 = new JButton();
	possibleSquares.add(jButton4);
        jButton4.addActionListener( this );

        jButton5 = new JButton();
	possibleSquares.add(jButton5);
        jButton5.addActionListener( this );

	jButton6 = new JButton();
	possibleSquares.add(jButton6);
        jButton6.addActionListener( this );

	jButton7 = new JButton();
	possibleSquares.add(jButton7);
        jButton7.addActionListener( this );

        jButton8 = new JButton();
	possibleSquares.add(jButton8);
        jButton8.addActionListener( this );

        jButton9 = new JButton();
	possibleSquares.add(jButton9);
        jButton9.addActionListener( this );

        jButton10 = new JButton();
	possibleSquares.add(jButton10);
        jButton10.addActionListener( this );

        jButton11 = new JButton();
	possibleSquares.add(jButton11);
        jButton11.addActionListener( this );

        jButton12 = new JButton();
	possibleSquares.add(jButton12);
        jButton12.addActionListener( this );

        jButton13 = new JButton();
	possibleSquares.add(jButton13);
        jButton13.addActionListener( this );

        jButton14 = new JButton();
	possibleSquares.add(jButton14);
        jButton14.addActionListener( this );

        jButton15 = new JButton();
	possibleSquares.add(jButton15);
        jButton15.addActionListener( this );

        jButton16 = new JButton();
	possibleSquares.add(jButton16);
        jButton16.addActionListener( this );

        jButton17 = new JButton();
	possibleSquares.add(jButton17);
        jButton17.addActionListener( this );

        jButton18 = new JButton();
	possibleSquares.add(jButton18);
        jButton18.addActionListener( this );

        jButton19 = new JButton();
	possibleSquares.add(jButton19);
        jButton19.addActionListener( this );

        jButton20 = new JButton();
	possibleSquares.add(jButton20);
        jButton20.addActionListener( this );

        jButton21 = new JButton();
	possibleSquares.add(jButton21);
        jButton21.addActionListener( this );

        jButton22 = new JButton();
	possibleSquares.add(jButton22);
        jButton22.addActionListener( this );

        jButton23 = new JButton();
	possibleSquares.add(jButton23);
        jButton23.addActionListener( this );

        jButton24 = new JButton();
	possibleSquares.add(jButton24);
        jButton24.addActionListener( this );

        jButton25 = new JButton();
	possibleSquares.add(jButton25);
        jButton25.addActionListener( this );

        jButton26 = new JButton();
	possibleSquares.add(jButton26);
        jButton26.addActionListener( this );

        jButton27 = new JButton();
	possibleSquares.add(jButton27);
        jButton27.addActionListener( this );

        jButton28 = new JButton();
	possibleSquares.add(jButton28);
        jButton28.addActionListener( this );

        jButton29 = new JButton();
	possibleSquares.add(jButton29);
        jButton29.addActionListener( this );

	jButton30 = new JButton();
	possibleSquares.add(jButton30);
        jButton30.addActionListener( this );

	jButton31 = new JButton();
	possibleSquares.add(jButton31);
        jButton31.addActionListener( this );

	jButton32 = new JButton();
	possibleSquares.add(jButton32);
        jButton32.addActionListener( this );

	jButton33 = new JButton();
	possibleSquares.add(jButton33);
        jButton33.addActionListener( this );

	jButton34 = new JButton();
	possibleSquares.add(jButton34);
        jButton34.addActionListener( this );

        jButton35 = new JButton();
	possibleSquares.add(jButton35);
        jButton35.addActionListener( this );

	jButton36 = new JButton();
	possibleSquares.add(jButton36);
        jButton36.addActionListener( this );

	jButton37 = new JButton();
	possibleSquares.add(jButton37);
        jButton37.addActionListener( this );

	jButton38 = new JButton();
	possibleSquares.add(jButton38);
        jButton38.addActionListener( this );

	jButton39 = new JButton();
	possibleSquares.add(jButton39);
        jButton39.addActionListener( this );

	jButton40 = new JButton();
	possibleSquares.add(jButton40);
        jButton40.addActionListener( this );

	jButton41 = new JButton();
	possibleSquares.add(jButton41);
        jButton41.addActionListener( this );

	jButton42 = new JButton();
	possibleSquares.add(jButton42);
        jButton42.addActionListener( this );

	jButton43 = new JButton();
	possibleSquares.add(jButton43);
        jButton43.addActionListener( this );

	jButton44 = new JButton();
	possibleSquares.add(jButton44);
        jButton44.addActionListener( this );

	jButton45 = new JButton();
	possibleSquares.add(jButton45);
        jButton45.addActionListener( this );

	jButton46 = new JButton();
	possibleSquares.add(jButton46);
        jButton46.addActionListener( this );

	jButton47 = new JButton();
	possibleSquares.add(jButton47);
        jButton47.addActionListener( this );

	jButton48 = new JButton();
	possibleSquares.add(jButton48);
        jButton48.addActionListener( this );

	jButton49 = new JButton();
	possibleSquares.add(jButton49);
        jButton49.addActionListener( this );

	jButton50 = new JButton();
	possibleSquares.add(jButton50);
        jButton50.addActionListener( this );

	jButton51 = new JButton();
	possibleSquares.add(jButton51);
        jButton51.addActionListener( this );

	jButton52 = new JButton();
	possibleSquares.add(jButton52);
        jButton52.addActionListener( this );

	jButton53 = new JButton();
	possibleSquares.add(jButton53);
        jButton53.addActionListener( this );

	jButton54 = new JButton();
	possibleSquares.add(jButton54);
        jButton54.addActionListener( this );

	jButton55 = new JButton();
	possibleSquares.add(jButton55);
        jButton55.addActionListener( this );

        jButton56 = new JButton();
	possibleSquares.add(jButton56);
        jButton56.addActionListener( this );

        jButton57 = new JButton();
	possibleSquares.add(jButton57);
        jButton57.addActionListener( this );

        jButton58 = new JButton();
	possibleSquares.add(jButton58);
        jButton58.addActionListener( this );

        jButton59 = new JButton();
	possibleSquares.add(jButton59);
        jButton59.addActionListener( this );

        jButton60 = new JButton();
	possibleSquares.add(jButton60);
        jButton60.addActionListener( this );

        jButton61 = new JButton();
	possibleSquares.add(jButton61);
        jButton61.addActionListener( this );

	jButton62 = new JButton();
	possibleSquares.add(jButton62);
        jButton62.addActionListener( this );

	jButton63 = new JButton();
	possibleSquares.add(jButton63);
        jButton63.addActionListener( this );

        jButton64 = new JButton();
	possibleSquares.add(jButton64);
        jButton64.addActionListener( this );
	
        PlayerOnelabel = new JLabel();
        playerTwoLabel = new JLabel();
	whosTurnLabel = new JLabel();
        
        warningLabel = new JLabel( );
        timeRemainingLabel = new JLabel();
        secondsLeftLabel = new JLabel();
	
        ResignButton = new JButton();
        ResignButton.addActionListener( this );
		
        DrawButton = new JButton();
        DrawButton.addActionListener( this );
	      
        //sets the layout and adds listener for closing window
        getContentPane().setLayout(new GridBagLayout());
	GridBagConstraints gridBagConstraints1;
    
	//add window listener
	addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                exitForm(evt);
            }
        }
			  );
        
        jButton1.setPreferredSize(new Dimension(80, 80));
        jButton1.setActionCommand("0");
        jButton1.setBackground(Color.white);
        		
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 1;
        getContentPane().add(jButton1, gridBagConstraints1);
        
        
        jButton2.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton2.setActionCommand("1");
        jButton2.setBackground( new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 1;
        getContentPane().add(jButton2, gridBagConstraints1);
        
        
        jButton3.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton3.setActionCommand("2");
        jButton3.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 1;
        getContentPane().add(jButton3, gridBagConstraints1);
        
        
        jButton4.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton4.setActionCommand("3");
        jButton4.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 3;
        gridBagConstraints1.gridy = 1;
        getContentPane().add(jButton4, gridBagConstraints1);
        
        
        jButton5.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton5.setActionCommand("4");
        jButton5.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 4;
        gridBagConstraints1.gridy = 1;
        getContentPane().add(jButton5, gridBagConstraints1);

        
        jButton6.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton6.setActionCommand("5");
        jButton6.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 5;
        gridBagConstraints1.gridy = 1;
        getContentPane().add(jButton6, gridBagConstraints1);
        
        
        jButton7.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton7.setActionCommand("6");
        jButton7.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 6;
        gridBagConstraints1.gridy = 1;
        getContentPane().add(jButton7, gridBagConstraints1);
        
        
        jButton8.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton8.setActionCommand("7");
        jButton8.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 7;
        gridBagConstraints1.gridy = 1;
        getContentPane().add(jButton8, gridBagConstraints1);
        
        
        jButton9.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton9.setActionCommand("8");
        jButton9.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 2;
        getContentPane().add(jButton9, gridBagConstraints1);
        
        
        jButton10.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton10.setActionCommand("9");
        jButton10.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 2;
        getContentPane().add(jButton10, gridBagConstraints1);
        
        
        jButton11.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton11.setActionCommand("10");
        jButton11.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 2;
        getContentPane().add(jButton11, gridBagConstraints1);
        
        
        jButton12.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton12.setActionCommand("11");
        jButton12.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 3;
        gridBagConstraints1.gridy = 2;
        getContentPane().add(jButton12, gridBagConstraints1);
        
        
        jButton13.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton13.setActionCommand("12");
        jButton13.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 4;
        gridBagConstraints1.gridy = 2;
        getContentPane().add(jButton13, gridBagConstraints1);
        
        
        jButton14.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton14.setActionCommand("13");
        jButton14.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 5;
        gridBagConstraints1.gridy = 2;
        getContentPane().add(jButton14, gridBagConstraints1);
        
        
        jButton15.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton15.setActionCommand("14");
        jButton15.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 6;
        gridBagConstraints1.gridy = 2;
        getContentPane().add(jButton15, gridBagConstraints1);
        
        
        jButton16.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton16.setActionCommand("15");
        jButton16.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 7;
        gridBagConstraints1.gridy = 2;
        getContentPane().add(jButton16, gridBagConstraints1);
        
        
        jButton17.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton17.setActionCommand("16");
        jButton17.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 3;
        getContentPane().add(jButton17, gridBagConstraints1);
        
        
        jButton18.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton18.setActionCommand("17");
        jButton18.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 3;
        getContentPane().add(jButton18, gridBagConstraints1);
        
        
        jButton19.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton19.setActionCommand("18");
        jButton19.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 3;
        getContentPane().add(jButton19, gridBagConstraints1);
        
        
        jButton20.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton20.setActionCommand("19");
        jButton20.setBackground(new Color(204, 204, 153));
     
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 3;
        gridBagConstraints1.gridy = 3;
        getContentPane().add(jButton20, gridBagConstraints1);
        
        
        jButton21.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton21.setActionCommand("20");
        jButton21.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 4;
        gridBagConstraints1.gridy = 3;
        getContentPane().add(jButton21, gridBagConstraints1);
        
        
        jButton22.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton22.setActionCommand("21");
        jButton22.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 5;
        gridBagConstraints1.gridy = 3;
        getContentPane().add(jButton22, gridBagConstraints1);
        
        
        jButton23.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton23.setActionCommand("22");
        jButton23.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 6;
        gridBagConstraints1.gridy = 3;
        getContentPane().add(jButton23, gridBagConstraints1);
        
        
        jButton24.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton24.setActionCommand("23");
        jButton24.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 7;
        gridBagConstraints1.gridy = 3;
        getContentPane().add(jButton24, gridBagConstraints1);
        
        
        jButton25.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton25.setActionCommand("24");
        jButton25.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 4;
        getContentPane().add(jButton25, gridBagConstraints1);
        
        
        jButton26.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton26.setActionCommand("25");
        jButton26.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 4;
        getContentPane().add(jButton26, gridBagConstraints1);
        
        
        jButton27.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton27.setActionCommand("26");
        jButton27.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 4;
        getContentPane().add(jButton27, gridBagConstraints1);
        
        
        jButton28.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton28.setActionCommand("27");
        jButton28.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 3;
        gridBagConstraints1.gridy = 4;
        getContentPane().add(jButton28, gridBagConstraints1);
        
        
        jButton29.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton29.setActionCommand("28");
        jButton29.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 4;
        gridBagConstraints1.gridy = 4;
        getContentPane().add(jButton29, gridBagConstraints1);
        
        
        jButton30.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton30.setActionCommand("29");
        jButton30.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 5;
        gridBagConstraints1.gridy = 4;
        getContentPane().add(jButton30, gridBagConstraints1);
        
        
        jButton31.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton31.setActionCommand("30");
        jButton31.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 6;
        gridBagConstraints1.gridy = 4;
        getContentPane().add(jButton31, gridBagConstraints1);
        
        
        jButton32.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton32.setActionCommand("31");
        jButton32.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 7;
        gridBagConstraints1.gridy = 4;
        getContentPane().add(jButton32, gridBagConstraints1);
        
        
        jButton33.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton33.setActionCommand("32");
        jButton33.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 5;
        getContentPane().add(jButton33, gridBagConstraints1);
        
        
        jButton34.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton34.setActionCommand("33");
        jButton34.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 5;
        getContentPane().add(jButton34, gridBagConstraints1);
        
        
        jButton35.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton35.setActionCommand("34");
        jButton35.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 5;
        getContentPane().add(jButton35, gridBagConstraints1);
        
        
        jButton36.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton36.setActionCommand("35");
        jButton36.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 3;
        gridBagConstraints1.gridy = 5;
        getContentPane().add(jButton36, gridBagConstraints1);
        
        
        jButton37.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton37.setActionCommand("36");
        jButton37.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 4;
        gridBagConstraints1.gridy = 5;
        getContentPane().add(jButton37, gridBagConstraints1);
        
        
        jButton38.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton38.setActionCommand("37");
        jButton38.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 5;
        gridBagConstraints1.gridy = 5;
        getContentPane().add(jButton38, gridBagConstraints1);

        jButton39.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton39.setActionCommand("38");
        jButton39.setBackground(Color.white);

        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 6;
        gridBagConstraints1.gridy = 5;
        getContentPane().add(jButton39, gridBagConstraints1);
 
        jButton40.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton40.setActionCommand("39");
        jButton40.setBackground(new Color(204, 204, 153));

        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 7;
        gridBagConstraints1.gridy = 5;
        getContentPane().add(jButton40, gridBagConstraints1);

        jButton41.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton41.setActionCommand("40");
        jButton41.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 6;
        getContentPane().add(jButton41, gridBagConstraints1);
        
        jButton42.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton42.setActionCommand("41");
        jButton42.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 6;
        getContentPane().add(jButton42, gridBagConstraints1);
        
        jButton43.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton43.setActionCommand("42");
        jButton43.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 6;
        getContentPane().add(jButton43, gridBagConstraints1);
        
        jButton44.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton44.setActionCommand("43");
        jButton44.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 3;
        gridBagConstraints1.gridy = 6;
        getContentPane().add(jButton44, gridBagConstraints1);
        
        jButton45.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton45.setActionCommand("44");
        jButton45.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 4;
        gridBagConstraints1.gridy = 6;
        getContentPane().add(jButton45, gridBagConstraints1);
        
        jButton46.setPreferredSize(new java.awt.Dimension(80, 80));
	jButton46.setActionCommand("45");
        jButton46.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 5;
        gridBagConstraints1.gridy = 6;
        getContentPane().add(jButton46, gridBagConstraints1);
        
        jButton47.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton47.setActionCommand("46");
        jButton47.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 6;
        gridBagConstraints1.gridy = 6;
        getContentPane().add(jButton47, gridBagConstraints1);
        
        jButton48.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton48.setActionCommand("47");
        jButton48.setBackground(Color.white);

        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 7;
        gridBagConstraints1.gridy = 6;
        getContentPane().add(jButton48, gridBagConstraints1);
        
        jButton49.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton49.setActionCommand("48");
        jButton49.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 7;
        getContentPane().add(jButton49, gridBagConstraints1);
        
        jButton50.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton50.setActionCommand("49");
        jButton50.setBackground(new Color(204, 204, 153));

        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 7;
        getContentPane().add(jButton50, gridBagConstraints1);
        
        jButton51.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton51.setActionCommand("50");
        jButton51.setBackground(Color.white);

        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 7;
        getContentPane().add(jButton51, gridBagConstraints1);
        
        jButton52.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton52.setActionCommand("51");
        jButton52.setBackground(new Color(204, 204, 153));

        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 3;
        gridBagConstraints1.gridy = 7;
        getContentPane().add(jButton52, gridBagConstraints1);
        
        jButton53.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton53.setActionCommand("52");
        jButton53.setBackground(Color.white);

        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 4;
        gridBagConstraints1.gridy = 7;
        getContentPane().add(jButton53, gridBagConstraints1);
        
        jButton54.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton54.setActionCommand("53");
        jButton54.setBackground(new Color(204, 204, 153));

        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 5;
        gridBagConstraints1.gridy = 7;
        getContentPane().add(jButton54, gridBagConstraints1);
        
        jButton55.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton55.setActionCommand("54");
        jButton55.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 6;
        gridBagConstraints1.gridy = 7;
        getContentPane().add(jButton55, gridBagConstraints1);
        
        jButton56.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton56.setActionCommand("55");
        jButton56.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 7;
        gridBagConstraints1.gridy = 7;
        getContentPane().add(jButton56, gridBagConstraints1);
        
        jButton57.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton57.setActionCommand("56");
        jButton57.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 8;
        getContentPane().add(jButton57, gridBagConstraints1);

        jButton58.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton58.setActionCommand("57");
        jButton58.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 8;
        getContentPane().add(jButton58, gridBagConstraints1);
        
        jButton59.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton59.setActionCommand("58");
        jButton59.setBackground(new Color(204, 204, 153));
       
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 8;
        getContentPane().add(jButton59, gridBagConstraints1);
        
        jButton60.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton60.setActionCommand("59");
        jButton60.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 3;
        gridBagConstraints1.gridy = 8;
        getContentPane().add(jButton60, gridBagConstraints1);
        
        jButton61.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton61.setActionCommand("60");
        jButton61.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 4;
        gridBagConstraints1.gridy = 8;
        getContentPane().add(jButton61, gridBagConstraints1);
        
        jButton62.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton62.setActionCommand("61");
        jButton62.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 5;
        gridBagConstraints1.gridy = 8;
        getContentPane().add(jButton62, gridBagConstraints1);
        
        jButton63.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton63.setActionCommand("62");
        jButton63.setBackground(new Color(204, 204, 153));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 6;
        gridBagConstraints1.gridy = 8;
        getContentPane().add(jButton63, gridBagConstraints1);     

        jButton64.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton64.setActionCommand("63");
        jButton64.setBackground(Color.white);
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 7;
        gridBagConstraints1.gridy = 8;
        getContentPane().add(jButton64, gridBagConstraints1);
        
        PlayerOnelabel.setText("Player 1:     " + playerOnesName );
        PlayerOnelabel.setForeground( Color.black );
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.gridwidth = 4;
        getContentPane().add(PlayerOnelabel, gridBagConstraints1);
        
        playerTwoLabel.setText("Player 2:     " + playerTwosName );
        playerTwoLabel.setForeground( Color.black );
		
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 9;
        gridBagConstraints1.gridwidth = 4;
        getContentPane().add(playerTwoLabel, gridBagConstraints1);
        
        whosTurnLabel.setText("");
        whosTurnLabel.setForeground( new Color( 0, 100 , 0 ) );
        
        gridBagConstraints1.gridx=8;
        gridBagConstraints1.gridy=1;
        getContentPane().add(whosTurnLabel, gridBagConstraints1 );
        
        warningLabel.setText( "" );
        warningLabel.setForeground( Color.red );
		
        gridBagConstraints1.gridx = 8;
        gridBagConstraints1.gridy = 2;
        getContentPane().add( warningLabel, gridBagConstraints1 );
        
        timeRemainingLabel.setText("Time Remaining:");
        timeRemainingLabel.setForeground( Color.black );
		
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 8;
        gridBagConstraints1.gridy = 3;
        getContentPane().add(timeRemainingLabel, gridBagConstraints1);
        
        secondsLeftLabel.setText( timeLeft + " sec.");
        secondsLeftLabel.setForeground( Color.black );
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 8;
        gridBagConstraints1.gridy = 4;
        getContentPane().add(secondsLeftLabel, gridBagConstraints1);
        
        ResignButton.setActionCommand("resign");
        ResignButton.setText("Resign");
        
	gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 8;
        gridBagConstraints1.gridy = 7;
        getContentPane().add(ResignButton, gridBagConstraints1);
        
        DrawButton.setActionCommand("draw");
        DrawButton.setText("Draw");
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 8;
        gridBagConstraints1.gridy = 6;
        getContentPane().add(DrawButton, gridBagConstraints1);
	
    }
    
    /** 
     * 
     * Exit the Application
     * 
     * @param the window event
     * 
     */
    private void exitForm(java.awt.event.WindowEvent evt) {
        theFacade.pressQuit();
        
    }

    /**
     * Takes care of input from users, handles any actions performed
     *
     * @param e  the event that has occured
     */
    
    public void actionPerformed( ActionEvent e ) {
        
	try{
	    //if a square gets clicked
	    if( e.getActionCommand().equals(  "1" ) ||
		e.getActionCommand().equals(  "3" ) || 
		e.getActionCommand().equals(  "5" ) ||
		e.getActionCommand().equals(  "7" ) ||
		e.getActionCommand().equals(  "8" ) ||
		e.getActionCommand().equals( "10" ) ||
		e.getActionCommand().equals( "12" ) ||
		e.getActionCommand().equals( "14" ) ||
		e.getActionCommand().equals( "17" ) ||
		e.getActionCommand().equals( "19" ) ||
		e.getActionCommand().equals( "21" ) ||
		e.getActionCommand().equals( "23" ) ||
		e.getActionCommand().equals( "24" ) ||
		e.getActionCommand().equals( "26" ) ||
		e.getActionCommand().equals( "28" ) ||
		e.getActionCommand().equals( "30" ) ||
		e.getActionCommand().equals( "33" ) ||
		e.getActionCommand().equals( "35" ) ||
		e.getActionCommand().equals( "37" ) ||
		e.getActionCommand().equals( "39" ) ||
		e.getActionCommand().equals( "40" ) ||
		e.getActionCommand().equals( "42" ) ||
		e.getActionCommand().equals( "44" ) ||
		e.getActionCommand().equals( "46" ) ||
		e.getActionCommand().equals( "49" ) ||
		e.getActionCommand().equals( "51" ) ||
		e.getActionCommand().equals( "53" ) ||
		e.getActionCommand().equals( "55" ) ||
		e.getActionCommand().equals( "56" ) ||
		e.getActionCommand().equals( "58" ) ||
		e.getActionCommand().equals( "60" ) ||
		e.getActionCommand().equals( "62" ) ) {
		
		//call selectSpace with the button pressed
		theFacade.selectSpace(
				   Integer.parseInt( e.getActionCommand() ) );
		
		//if draw is pressed
	    }else if( e.getActionCommand().equals( "draw" ) ){
		//does sequence of events for a draw
		theFacade.pressDraw();
		
		//if resign is pressed
	    }else if( e.getActionCommand().equals( "resign" ) ) {
		//does sequence of events for a resign
		theFacade.pressQuit();
		
		//if the source came from the facade
	    }else if( e.getSource().equals( theFacade ) ) {
		
		//if its a player switch event
		if ( (e.getActionCommand()).equals(theFacade.playerSwitch) ) {
		    //set a new time
		    timeRemaining = theFacade.getTimer();
		    //if it is an update event
		} else if ( (e.getActionCommand()).equals(theFacade.update) ) {
		    //update the GUI
		    update();
		} else {
		    throw new Exception( "unknown message from facade" );
		}
	    }
	    //catch various Exceptions
	}catch( NumberFormatException excep ){
	    System.err.println(
		     "GUI exception: Error converting a string to a number" );
	}catch( NullPointerException exception ){
	    System.err.println( "GUI exception: Null pointerException "
				+ exception.getMessage() );
	    exception.printStackTrace();
	}catch( Exception except ){
	    System.err.println( "GUI exception: other: "
				+ except.getMessage() );
	    except.printStackTrace();
	}
	
    }
    

    /**
     * Updates the GUI reading the pieces in the board
     * Puts pieces in correct spaces, updates whos turn it is
     *
     * @param the board
     */
    
    private void update(){
	
	
	if( checkEndConditions() ){
	    
	    theFacade.showEndGame(" ");
	}
	//the board to read information from
	Board board = theFacade.stateOfBoard();
	//a temp button to work with
	JButton temp =  new JButton();
	
	//go through the board
	for( int i = 1; i < board.sizeOf(); i++ ){
	    
	    // if there is a piece there
	    if( board.occupied( i ) ){
		
		//check to see if color is blue
		if( board.colorAt( i ) == Color.blue ){

		    //if there is a  single piece there
		    if((board.getPieceAt(i)).getType() == board.SINGLE){

			//show a blue single piece in that spot board
			temp = (JButton)possibleSquares.get(i);

			//get the picture from the web
			try{
			    temp.setIcon(
			      new ImageIcon( new URL("file:BlueSingle.gif") ));
			}catch( MalformedURLException e ){
			    System.out.println(e.getMessage());
			}

			//if there is a kinged piece there
		    }else if((board.getPieceAt(i)).getType() == board.KING ){

			//show a blue king piece in that spot board
			temp= (JButton)possibleSquares.get(i);

			//get the picture formt the web
			try{
			    temp.setIcon(
			      new ImageIcon(new URL("file:BlueKing.gif") ) );
			}catch( Exception e ){}
			
		    }

		    //check to see if the color is white        
		}else if( board.colorAt( i ) == Color.white ){

		    //if there is a single piece there
		    if((board.getPieceAt(i)).getType() == board.SINGLE){

			//show a blue single piece in that spot board
			temp = (JButton)possibleSquares.get(i);

			//get the picture from the web
			try{
			    temp.setIcon(
			      new ImageIcon(new URL("file:WhiteSingle.gif")));
			}catch( Exception e ){}
			
			//if there is a kinged piece there
		    }else if((board.getPieceAt(i)).getType() == board.KING ){

			//show a blue king piece in that spot board
			temp = (JButton)possibleSquares.get(i);

			//get the picture from the web
			try{
			    temp.setIcon(
			      new ImageIcon(new URL("file:WhiteKing.gif") ) );
			}catch( Exception e ){}
		    }
                                //if there isnt a piece there        
		}
	    }else {
		//show no picture
		temp = (JButton)possibleSquares.get(i);
		temp.setIcon( null );
	    }
	}
	
	//this code updates whos turn it is
	if(theFacade.whosTurn() == 2 ){
	    playerTwoLabel.setForeground( Color.red );
	    PlayerOnelabel.setForeground(Color.black );
	    whosTurnLabel.setText( playerTwosName + "'s turn ");
	}else if( theFacade.whosTurn() == 1 ){
	    PlayerOnelabel.setForeground( Color.red );
	    playerTwoLabel.setForeground(Color.black );
	    whosTurnLabel.setText( playerOnesName + "'s turn" );
	}
    }
    
    /**
     *
     * Update the timer
     *
     */
        
    public void updateTime() {            
            
	if ( theFacade.getTimer() > 0 ) {
                
	    // if the time has run out but not in warning time yet
	    // display warning and count warning time
	    if ( timeRemaining <= 0 && ( warningLabel.getText() ).equals( "" ) ) {
		timeRemaining = theFacade.getTimerWarning();
		warningLabel.setText( "Time is running out!!!" );
                    
                // if the time has run out and it was in warning time quit game
	    } else if ( timeRemaining <= 0 &&
			!( warningLabel.getText() ).equals( "" ) ) {
                  
		theFacade.pressQuit();
                    
	    } else {
                    
		timeRemaining--;
                    
	    }
                
	    secondsLeftLabel.setText( timeRemaining + " sec." );
                    
	} else {
	    secondsLeftLabel.setText( "*****" );
	}
    }
    
    /**
     * Checks the ending condotions for the game
     * see if there a no pieces left
     *
     * @return the return value for the method
     *           true if the game should end
     *           false if game needs to continue 
     */
 
        public boolean checkEndConditions(){
           
	    //the return value
            boolean retVal = false;
            try{
		//the number of each piece left
		int whitesGone = 0 , bluesGone = 0;
		
		//the board to work with
		Board temp = theFacade.stateOfBoard();
		
		//go through all the spots on the board
		for( int i=1; i<temp.sizeOf(); i++ ){
		    //if there is a piece there
		    if( temp.occupied( i  ) ){
			//if its a blue piece there
			if( (temp.getPieceAt( i )).getColor() == Color.blue ){
			    // increment number of blues
			    bluesGone++;
			    //if the piece is white
			}else if( (temp.getPieceAt( i )).getColor()
				  == Color.white ){
			    //increment number of whites
			    whitesGone++;
			}
		    }
		}//end of for loop
		
		//if either of the number are 0
		if( whitesGone == 0 || bluesGone == 0 ){
		    retVal = true;
		}

            }catch( Exception e ){
                
                System.err.println( e.getMessage() );            
                
            }
            return retVal;
            
        }//checkEndConditions

}//checkerGUI.java
