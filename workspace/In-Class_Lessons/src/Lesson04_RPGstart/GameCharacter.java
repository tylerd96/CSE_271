package Lesson04_RPGstart;

public abstract class GameCharacter extends GameObject {
	
	public abstract void talk(GameCharacter go);
	public abstract GameCharacter fight(GameCharacter opp);
	
	public int health;
	public int speed;
}
