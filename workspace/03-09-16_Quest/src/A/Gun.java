package A;

import java.io.PrintWriter;

public class Gun extends Weapon {

	public Gun(String imageFile, boolean visible, boolean canPickUp) {
		super(imageFile, visible, canPickUp);
		
	}
	@Override
	public void save(PrintWriter pw) {
		pw.println("Gun");
	}
}
