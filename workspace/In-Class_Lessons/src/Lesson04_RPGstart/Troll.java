package Lesson04_RPGstart;

import java.awt.Graphics;

public class Troll extends Monster implements Swimmer{

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

	@Override
	public void swim() {
		System.out.println(this.hashCode()+"Troll-swim");
		
	}

}
