package A;

import java.io.PrintWriter;

public class Knife extends Weapon {

	public Knife(String imageFile, boolean visible, boolean canPickUp) {
		super(imageFile, visible, canPickUp);
	}

	@Override
	public void save(PrintWriter pw){
		pw.println("Knife");
	}
}
