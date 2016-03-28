package secondTry;

public class BigShip extends Ship implements IFighter{

	public BigShip(String shipName, ShipType shipType) {
		super(shipName, shipType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack(IFighter opp) {
		if(opp instanceof BigShip || opp instanceof MediumShip){
			
		}
		
	}

}
