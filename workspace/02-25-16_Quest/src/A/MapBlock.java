package A;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.tools.Tool;

public class MapBlock extends Rectangle {

	public static int SIZE = 48;

	private ArrayList<Item> items = new ArrayList<Item>();
	private Image image;
	private boolean visible;
	private boolean allowVisitors;

	public MapBlock(int col, 
					int row, 
					String imageFile, 
					boolean visible, 
					boolean allowVisitors) {
		setCol(col);
		setRow(row);
		setVisible(visible);
		setAllowVisitors(allowVisitors);
		
		setImage(imageFile);
		setSize(SIZE);
		
	} 
	
	public void setImage(String imageFile) {
		image = Toolkit.getDefaultToolkit().getImage("GameImages/" + imageFile);
	}
	public void draw(Graphics g) {
		if(visible) {
		g.drawImage(image, x, y, SIZE, SIZE, null);
		for(Item i:items)
			i.draw(g,x,y,SIZE);
		}
	}
	
	public void setSize(int size) {
		SIZE = size;
		width = size;
		height = size;
	}
	
	public void removeItem(Item item){
		if(items.contains(item)) items.remove(item);
		
		// or a faster way
		//try {items.remove(item);} catch (Exception e) {}
	}
	
	public void removeItem(int i){
		if(i >= 0 && i < items.size()) items.remove(i);
		
		//could also do another try catch but might be slower
	}
	
	public Item pickupItem(int i) {
		Item ret = null;
		if(i >= 0 && i < items.size()) {
			ret = items.get(i);
			if(ret.getCanPickUp())	
				items.remove(i);
			else
				ret = null;
		}
		return ret;
	}
	
	public Item getItem(int i) {
		if(i <= 0 && i < items.size())
			return items.get(i);
		return null;
	}
	
	public void addItem(Item item){
		items.add(item);
	}
	
	public int itemCount(){
		return items.size();
	}
	
	public void setCol(int col)							{   x = col * SIZE;						}
	public void setRow(int row)							{   y = row * SIZE;						}
	public int getCol()									{   return x / SIZE;					}
	public int getRow()									{   return y / SIZE;					}
	public boolean isVisible()							{   return visible;						}
	public void setVisible(boolean visible)				{	this.visible = visible;				}
	public boolean isAllowVisitors() 					{	return allowVisitors;				}
	public void setAllowVisitors(boolean allowVisitors) {	this.allowVisitors = allowVisitors;	}
}
