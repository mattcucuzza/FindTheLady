// Matthew Cucuzza
// Partner: Matthew Fishman
// SER 210 
//
// Version: 1.0 
// Main class to implement the Find The Lady Card Game


import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class TestLab4  extends JFrame {
	
	// Constructor to implement the JFrame 
	public TestLab4(){
		// Creates the title of the frame 
		super("Find The Lady Game");
	
		FindTheLadyPanel app = new FindTheLadyPanel();
		this.setSize(500,500);
		this.add(app);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
	}
	
	// Main to run the game
	public static void main(String[] args) {
		// Call the constructor to run the game 
		new TestLab4();
	}

} // end class 
