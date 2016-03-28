package Stahr;

public class Treasure extends Item {

	private int amount = 0;
	
	public Treasure(String imageFile, boolean visible, boolean canPickUp, int amount) {
		super(imageFile, visible, canPickUp);
		setAmount(amount);				
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if(amount > 0)
			this.amount = amount;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Item-Treasure";
	}

	
}
