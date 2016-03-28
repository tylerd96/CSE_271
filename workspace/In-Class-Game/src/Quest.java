import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Version 1.0
 */
public class Quest extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private String currentQuest = "Quest_1-0";
	private JFrame window = new JFrame("Quest - 2016");
	private ArrayList<MapBlock> blocks = new ArrayList<MapBlock>();
	
	public Quest(){
		
		// This goes before loadQuest or else bad things happen
		//MapBlock.SIZE = 24;
		
		loadQuest();
		
		window.setBounds(100, 100, 800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		window.repaint();
		for(MapBlock mb:blocks)
			mb.draw(g);
	}
	
	public void loadQuest(){
		String questFile =currentQuest+ ".txt";
		
		Scanner fin = null;
		try{
			
			String line;
			int col = 0, row = 0;
			
			fin = new Scanner(new File("quests/"+questFile));
			while(fin.hasNextLine()){
				line = fin.nextLine();
				
				for(char c:line.toCharArray()){
					
					switch(c) {
					case 'w' : blocks.add(new Wall(col, row, "wall.png", true, false)); break;
					case 'f' : blocks.add(new Wall(col, row, "wall.png", true, true)); break;
					case 'k' : blocks.add(new Knife(col,row, "knife.png", true, true)); break;
					case '.' : blocks.add(new Player(col,row,"player.png", true, true)); break;
					default  : blocks.add(new Ground(col, row, "ground.png", true, true)); break;
					}
					col++;
				}
				col = 0;
				row++;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(fin!=null) fin.close();
		}
		
	}
	
	
	
	public static void main(String args[]){
		new Quest();
	}
}
