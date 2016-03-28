import java.util.ArrayList;

// Names: Tyler Davis and Nikhil Sutliff

public class War_of_the_Oceans {

	private static ArrayList<Ship> ships = new ArrayList<Ship>();

	public static void main(String[] args) {
		
		//=====================================================================================
		// Create a BigShip called enemyShip of type TRIREME and has the name of "Evil Thor" 
		BigShip enemyShip = new BigShip("Evil Thor", ShipType.TRIREME);
		// using a loop add 20 Passengers
		for(int i=1;i<=20;i++){
			enemyShip.addPerson(new Passenger("Passenger", ""+i));
		}
		// using a loop add 50 Pirates
		for(int i=1;i<=50;i++) {
			enemyShip.addPerson(new Pirate("Pirate", "" + i));
		}
		
		//=====================================================================================
		// Create a MediumShip called friendShip of type TRIREME and has the name "The Good Guys" 
		MediumShip friendShip = new MediumShip("The Good Guys", ShipType.TRIREME);
		// using a loop add 10 Passengers
		for(int i=1;i<=10;i++) {
			friendShip.addPerson(new Passenger("Passenger", "" + i));
		}
		// using a loop add 100 Soldiers
		for(int i=1;i<=100;i++) {
			friendShip.addPerson(new Soldier("Soldier", "" +i));
		}
		
		//=====================================================================================
		// Create a SmallShip called neutralShip of type CUTTER has the name "" 
		SmallShip neutralShip = new SmallShip("Don't Kill Us!!!", ShipType.CUTTER);
		
		// using a loop add as many Passengers as you can without exceeding it's limit
		for(int i=1;i<=neutralShip.getShipType().getMaxAllowedPeople();i++) {
			neutralShip.addPerson(new Passenger("Passenger", ""+i));
		}
		
		// Now, add the 3 ships to your ships array list
		ships.add(enemyShip);
		ships.add(friendShip);
		ships.add(neutralShip);
		// Call the releasePassengers(...) method below 3 times sending each of the ships you created
		for(Ship s : ships) {
			releasePassengers(s);
		}
		// Print the total number of enemyShip, friendShip, and neutralShip people that are left
		int totalShipMembers = 0;
		for(Ship s : ships){
			totalShipMembers += s.getTotalPeople();
		}
		
		System.out.println("The total number of people left on all ships is: " + totalShipMembers );
		
		// Write the code that will call upon getShipByType and send it the TRIREME type
		ArrayList<Ship> s = getShipByType(ShipType.TRIREME);
		// loop through the array list that is returned from the method and print the ship's name
		for(Ship sh : s) {
			System.out.println(sh.getShipName());
		}
		
	}

	//=====================================================================================
	// Write the code that will fill and return an ArrayList of ships that are fighters
	private static ArrayList<Ship> getAllFightingShips() {
		ArrayList<Ship> ret = new ArrayList<Ship>();
		for(Ship s: ret){
			if(s instanceof IFighter)
				ret.add(s);
		}
		return ret;
	}

	//=====================================================================================
	// Write the code that will release all people from a ship that are marked as Passenger
	private static void releasePassengers(Ship s) {
		ArrayList<Person> people = s.getPeople();
		for(int i=people.size()-1;i>=0;i--) {
			if(people.get(i) instanceof Passenger)
				people.remove(i);
		}
		s.setPeople(people);
	}

	//=====================================================================================
	// Write the code that will fill and return an ArrayList of ships by a given type
	private static ArrayList<Ship> getShipByType(ShipType st) {
		ArrayList<Ship> ret = new ArrayList<Ship>();
		for(Ship s: ships){
			if(s.getShipType() == st)
				ret.add(s);
		}
		
		return ret;
	}

}
