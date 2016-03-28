package Lesson04_RPGstart;

import java.awt.Graphics;

public class Fighter extends Player implements Swimmer {

	@Override
	public void swim() {
		System.out.println(this.hashCode()+"Fighter-swim");		
	}

	@Override
	public void talk(GameCharacter go) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameCharacter fight(GameCharacter opp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void display(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
