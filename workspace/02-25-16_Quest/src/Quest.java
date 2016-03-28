

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Quest extends JPanel {

	public JFrame window = new JFrame("Quest - 2016");
	public ArrayList<MapBlock> blocks = new ArrayList<MapBlock>();
	public Player player;
	
	public Quest() {
		window.setBounds(100, 100, 800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		
		loadQuest("StahrQuest_1-0.txt");
		
		window.setVisible(true);
		
		// Set up a key listener
		window.addKeyListener(new KeyListener() {
			@Override public void keyTyped(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				int kc = e.getKeyCode();
				if(kc >= 37 && kc <= 40) {
					if (kc == KeyEvent.VK_UP)			movePlayer(Direction.UP);
					else if (kc == KeyEvent.VK_DOWN) 	movePlayer(Direction.DOWN);				
					else if (kc == KeyEvent.VK_LEFT) 	movePlayer(Direction.LEFT);					
					else if (kc == KeyEvent.VK_RIGHT) 	movePlayer(Direction.RIGHT);
					repaint();
				}
			}
		});
		window.setFocusable(true);
	}

	private void movePlayer(Direction dir) {
		int newCol = player.getCol() + dir.getDeltaCol();
		int newRow = player.getRow() + dir.getDeltaRow();
		
		MapBlock mb = getMapBlock(newCol, newRow);
		if(mb != null)
			player.moveTo(mb);
	}
	
	private MapBlock getMapBlock(int col, int row) {
		for(MapBlock mb : blocks)
			if(mb.getCol() == col && mb.getRow() == row)
				return mb;		
		return null;
	}
	
	@Override
	public void paint(Graphics g) {
		window.repaint();
		for(MapBlock mb : blocks)	mb.draw(g);
		
		player.draw(g);

	}
	
	private void loadQuest(String questFile) {
		
		Scanner fin = null;
		
		try {
			String line;
			int col = 0, row = 0;
			fin = new Scanner(new File("quests/" + questFile));
			MapBlock mb;
			while(fin.hasNextLine()) {
				line = fin.nextLine();
				for(char c : line.toCharArray()) {
					mb = new MapBlock(col, row, "ground.png", true);		// lets default to ground
					switch(c) {
						case 'w': 
							mb.setImage("wall.png");
							mb.setAllowVisitor(false);
							break;
						case 'f': 
							mb.setImage("wall.png");
							break;
						case 'g': 
							mb.addItem(new Gun("gun.png",true,true)); 
							break;
						
						case 'k': 
							mb.addItem(new Knife("knife.png",true,true)); 
							break;
						case '.': player = new Player(mb, "wizard.png"); break;
					}
					
					blocks.add(mb);

					col++;
				}
				row++;
				col = 0;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(fin != null) fin.close();
		}
	}

	public static void main(String[] args) {
		new Quest();
	}

}
