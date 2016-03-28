package Stahr;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Player {

	private ArrayList<Item> items = new ArrayList<Item>();
	private MapBlock currentMapBlock;
	private Image image;
	private int lastCol, lastRow;
	
	public Player(MapBlock currentMapBlock, String imageFile) {
		this.currentMapBlock = currentMapBlock;
		image = Toolkit.getDefaultToolkit().getImage("GameImages/" + imageFile);
	}
	public Player(String imageFile) {
		this(null, imageFile);
	}
	
	public boolean dig() {
		if(currentMapBlock.canDig()) {
			for(Item itm : items)
				if(itm instanceof Shovel) return true;
		}
		return false;
	}
	
	public MapBlock getCurrentMapBlock() {
		return currentMapBlock;
	}
	
	public int itemCount() {return items.size();}
	
	public ArrayList<Item> getItems() { return items; }
	
	public void draw(Graphics g) {
		g.drawImage(image, currentMapBlock.x, currentMapBlock.y, null);
	}
	
	public void save(PrintWriter pw) {
		pw.print("@");
	}
	
	public boolean moveTo(MapBlock mb) {
		if(mb.isAllowVisitor()) {
			
			if(mb.itemCount() > 0) {
				
				Item i = mb.getItem(0);
				
				if(i instanceof LockableItem) {
					if( ((LockableItem)i).isLocked() ) {
						KeyType itemKT, myKT;
						itemKT = ((LockableItem)i).getKeyType();
						for(Item myItem : items) {
							if(myItem instanceof Key) {
								myKT = ((Key)myItem).getKeyType();
								if(myKT == itemKT) {
									mb.setSymbol(mb.getSymbol().toLowerCase());
									((LockableItem)i).setLocked(false);
									items.remove(myItem);
								
									setLastCol(currentMapBlock.getCol());
									setLastRow(currentMapBlock.getRow());
									
									currentMapBlock = mb;
									
									return true;
								}
							}
						}
						return false;
					}
				}
			}
			
			setLastCol(currentMapBlock.getCol());
			setLastRow(currentMapBlock.getRow());
			currentMapBlock = mb;
			Item itm;
			
			for(int i = mb.itemCount()-1; i >= 0; i--) {
				itm = mb.pickUpItem(i);
				if(itm != null) items.add(itm);
			}
			
			
			return true;
		}
		return false;
	}
	
	public int getTotalGold() {
		int total = 0;
		for(Item i : items)
			if(i instanceof Treasure)
				total += ((Treasure)i).getAmount();
		return total;
	}
	
	public int getCol() {
		return currentMapBlock.getCol();
	}
	
	public int getRow() {
		return currentMapBlock.getRow();
	}


	public int getLastCol() {
		return lastCol;
	}


	private void setLastCol(int lastCol) {
		this.lastCol = lastCol;
	}


	public int getLastRow() {
		return lastRow;
	}


	private void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
	

}
