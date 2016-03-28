package Lesson03_Inheritence;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Rock extends Rectangle {

	public static int sw, sh;
	
	public int dx, dy;
	public Color color;
	public boolean isMoving;

	//================================================= Constructors
	public Rock() {
		this(0, 0, 0, 0);
	}
	
	public Rock(int x, int y, int width, int height) {
		this(x, y, width, height, 1, 1, Color.BLACK, false);
	}
	
	public Rock(int x, int y, int width, int height, int dx, int dy, Color color, boolean isMoving) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.color = color;
		this.isMoving = isMoving;
	}
	
	//================================================= Methods
	
	public Rock split() {
		Rock r = null;
		if(width>20) {
			width/=2;
			height/=2;
			Random rnd = new Random();
			dx = (rnd.nextBoolean() ? 1 : -1)*(rnd.nextInt(5)+1);
			dy = (rnd.nextBoolean() ? 1 : -1)*(rnd.nextInt(5)+1);
			r = new Rock(x,y,width,height,
					(rnd.nextBoolean() ? 1 : -1)*(rnd.nextInt(5)+1),
					(rnd.nextBoolean() ? 1 : -1)*(rnd.nextInt(5)+1),
					color,true);
		}
		
		
		return r;
	}
	
	public void move() {
		if(isMoving == false) return;

		x += dx;
		y += dy;

		if(x + width > sw) {
			x = sw - width;
			dx = -dx;
		}

		if(y + height > sh) {
			y = sh - height;
			dy = -dy;
		}

		if(x < 0) {
			x = 0;
			dx = -dx;
		}

		if(y < 0) {
			y=0;
			dy = -dy;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
	}
	
}
