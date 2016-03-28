
public enum ShipType {
	
	FIRE_SHIP	("Fire Ship",	70, 	500, 	20000),
	CUTTER		("Cutter", 		10, 	5, 		600),
	TRIREME		("Trireme", 	140, 	800, 	21000);
	
	
	String friendlyName;
	int maxAllowedPeople, damage, weight;
	
	ShipType(String friendlyName, int maxAllowedPeople, int damage,int weight) {
		this.friendlyName = friendlyName;
		this.maxAllowedPeople = maxAllowedPeople;
		this.damage = damage;
		this.weight = weight;
	}
	String getfriendlyName()	{	return friendlyName;		}	
	int getMaxAllowedPeople()	{	return maxAllowedPeople;	}
	int getDamage()				{	return damage;				}
	int getWeight()				{	return weight;				}
}
