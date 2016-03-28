package secondTry;

public class Soldier extends Person implements IFighter{

	public Soldier(String fName, String lName) {
		super(fName, lName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack(IFighter opp) {
		if(opp instanceof Pirate || opp instanceof Soldier){
			
		}
		
	}

}
