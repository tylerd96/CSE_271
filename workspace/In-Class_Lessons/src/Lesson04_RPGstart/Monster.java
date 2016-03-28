package Lesson04_RPGstart;

public abstract class Monster extends GameCharacter {
	public abstract void bite(GameCharacter opp);
	
	@Override
	public GameCharacter fight(GameCharacter opp) {
		
		return null;
	}
}
