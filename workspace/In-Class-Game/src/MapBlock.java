import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public abstract class MapBlock extends Rectangle {
	
	public static int SIZE = 48;
	
	private Image image;
	private boolean visible, allowVisitors;
	
	public MapBlock(int col, int row, String imageFile, boolean visible, boolean allowVisitors) {
		setCol(col);
		setRow(row);
		setVisible(visible);
		setAllowVisitors(allowVisitors);
		
		image = Toolkit.getDefaultToolkit().getImage("GameImages/" + imageFile);
		
		setSize(SIZE);
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, SIZE, SIZE, null);
		g.drawRect(x, y, SIZE, SIZE);
	}
	public void setSize(int size){
		SIZE = size;
		width = size;
		height = size;
	}

	public boolean isVisible() 							{	return visible;						}
	public void setVisible(boolean visible) 			{	this.visible = visible;				}
	public boolean isAllowVisitors() 					{	return allowVisitors;				}
	public void setAllowVisitors(boolean allowVisitors) {	this.allowVisitors = allowVisitors;	}
	public void setCol(int col)							{	x = col*SIZE;						}
	public void setRow(int row)							{	y = row*SIZE;						}
	public int getCol()									{	return x/SIZE;						}
	public int getRow()									{	return y/SIZE;						}
}
