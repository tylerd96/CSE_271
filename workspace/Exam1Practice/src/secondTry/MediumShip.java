package secondTry;

public class MediumShip extends Ship implements IFighter{

	public MediumShip(String shipName, ShipType shipType) {
		super(shipName, shipType);
	
	}

	@Override
	public void attack(IFighter opp) {
		if(opp instanceof BigShip || opp instanceof MediumShip){
			
		}
	}

}
