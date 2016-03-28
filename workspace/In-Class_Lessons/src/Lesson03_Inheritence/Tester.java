package Lesson03_Inheritence;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tester extends JPanel {
	
	public JFrame window = new JFrame("What Rocks!");
	public Timer tmr;
	public ArrayList<Rock> rocks = new ArrayList<Rock>();
	
	
	public Tester() {
		window.setBounds(100, 100, 500, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.setVisible(true);
		
		tmr = new Timer(20, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Rock r:rocks) r.move();
				repaint();
			}
		});
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				for(Rock r:rocks) {
					if(r.contains(e.getPoint())) {
						Rock newRock = r.split();
						if(newRock == null){
							rocks.remove(r);
							
							if(rocks.size()==0) {
								tmr.stop();
								repaint();
								JOptionPane.showMessageDialog(window, "Game Over");
							}
						} else{
							rocks.add(newRock);
						}
						return;
					}
						
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		addRocks(10);
		
		tmr.start();
	}
	
	private void addRocks(int count) {
		Random rnd = new Random();
		for(int i=0;i<count;i++){
			rocks.add(new Rock(
						rnd.nextInt(getWidth()),
						rnd.nextInt(getHeight()),
						80, 80,
						(rnd.nextBoolean() ? 1 : -1)*(rnd.nextInt(5)+1),
						(rnd.nextBoolean() ? 1 : -1)*(rnd.nextInt(5)+1),
						new Color(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256)),
						true
					));
			
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Rock.sw = getWidth();
		Rock.sh = getHeight();
		for(Rock r:rocks) r.draw(g);
	}
	
	
	public static void main(String[] args) {
		new Tester();
	}
}
