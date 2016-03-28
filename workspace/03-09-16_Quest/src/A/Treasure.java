package A;

import java.io.PrintWriter;

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
		if(amount > -1)	this.amount = amount;
	}

	@Override
	public void save(PrintWriter pw) {
		
	}

}
