package A;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
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
		//MapBlock.SIZE = 24;
		loadQuest();
		tmr = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		window.addKeyListener(new KeyListener() {
			
			@Override public void keyTyped(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int kc = e.getKeyCode();
				switch(kc){
				//KeyEvent.VK_UP;
					case 87: 	movePlayer(Direction.UP); repaint(); break;
				//KeyEvent.VK_DOWN;
					case 83:	movePlayer(Direction.DOWN); repaint();  break;
				//KeyEvent.VK_LEFT;
					case 65:	movePlayer(Direction.LEFT); repaint(); break;
				//KeyEvent.VK_RIGHT
					case 68:	movePlayer(Direction.RIGHT); repaint(); break;
				
				}
				//repaint();
				//System.out.println(kc);
				//System.out.println("Player Wealth: "+player.getTotalWealth());
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
	
	
	public void loadQuest() {
		
		blocks.clear();
		
		String questFile = currentQuest + ".txt";
		Scanner fin = null;
		
		try {
			String line;
			int col = 0, row = 0;
			MapBlock mb;
			fin = new Scanner(new File("quests/" + questFile));
			
			while(fin.hasNextLine()) {
				line = fin.nextLine();
				
				for(char c : line.toCharArray()) {
					
					mb = new MapBlock(col, row, "ground.png",true,true);
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
							mb.addItem(new Knife("knife.png",true,true));
							break;
						case ':' :
							mb.addItem(new Key("k-7.png", true, KeyType.MINOR));
							break;
						case '@':
							player = new Player(mb,"wizard.png");
							break;
						case 'm':
							mb.addItem(new Treasure("money.png",true,true,
									   QuestFunctions.getRandomNumber(100, 500)));
							break;
						case 'M':
							mb.addItem(new Treasure("money.png",true,true,
									   QuestFunctions.getRandomNumber(500, 1000)));
							break;
						case 'd':
							mb.addItem(new Door("door.png",true,false,KeyType.NONE));
							break;
						case 'D':
							mb.addItem(new Door("door.png",true,true,KeyType.MINOR));
							break;
					
						case '1':
						case '0':
							mb.addItem(new Portal("pill_blue-7.png",true,false,KeyType.NONE,
									currentQuest.substring(0,currentQuest.length()-1)+c
									));
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
	
	public boolean movePlayer(Direction dir){
		MapBlock mb = getMapBlock(player.getCol()+dir.getDeltaCol(),
								  player.getRow() + dir.getDeltaRow());
		if(mb != null) {

				return player.moveTo(mb);
		}
		return false;
	}
	public MapBlock getMapBlock(int col, int row) {
		for(MapBlock b : blocks) {
			if(b.getCol() == col && b.getRow()==row) {
					return b;
		}}
		return null;
	}
	
	public static void main(String[] args) {
		new Quest();
	}

}
