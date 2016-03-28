import java.awt.Rectangle;

public class BetterRectangle extends Rectangle {
	
	// needs: x and y, width, height
	public BetterRectangle(int x, int y,int width, int height)	{
		super(x, y, width, height);
		setLocation(x,y);
		setSize(width, height);
	}
	
	public double getPerimeter()	{	return 2*(width+height);	}
	public double getArea() 		{	return width*height;		}
	
}
