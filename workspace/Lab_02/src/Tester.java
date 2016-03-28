import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


//Authors:	davistj7 and sutlifnj
//Date:		02/12/2016


public class Tester extends JPanel {

	JFrame window = new JFrame("Lab_02 - Spaceships");
	Timer tmr;
	ArrayList<Spaceship> ships = new ArrayList<Spaceship>();
	
	public Tester() {
		window.setBounds(100, 100, 500, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.setVisible(true);
		
		// Set the global variables for the ship
		Spaceship.sw = getWidth();
		Spaceship.sh = getHeight();
		
		// Set up a timer that will run "actionPerformed()" every 20 milliseconds
		tmr = new Timer(20, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// loop through your ships and tell each ship to move
				for(Spaceship s:ships)
					s.move();
				
				// after all ships have moved repaint the screen
				repaint();
			}
		});
		
		// Generate random ships
		generateShips(10);
		
		// Start the timer
		tmr.start();
		
	}
	
	// Generate a count number of randomly placed ships
	public void generateShips(int count) {
		Random rnd = new Random();
		for(int i=0;i<count;i++) {
			ships.add(new Spaceship(rnd.nextInt(getWidth()),
									rnd.nextInt(getHeight()),
									rnd.nextInt(11)-5,
									rnd.nextInt(11)-5,
									100,
									Color.RED,
									true));
		}
		
	}


	// The paint() method is called on any repaint()
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// loop through your ships and tell each ship to draw itself
		for(Spaceship s: ships)
			s.draw(g);
	}
	
	
	// main() is only used to start the Tester class. Nothing more to do here...
	public static void main(String[] args) {
		new Tester();
	}
}
