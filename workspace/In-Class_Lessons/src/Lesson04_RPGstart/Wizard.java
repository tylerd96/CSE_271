package Lesson04_RPGstart;

import java.awt.Graphics;

public class Wizard extends Player implements Swimmer, Flyer {

	@Override
	public boolean fly() {
		System.out.println(this.hashCode()+"Wizard-fly");
		return false;
	}

	@Override
	public boolean land() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void swim() {
		System.out.println(this.hashCode()+"Wizard-swim");
		
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
