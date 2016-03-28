package Lesson04_RPGstart;

import java.awt.Graphics;
/*
 * 
 */
public class BadBird extends Monster implements Flyer {

	
	private static final long serialVersionUID = 1L;

	@Override
	public boolean fly() {
		System.out.println(this.hashCode()+"BadBird-fly");
		return false;
	}

	@Override
	public boolean land() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void talk(GameCharacter go) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bite(GameCharacter opp) {
		// TODO Auto-generated method stub
		
	}

}
