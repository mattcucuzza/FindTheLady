// Matthew Cucuzza
// Partner: Matthew Fishman
// SER 210 
//
// Version: 1.0 
// Creates 3 cards facing backwards, allows the user to pick a card, and guess to find 
// the Queen Card- then shuffle and restart the game 

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;


public class FindTheLadyPanel extends JPanel{
	
    private final JLabel label;
    private JButton card4, card18, cardQueen;
    private boolean gameOver = false;
 
 /**
  * Class constructor creates and defines the buttons.
  */
   public FindTheLadyPanel(){
	   super();
	   
	   setLayout(new BorderLayout());
	   
	   // Main panel 
       label = new JLabel("Choose a card", SwingConstants.CENTER);
       this.add(label, BorderLayout.NORTH);
       
       JPanel panel= new JPanel();
       
       // Card images defined here
       ImageIcon card4Image = createImageIcon("images/back.png", "images/4.png");
       ImageIcon card18Image = createImageIcon("images/back.png", "images/18.png");
       ImageIcon cardQueenImage = createImageIcon("images/back.png","images/queen.png");
       
       // The subpanel for the cards
       final JPanel cardPanel = new JPanel();
      
       // The card buttons will be stored in an ArrayList type JButton 
       final ArrayList<JButton> cardButtons = new ArrayList<JButton>();
      
       // Card buttons defined here
       card4 = new JButton(card4Image);
       card18 = new JButton(card18Image);
       cardQueen = new JButton(cardQueenImage);
      
       cardButtons.add(card4);
       cardButtons.add(card18);
       cardButtons.add(cardQueen);
      
       // Adds the cards stored in the ArrayList cardButtons to the JPanel cardPanel
       for(JButton card : cardButtons){
    	   cardPanel.add(card);
       }
       
       // Adds the panel to the frame and centers it 
       this.add(cardPanel, BorderLayout.CENTER);
       
	   //Shuffles the board when the game starts	
       Collections.shuffle(cardButtons);
		for(JButton card : cardButtons){
	    	   cardPanel.add(card);
		}
		
		System.out.println("Good Luck! Let the games begin!");
		
		// If Card4 is clicked, use this actionListener (user Loses if this is chosen)
		card4.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent event){
    		   card4.setIcon(createImageIcon("images/4.png","images/back.png"));
    		   if (gameOver == false){
    			   label.setText("You lose. Shuffle to play again!");
    			   System.out.println("You Lose!");
    			   gameOver = true;
    		   }
    	   	}
		}); // end parameters / anonymous class 
       
	
		// If Card18 is clicked, use this actionListener (user Loses if this is chosen)
		card18.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent event){
    		   card18.setIcon(createImageIcon("images/18.png","images/back.png"));
    		   if (gameOver == false){
    			   label.setText("You lose. Shuffle to play again!");
    			   System.out.println("You Lose!");
    			   gameOver = true;
    		   }
    	   }
		}); // end parameters / anonymous class 
  
		// If Queen Card is clicked, use this actionListener (This WINS the game)
		cardQueen.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent event){
    		   cardQueen.setIcon(createImageIcon("images/queen.png","images/back.png"));
    		   if (gameOver == false){
    			   label.setText("You win. Shuffle to play again!");
    			   System.out.println("You Win!");
    			   gameOver = true;
    		   }
    	   }
		}); // end parameters / anonymous class 
  
   
		// Shuffle Button created & added to bottom of panel 
		JButton bottomButton = new JButton("Shuffle!");
		this.add(bottomButton, BorderLayout.SOUTH);
		
		// If Shuffle is clicked, use this actionListener
		bottomButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				
				// Shuffles ArrayList of cards using Collections class 
				Collections.shuffle(cardButtons);
				
				// Re-adds the cards back into the panel 
				for(JButton card : cardButtons){
			    	   cardPanel.add(card);
				}
	    		// Resets the card images back to the initial back facing up position 
				cardQueen.setIcon(createImageIcon("images/back.png","images/queen.png"));
	    		card18.setIcon(createImageIcon("images/back.png","images/18.png"));
	    		card4.setIcon(createImageIcon("images/back.png","images/4.png"));
	    		label.setText("Choose a card");
	    		gameOver = false;

	    		// Repaints the images onto the panel 
				repaint();
				System.out.println("[BUTTON CLICKED]: Cards have been shuffled!");
			}
		}); // end parameters / anonymous class 
		
   } // end Constructor 
   
   /** Returns an ImageIcon, or null if the path was invalid. 
    * A good encapsulation for the validation and retrival of the image file. error */
   private static ImageIcon createImageIcon(String path, String desc) {
       java.net.URL imgURL = FindTheLadyPanel.class.getResource(path);
       if (imgURL != null) {
           return new ImageIcon(imgURL,desc);
       } else {
           System.err.println("Couldn't find file: " + path);
           return null;
       }
   }
   
} // ends class 
