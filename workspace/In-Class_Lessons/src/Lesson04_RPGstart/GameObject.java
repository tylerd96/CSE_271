package Lesson04_RPGstart;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject extends Rectangle {
	public boolean isVisible;
	
	public abstract void display(Graphics g);
}
