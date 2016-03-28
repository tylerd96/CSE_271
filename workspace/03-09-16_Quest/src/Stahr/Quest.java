package Stahr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Quest extends JPanel {

	JFrame window = new JFrame("Quest - 2016");	
	ArrayList<MapBlock> blocks = new ArrayList<MapBlock>();
	Player player = null; //new Player("wizard.png");
	Timer tmr;
	String currentQuest = "Quest_1-0";
	int cols = 0, rows = 0;

	public Quest() {

		window.setBounds(100,100,800,800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.setVisible(true);
		window.setResizable(false);
		window.setAlwaysOnTop(true);
		this.setBackground(Color.WHITE);
		
		window.addKeyListener(new KeyListener() {
			
			@Override public void keyTyped(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				int kc = e.getKeyCode();
				
				if(kc >= 37 && kc <= 40) {
					if(kc == KeyEvent.VK_UP)			movePlayerTo(Direction.UP);
					else if (kc == KeyEvent.VK_RIGHT) 	movePlayerTo(Direction.RIGHT);
					else if (kc == KeyEvent.VK_DOWN) 	movePlayerTo(Direction.DOWN);
					else								movePlayerTo(Direction.LEFT);
					repaint();
				} else if (kc == KeyEvent.VK_D) {
					if(player.dig()) {
						player.getCurrentMapBlock().setImage("dirt-hole.gif");
						player.getCurrentMapBlock().setSymbol("*");
						repaint();
					}
				}
			}
		});
		window.setFocusable(true);
		
		tmr = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		
		MapBlock.SIZE = 48;
		loadQuest();
		
		
		tmr.start();
		
	}
	
	private void movePlayerTo(Direction dir) {
		int col = player.getCol() + dir.getDeltaCol();
		int row = player.getRow() + dir.getDeltaRow();
		MapBlock mb = getMapBlock(col, row);
		if(mb != null)

			for(int i = 0; i < mb.itemCount(); i++) {
				if(mb.getItem(i) instanceof Portal) {
					saveCurrentQuest();
					currentQuest = ((Portal)mb.getItem(i)).getJumpToFile();
					loadQuest();
					return;
				}
			}
			
			if(player.moveTo(mb)) {
				try { getMapBlock(col-1, row-1).setVisible(true);} catch(Exception e){};
				try { getMapBlock(col, row-1).setVisible(true);} catch(Exception e){};
				try { getMapBlock(col+1, row-1).setVisible(true);} catch(Exception e){};
				try { getMapBlock(col-1, row).setVisible(true);} catch(Exception e){};
				try { getMapBlock(col+1, row).setVisible(true);} catch(Exception e){};
				try { getMapBlock(col-1, row+1).setVisible(true);} catch(Exception e){};
				try { getMapBlock(col, row+1).setVisible(true);} catch(Exception e){};
				try { getMapBlock(col+1, row+1).setVisible(true);} catch(Exception e){};

				repaint();		
			}
	}
	
	private void saveCurrentQuest() {
		
		PrintWriter pw=null;
		
		try {
			pw = new PrintWriter(new File("quests/" + currentQuest + ".sav" ));
			MapBlock mb;
			for(int r = 0; r < rows; r++) {
				for(int c = 0; c < cols; c++) {
					mb = getMapBlock(c, r);
					if(player.getCurrentMapBlock() == mb)
						player.save(pw);
					else
						mb.save(pw);
				}
				pw.println();
			}

		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(pw != null) pw.close();
		}
		 
		
	}
	
	private MapBlock getMapBlock(int col, int row) {
		for(MapBlock mb : blocks)
			if(mb.getCol() == col && mb.getRow() == row)
				return mb;
		return null;
	}
	

	private void loadQuest() {
		Scanner fin = null;
		String ext = ".txt";
		blocks.clear();
		rows = 0;
		cols = 0;
		
		
		try {
			File f = new File("quests/" + currentQuest + ".sav");
			if (! (f.exists() && !f.isDirectory()) ) { 
				f = new File("quests/" + currentQuest + ".txt");
			}

			fin = new Scanner(f);
			String line;
			int col = 0, row = 0;
			MapBlock mb;
			
			while(fin.hasNextLine()) {
				line = fin.nextLine();
				rows++;
				cols = line.length();
				for(char c : line.toCharArray()) {
					mb = new MapBlock(col, row, "ground.png", true, true, "" + c);

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
						case '@':
							if(player == null)
								player = new Player(mb, "wizard.png");
							else
								player.moveTo(mb);
							player.getCurrentMapBlock().setSymbol(" ");
							break;
						case ':':
							mb.addItem(new Key("key.png",true,true, KeyType.MINOR));
							break;
						case 'm':
							mb.addItem(new Treasure("money.png",true,true, 
									QuestFunctions.getRandomNum(100, 500) ));
							break;
						case 'M':
							mb.addItem(new Treasure("money.png",true,true, 
									QuestFunctions.getRandomNum(500, 1000) ));
							break;
						case 'D':
							mb.addItem(new Door("door_yellow.png", "door.png",true,true,KeyType.MINOR));
							break;
						case 'd':
							mb.addItem(new Door("door_yellow.png", "door.png",true,false,KeyType.MINOR));
							break;
						case '*':
							mb.setImage("dirt-hole.gif");
							mb.setVisible(true);
							break;
						case 's':
							mb.addItem(new Shovel("shovel.png",true,true));
							break;
						case '0':
						case '1':
							mb.addItem(new Portal(	
									"pill_yellow.png", 
									"pill_blue.png",
									true, 
									false,
									KeyType.NONE,
									currentQuest.substring(0,currentQuest.length()-1) + c
								)
							);
							break;
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

	@Override
	public void paint(Graphics g) {
		try {
			super.paintComponent(g);
			for(MapBlock b : blocks) 
				b.draw(g);
		} catch(Exception e) {}	
		
		if(player != null) player.draw(g);
	}
	

	public static void main(String[] args) {
		new Quest();
	}
	
}
