package Lesson04_RPGstart;

import java.util.ArrayList;

public class Tester {

	public static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	
	public static void main(String[] args) {
		primeArray();
		printTest();
		
		
	}

	private static void printTest() {
		
		for(GameObject go : gameObjects){
			
			if(go instanceof GameCharacter){
				if(go instanceof Flyer)
					((Flyer) go).fly();
				
				if(go instanceof Swimmer)
					((Swimmer) go).swim();
				
			}
		}
		
	}

	private static void primeArray() {
		gameObjects.add(new Snake());
		gameObjects.add(new Snake());
		
		gameObjects.add(new BadBird());
		
		gameObjects.add(new Troll());
		gameObjects.add(new Troll());
		gameObjects.add(new Troll());
		
		gameObjects.add(new Wizard());
		gameObjects.add(new Wizard());

		gameObjects.add(new Fighter());
		gameObjects.add(new Fighter());
		gameObjects.add(new Fighter());
		
		gameObjects.add(new SuperFighter());
		gameObjects.add(new SuperFighter());
		
		gameObjects.add(new Rock());
		gameObjects.add(new Rock());
		gameObjects.add(new Rock());
		gameObjects.add(new Rock());
		
		gameObjects.add(new House());
		gameObjects.add(new House());
		
		gameObjects.add(new Cave());
		
		gameObjects.add(new GeneralPerson());
		gameObjects.add(new GeneralPerson());
		gameObjects.add(new GeneralPerson());
		gameObjects.add(new GeneralPerson());
		gameObjects.add(new GeneralPerson());
		gameObjects.add(new GeneralPerson());
		gameObjects.add(new GeneralPerson());
	}

}
