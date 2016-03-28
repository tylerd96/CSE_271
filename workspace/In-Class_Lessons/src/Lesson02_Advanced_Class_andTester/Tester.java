package Lesson02_Advanced_Class_andTester;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tester extends JPanel{
	
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	private JFrame window = new JFrame("My First Graphics Program");
	private Timer tmr;
	
	public Tester() {
		window.setBounds(100, 100, 500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.setVisible(true);
		
		Ball.setSh(getHeight());
		Ball.setSw(getWidth());
		addBalls(20);
		
		// This is where you change the speed of the program updating
		tmr = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				for(Ball b : balls)
					b.move();
				repaint();
				
			}
		});
		tmr.start();
	}
	
	public void addBalls(int count) {
		Random rnd = new Random();
		for(int i=0;i<count;i++)
			balls.add(new Ball(rnd.nextInt(getWidth()),
							   rnd.nextInt(getHeight()),
							   rnd.nextInt(40)+10,
							   rnd.nextInt(10)+1, 
							   rnd.nextInt(10)+1,
							   new Color(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256)), true));
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(Ball b : balls)
			b.draw(g);
	}
	
	public static void main(String[] args) {
		new Tester();
	}

}
