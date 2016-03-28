package A;

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
import javax.swing.JPanel;
import javax.swing.Timer;

public class Quest extends JPanel {

	private String currentQuest = "Quest_1-0";
	private ArrayList<MapBlock> blocks = new ArrayList<MapBlock>();
	private JFrame window = new JFrame("Quest - 2016");
	private Player player;

	Timer tmr;


	public Quest() {
		loadQuest();

		tmr = new Timer(150, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();				
			}
		});

		window.addKeyListener(new KeyListener() {

			@Override public void keyTyped(KeyEvent e) { }
			@Override public void keyReleased(KeyEvent e) { }

			@Override
			public void keyPressed(KeyEvent e) {
				int kc = e.getKeyCode();

				switch(kc) {
				case KeyEvent.VK_LEFT:	movePlayer(Direction.LEFT);		repaint(); break;
				case KeyEvent.VK_UP:	movePlayer(Direction.UP);		repaint(); break;
				case KeyEvent.VK_RIGHT:	movePlayer(Direction.RIGHT);	repaint(); break;
				case KeyEvent.VK_DOWN:	movePlayer(Direction.DOWN);		repaint(); break;
				case KeyEvent.VK_D:	if(player.dig()) {
					player.getCurrentMapBlock().setImage("dirt-hole.gif");
					player.getCurrentMapBlock().setSymbol("o");
					repaint();
				}
				break;
				
				}
				//System.out.println(player.getTotalWealth());

				//System.out.println("Player Wealth: " + player.getTotalWealth());

			}
		});
		window.setFocusable(true);

		window.setBounds(100, 100, 800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.setVisible(true);
		window.setAlwaysOnTop(true);
		window.setResizable(false);

		tmr.start();

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(MapBlock mb : blocks)
			mb.draw(g);
		player.draw(g);
	}

	public boolean movePlayer(Direction dir) {

		MapBlock mb = getMapBlock(	player.getCol() + dir.getDeltaCol(),
					player.getRow() + dir.getDeltaRow()
				);
		if(mb != null) {
			if(mb.itemCount()>0 && (mb.getItem(0) instanceof Portal)) {
				player.getCurrentMapBlock().setSymbol("@");
				saveCurrentLevel();
				
				currentQuest = ((Portal)mb.getItem(0)).getFileToLoad();
				loadQuest();
				return true;
			}
				
			return player.moveTo(mb);
		}

		return false;
	}
	
	private void saveCurrentLevel() {
		
		PrintWriter pw = null;
		
		int cols = blocks.get(blocks.size()-1).getCol()+1;
		int rows = blocks.get(blocks.size()-1).getRow()+1;
		
		player.getCurrentMapBlock().setSymbol("@");
		
		try {
			pw = new PrintWriter(new File("quests/" + currentQuest + ".sav"));
			for(int r=0; r<rows; r++){
				for(int c=0; c<cols; c++){
					getMapBlock(c,r).save(pw);
				}
				pw.println();
			}
			pw.close();
			
			String playerFile = currentQuest.substring(0,currentQuest.length()-2);
			pw = new PrintWriter(new File("quests/" + playerFile + "_player.sav"));
			player.save(pw);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			if(pw != null) pw.close();
		}
		
	}

	public MapBlock getMapBlock(int col, int row) {

		for(MapBlock mb : blocks) {
			if(mb.getCol() == col && mb.getRow() == row)
				return mb;
		}
		return null;
	}


	public void loadQuest() {

		blocks.clear();

		Scanner fin = null;

		try {
			String line;
			int col = 0, row = 0;
			MapBlock mb;
			
			File qf = new File("quests/" + currentQuest + ".sav");
			if(! qf.exists())
				qf = new File("quests/" + currentQuest + ".txt");

			fin = new Scanner(qf);

			while(fin.hasNextLine()) {
				line = fin.nextLine();

				for(char c : line.toCharArray()) {
					mb = new MapBlock(col, row, "ground.png", true, true, "" + c);
					switch(c) {
					case 'w': 
						mb.setImage("wall.png");
						mb.setAllowVisitors(false);
						break;
					case 'f': 
						mb.setImage("wall.png");
						break;
					case 'g':
						mb.addItem(new Gun("gun.png",true,true));
						break;
					case 'k':
						mb.addItem(new Knife("knife.png",true, true));
						break;
					case ':':
						mb.addItem(new Key("key.png",true,KeyType.MINOR));
						break;
					case '@':
						if(player == null)
							player = new Player("wizard.png", mb);
						else
							player.moveTo(mb);
						mb.setSymbol(" ");
						break;	
					case 'm':
					case 'b':
						mb.addItem(new Treasure("money.png",(c=='m'),true,
								QuestFunctions.getRandomNumber(100, 500)));
						break;
					case 'M':
					case 'B':
						mb.addItem(new Treasure("money.png",(c=='M'),true,
								QuestFunctions.getRandomNumber(500, 1000)));
						break;
					case 'd':
						mb.addItem(new Door("door_yellow.png","door.png",true,false,KeyType.NONE ));
						break;
					case 'D':
						mb.addItem(new Door("door_yellow.png","door.png",true,true,KeyType.MINOR ));
						break;
					case 's':
						mb.addItem(new Shovel("shovel.png", true, true));
						break;
					case '0':
					case '1':
						mb.addItem(new Portal("pill_yellow.png","pill_blue.png",true,false,KeyType.NONE, 
								currentQuest.substring(0,currentQuest.length()-1) + c
								));
						break;
					case 'o':
						mb.setImage("dirt-hole.gif");
						break;
					}
					blocks.add(mb);
					col++;
				}

				col = 0;
				row++;
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
