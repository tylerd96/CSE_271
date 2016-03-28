
public class Soldier extends Person implements IFighter{

	public Soldier(String fName, String lName) {
		super(fName, lName);
	}

	@Override
	public void attack(IFighter opp) {
		if( opp instanceof Soldier || opp instanceof Pirate){
			
		}
	}

}
