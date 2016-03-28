package A;

import java.io.PrintWriter;

public abstract class Weapon extends Item {

	public Weapon(String imageFile, boolean visible, boolean canPickUp) {
		super(imageFile, visible, canPickUp);
	}

	@Override
	public void save(PrintWriter pw) {
		
	}

}
