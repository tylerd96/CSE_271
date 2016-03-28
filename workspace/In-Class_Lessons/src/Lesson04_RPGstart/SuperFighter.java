package Lesson04_RPGstart;

public class SuperFighter extends Fighter implements Flyer {
	
	public SuperFighter() {
		
	}

	@Override
	public boolean fly() {
		System.out.println(this.hashCode()+"Superfighter-fly");
		return false;
	}

	@Override
	public boolean land() {
		
		return false;
	}
	
}
