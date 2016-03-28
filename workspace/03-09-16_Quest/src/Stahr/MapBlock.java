package Stahr;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MapBlock extends Rectangle {
	public static int SIZE = 48;

	private ArrayList<Item> items = new ArrayList<Item>();
	private Image image;
	private boolean allowVisitor;
	private boolean visible;
	private String symbol;

	public MapBlock(int col, 
			int row, 
			String imageFile, 
			boolean allowVisitor,
			boolean visible,
			String symbol){
		this.allowVisitor = allowVisitor;
		setCol(col);
		setRow(row);
		setImage(imageFile);
		setVisible(visible);
		setSymbol(symbol);
	}

	public void save(PrintWriter pw) {
		pw.print(symbol);
	}

	public void setImage(String imageFile) {
		image = Toolkit.getDefaultToolkit().getImage("GameImages/" + imageFile);
	}

	public Image getImage() {
		return image;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void removeItem(Item item) {
		try { items.remove(item); } catch (Exception e) {}	// faster method to remove items.
	}

	public Item pickUpItem(int index) {
		if(index >= 0 && index < items.size()) {
			Item tmp = items.get(index);
			if(tmp.getCanPickUp()) {
				items.remove(index);
				symbol = " ";
				return tmp;
			}
		}
		return null;
	}

	public int itemCount() {
		return items.size();
	}
	
	public void removeItem(int index) {
		if(index >= 0 && index < items.size())
			items.remove(index);
	}

	public Item getItem(int index) {
		if(index >= 0 && index < items.size())
			return items.get(index);
		return null;
	}

	public void draw(Graphics g) {
		if(visible) {
			g.drawImage(image, x, y, SIZE, SIZE, null);

			for(Item i : items)
				i.draw(g, x, y, SIZE);
		}
	}

	public int getSIZE() {
		return SIZE;
	}

	public void setSIZE(int size) {
		SIZE = size;
		width = SIZE;
		height = SIZE;
	}

	public boolean isAllowVisitor() {
		return allowVisitor;
	}

	public void setAllowVisitor(boolean allowVisitor) {
		this.allowVisitor = allowVisitor;
	}

	public void setCol(int col) {
		x = col * SIZE;
	}

	public void setRow(int row) {
		y = row * SIZE;
	}

	public int getCol() {
		return x / SIZE;
	}

	public int getRow() {
		return y / SIZE;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		String ret = "";
		for(Item i : items)
			ret += i.toString() + ", ";
		return ret;
	}

	public boolean canDig() {
		if(items.size() == 0) return symbol.equals(" ");
		for(Item itm : items) if(!itm.getCanPickUp()) return false;
		return true;
	}
}
