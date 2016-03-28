

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

public class MapBlock extends Rectangle {

	private static int SIZE = 48;

	private ArrayList<Item> items = new ArrayList<Item>();
	
	private Image image;
	private boolean allowVisitor;
	
	public MapBlock(int col, 
					int row, 
					String imageFile, 
					boolean allowVisitor) {

		setAllowVisitor(allowVisitor);
		setCol(col);
		setRow(row);
		setImage(imageFile);
		setSIZE(SIZE);
	}
	
	public int itemCount() {
		return items.size();
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	public void removeItem(int item) {
		if(item >=0 && item < items.size())
			items.remove(item);
	}
	
	public Item getItem(int item) {
		if(item >=0 && item < items.size())
			return items.get(item);
		return null;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, SIZE, SIZE, null);
		for(Item i : items)
			i.draw(g, x, y, SIZE);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(String imageFile) {
		image = Toolkit.getDefaultToolkit().getImage("GameImages/" + imageFile);
	}
	
	public void setSIZE(int size) {
		SIZE = size;
		width = size;
		height = size;
	}
	
	public int getSIZE() {
		return SIZE;
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
	
	public int getCol(int x) {
		return x / SIZE;
	}
	
	public int getRow(int y) {
		return y / SIZE;
	}

	
}
