package secondTry;

public class Pirate extends Person implements IFighter {

	public Pirate(String fName, String lName) {
		super(fName, lName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack(IFighter opp) {
		if(opp instanceof Pirate || opp instanceof Soldier){
			
		}
		
	}
	
}
