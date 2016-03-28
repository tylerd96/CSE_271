import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public abstract class Item {
	private Image image;
	private boolean visible;
	private boolean canPickUp;
	
	public Item(String imageFile, boolean visible, boolean canPickUp) {
		image = Toolkit.getDefaultToolkit().getImage("GameImages/" + imageFile);
		setVisible(visible);
		setCanPickUp(canPickUp);
	}

	public void draw(Graphics g, int x, int y, int size) {
		if(visible)
			g.drawImage(image, x, y, size, size, null);
	}
	
	public boolean isVisible() 				{return visible;}
	public void setVisible(boolean visible)	{this.visible = visible;}

	public boolean isCanPickUp() {return canPickUp;}
	public void setCanPickUp(boolean canPickUp) {this.canPickUp = canPickUp;}
	
}
