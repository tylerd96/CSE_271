
public class Bug {
	
	private int position;
	private boolean movingRight;
	
	public Bug(int initialPosition){
		super();
		position = initialPosition;
		movingRight = true;
	}
	public void turn(){
		movingRight=!movingRight;
	}
	public void move(){
		if(movingRight)
			position++;
		else
			position--;
	}
	public int getPosition(){
		return position;
	}
}
