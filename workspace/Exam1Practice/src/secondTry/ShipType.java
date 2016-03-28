package secondTry;

public enum ShipType {
	
	FIRE_SHIP	("Fire ship",	70, 	500, 	20000),
	CUTTER		("Cutter", 		10, 	5, 		600),
	TRIREME		("Trireme", 	140,	800, 	21000);
	
	private String friendlyName;
	private int maxAllowedPeople, damage, weight;
	
	ShipType(String friendlyName, int maxAllowedPeople, int damage, int weight) {
		setFriendlyName(friendlyName);
		setMaxAllowedPeople(maxAllowedPeople);
		setDamage(damage);
		setWeight(weight);
	}

	public void setFriendlyName(String friendlyName) 		{	this.friendlyName = friendlyName;			}
	public void setMaxAllowedPeople(int maxAllowedPeople) 	{	this.maxAllowedPeople = maxAllowedPeople;	}
	public void setDamage(int damage) 						{	this.damage = damage;						}
	public void setWeight(int weight) 						{	this.weight = weight;						}
	public String getFriendlyName() 						{	return friendlyName;						}
	public int getMaxAllowedPeople() 						{	return maxAllowedPeople;					}
	public int getDamage() 									{	return damage;								}
	public int getWeight() 									{	return weight;								}
	
}
