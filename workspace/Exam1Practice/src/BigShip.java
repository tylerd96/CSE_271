

public class BigShip extends Ship implements IFighter{

	public BigShip(String shipName, ShipType shipType) {
		super(shipName, shipType);
	}

	@Override
	public void attack(IFighter opp) {
		if(opp instanceof MediumShip || opp instanceof BigShip){
			
		}
	}

}
