package A;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Player {

	private MapBlock currentMapBlock;
	private Image image;
	private ArrayList<Item> items = new ArrayList<Item>();
	private int wealth;
	
	public Player(String imageFile, MapBlock currentMapBlock) {
		this.currentMapBlock = currentMapBlock;
		image = Toolkit.getDefaultToolkit().getImage("GameImages/" + imageFile);
	}
	public int getWealth() {
		return wealth;
	}
	public int addTreasure(int amt) {
		return wealth+=amt;
	}
	public int removeTreasure(int amt){
		return wealth -= amt;
	}
	
	public boolean dig() {
		if(currentMapBlock.canDig()) {
			for(Item i : items) 
				if(i instanceof Shovel) {
					Item foundItem;
					for(int j =currentMapBlock.itemCount()-1; j >=0; j--){
						foundItem = currentMapBlock.getItem(j);
						foundItem.setVisible(true);
					}
					moveTo(currentMapBlock);
					return true;
				}
		}
		return false;
	}
	
//	public int getTotalWealth() {
//		int ret = 0;
//		
//		for(Item i : items) {
//			if(i instanceof Treasure) {
//				ret += ((Treasure) i).getAmount();
//			}
//		}
//		
//		return ret;
//	}
	
	
	public boolean moveTo(MapBlock mb) {

		if(mb.isAllowVisitors()) {
			Item itm;
			
			if(mb.itemCount() > 0 && (mb.getItem(0) instanceof LockableItem ) ) {
				if( ((LockableItem)mb.getItem(0)).isLocked() ) {
					KeyType kt = ((LockableItem)mb.getItem(0)).getKeyType();
					
					for(Item i : items) {
						if(i instanceof Key) {
							if(kt == ((Key)i).getKeyType() ) {
								((LockableItem)mb.getItem(0)).setLocked(false);
								items.remove(i);
								currentMapBlock = mb;
								currentMapBlock.setSymbol(mb.getSymbol().toLowerCase());
								return true;
							}
						}
					}
					return false;
				}				
			}			
			
			currentMapBlock = mb;
			
					
			for(int i = mb.itemCount()-1; i >= 0; i--) {
				itm = mb.pickupItem(i);
				if(itm != null) {
					addItem(itm);
					mb.setSymbol(" ");
				}
			}
			
			return true;
		}
		return false;		
	}
	
	public boolean addItem(Item itm) {
		if(itm instanceof Treasure) {
			addTreasure(((Treasure) itm).getAmount());
			return true;
		}
		items.add(itm);
		return true;
		
	}
	
	public void save(PrintWriter pw) {
		pw.println(wealth);
		for(Item i : items)
			i.save(pw);
	}
	public MapBlock getCurrentMapBlock() {
		return currentMapBlock;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, getX(), getY(), null);
	}
	
	public int getX() {
		return currentMapBlock.x;
	}
	
	public int getY() {
		return currentMapBlock.y;
	}
	
	public int getCol() {
		return currentMapBlock.getCol();
	}
	
	public int getRow() {
		return currentMapBlock.getRow();
	}
	
	public Point getLocation() {
		return new Point(currentMapBlock.x, currentMapBlock.y);
	}
	
	public Rectangle getBounds() {
		return currentMapBlock;
	}
	public void setWealth(int wealth) {
		if(wealth >=0) this.wealth = wealth;
	}
	
	
}
