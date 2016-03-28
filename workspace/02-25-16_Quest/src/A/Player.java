package A;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Player {
	
	private ArrayList<Item> items = new ArrayList<Item>();
	private MapBlock currentMapBlock;
	private Image image;
	
	public Player(MapBlock currentMapBlock, String fileName){
		this.currentMapBlock = currentMapBlock;
		image = Toolkit.getDefaultToolkit().getImage("GameImages/"+fileName);
	}
	
	public boolean moveTo(MapBlock mb) {
		if(mb.isAllowVisitors()){
			Item tmpItem;
			if(mb.itemCount()>0 && (mb.getItem(0) instanceof LockableItem)) {
				if(((LockableItem) mb.getItem(0)).isLocked()) {
					KeyType kt = ((LockableItem)mb.getItem(0)).getKeyType();
					
					for(Item i: items){
						if(i instanceof Key){
							if(kt == ((Key)i).getKeyType()) {
								((LockableItem)mb.getItem(0)).setLocked(false);
								items.remove(i);
								currentMapBlock = mb;
								return true;
							}
						}
					}
					return false;
				}
			}
			
			currentMapBlock = mb;
			
			for(int i = mb.itemCount()-1; i>=0; i--) {
				tmpItem = mb.pickupItem(i);
				if(tmpItem != null)  items.add(tmpItem);
			}
			return true;
		}
		return false;
	}
	public int getTotalWealth() {
		int ret=0;
		for(Item i : items){
			if(i instanceof Treasure)
				ret += ((Treasure) i).getAmount();
		}
		
		return ret;
	}
	
	public Rectangle getBounds() {
		return currentMapBlock;
	}
	
	public Point getLocation() {
		return new Point(currentMapBlock.x, currentMapBlock.y);
	}
	public int getCol() {
		return currentMapBlock.getCol();
	}
	public int getRow() {
		return currentMapBlock.getRow();
	}
	public void draw(Graphics g) {
		g.drawImage(image, currentMapBlock.x, currentMapBlock.y, null);
	}
}
