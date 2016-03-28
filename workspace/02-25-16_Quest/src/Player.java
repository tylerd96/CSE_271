import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Player {
	private MapBlock currentMapBlock; 
	private Image image;
	private ArrayList<Item> items = new ArrayList<Item>();

	public Player(MapBlock currentMapBlock, String imageFile) {
		image = Toolkit.getDefaultToolkit().getImage("GameImages/" + imageFile);
		this.currentMapBlock = currentMapBlock;
	}
	
	public boolean moveTo(MapBlock mb) {
		if(mb.isAllowVisitor()){
			currentMapBlock = mb;
			Item tmpItem;
			for(int i = mb.itemCount() - 1; i >= 0 ; i--) {
				tmpItem = mb.getItem(i);
				if(tmpItem.isCanPickUp()) {
					items.add(tmpItem);
					mb.removeItem(i);
				}
			}
			return true;
		}
		return false;
	}

	public void draw(Graphics g) {
		g.drawImage(image, currentMapBlock.x, currentMapBlock.y, null);
	}
	
	public int getCol() {return currentMapBlock.getCol();}
	public int getRow() {return currentMapBlock.getRow();}
	
}
