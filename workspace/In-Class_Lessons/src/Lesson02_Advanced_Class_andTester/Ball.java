package Lesson02_Advanced_Class_andTester;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	//============================================== Static variables
	private static int sw, sh;
	//============================================== Instance variables
	private int x,y,dx,dy,size;
	private Color color;
	private boolean isMoving;
	//=========================================== Methods
	public void move() {
		if(! isMoving) return;
		
		x+=dx;
		y+=dy;
		
		if(x + size>sw) {
			x = sw-size;
			dx=-dx;
		}
		if(y+size>sh) {
			y=sh-size;
			dy=-dy;
		}
		if(x<0) {
			x=0;
			dx=-dx;
		}
		if(y<0) {
			y=0;
			dy = -dy;
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillOval(x+2,y+2,size,size);
		g.setColor(color);
		g.fillOval(x, y, size, size);
		g.setColor(Color.BLACK);
		g.drawOval(x, y, size, size);
		
	}
	//=========================================== Constructors
	public Ball() {
		this(0,0,1,1);
	}
	public Ball(int x, int y, int dx, int dy) {
		this(x,y,dx,dy,10,Color.RED,false);
	}
	public Ball(int x, int y, int dx, int dy, int size, Color color, boolean isMoving) {
		super();
		setX(x);
		setY(y);
		setDx(dx);
		setDy(dy);
		setSize(size);
		setColor(color);
		setMoving(isMoving);
	}
	//============================================ Getters/Setters
	public void setSize(int size) {
		if(size < 5)
			this.size = 5;
		else if(size >20)
			this.size = 20;
		else
			this.size = size;
		//this.size = Math.min(Math.max(size,5),20);
	}
	public int getSize() {
		return size;
	}
	public static int getSw() {
		return sw;
	}
	public static void setSw(int sw) {
		Ball.sw = sw;
	}
	public static int getSh() {
		return sh;
	}
	public static void setSh(int sh) {
		Ball.sh = sh;
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
	//============================================ toString()
	@Override
	public String toString() {
		return "Ball [x=" + x + ", y=" + y + ", dx=" + dx + ", dy=" + dy + ", color=" + color + ", isMoving=" + isMoving
				+", size="+size+ "]";
	}
}
