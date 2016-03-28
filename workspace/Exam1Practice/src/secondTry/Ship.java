package secondTry;

import java.util.ArrayList;

public abstract class Ship {
	
	ArrayList<Person> people = new ArrayList<Person>();
	public String shipName;
	private ShipType shipType;
	
	public Ship(String shipName, ShipType shipType) {
		setShipName(shipName);
		setShipType(shipType);
	}
	
	public Person getPerson(int index)				{	return people.get(index);	}
	public void removePerson(int index)				{	people.remove(index);		}
	public int getTotalPeople()  					{	return people.size(); 		}
	public void addPerson(Person p) 				{	people.add(p);				}
	public ArrayList<Person> getPeople() 			{	return people;				}
	public void setPeople(ArrayList<Person> people) {	this.people = people;		}
	public String getShipName()						{	return shipName;			}
	public void setShipName(String shipName) 		{	this.shipName = shipName;	}
	public ShipType getShipType() 					{	return shipType;			}
	public void setShipType(ShipType shipType) 		{	this.shipType = shipType;	}
	
	

}
