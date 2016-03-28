import java.awt.Color;
import java.awt.Graphics;


public class Spaceship {
	//======================================================== Public class-level variables
	public static int sw, sh;
	
	
	//======================================================== Private members variables
	private int x,y,dx,dy,size;
	private Color color;
	private boolean isMoving;
	
	
	//======================================================== Constructors
	// Only really need the workhorse constructor
	public Spaceship(int x, int y, int dx, int dy,int size, Color color, boolean isMoving) {
		super();
		setX(x);
		setY(y);
		setDx(dx);
		setDy(dy);
		setSize(size);
		setColor(color);
		setMoving(isMoving);
	}
	
	//======================================================== Methods
	
	// this ship will move to it's next spot on the screen. Ships should move through left
	// and right walls but bounce off top and bottom walls. When ship is moving up it will
	// have flames shooting from bottom of ship. When ship is moving down it will look normal.
	public void move() {
		if(!isMoving) return;
		x+=dx;
		y+=dy;
		if(dx<0){
			if(x+size<0)
				x=sw;
			if(x-size>sw)
				x = x+size;
			
		}
		else if(dx>0) {
			if(x>sw) {
				x=0-size;
				
			}
			if(x<0-size) {
				x = sw+size;
				
				
			}
		}
		if(y+size/2>sh) {
			y=sh-size/2;
			dy=-dy;
		}
		if(y-size/6<0) {
			y=0+size/6;
			dy = -dy;
		}
		
		
		
		
		
		
	}
	
	public void draw(Graphics g) {
		Color dir;
		if(dy>0)
			dir=Color.BLUE;
		else
			dir = Color.YELLOW;
		g.setColor(dir);
		g.fillOval(x+(size/4),y-size/6,size/2,size/2);
		g.setColor(color.BLACK);
		g.drawOval(x+(size/4), y-(size/6), size/2, size/2);
		g.setColor(color);
		g.fillOval(x, y, size, size/2);
		g.setColor(color.BLACK);
		g.drawOval(x, y, size, size/2);
		
		
		
	}

	//======================================================== Getters / Setters
	public static int getSw() {
		return sw;
	}
	public static void setSw(int sw) {
		Spaceship.sw = sw;
	}

	public static int getSh() {
		return sh;
	}
	public static void setSh(int sh) {
		Spaceship.sh = sh;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public boolean isMoving() {
		return isMoving;
	}
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	


}
