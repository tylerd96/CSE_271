package Lesson04_RPGstart;

import java.awt.Graphics;

public class Dragon extends Monster implements Flyer {

	public Dragon() {
		health = (int)(Math.random()*1001)+1000;
	}
	
	
	@Override
	public boolean fly() {
		System.out.println(this.hashCode()+"Dragon-fly");
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
	public GameCharacter fight(GameCharacter opp) {
		return (health > opp.health ? opp : this);
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
