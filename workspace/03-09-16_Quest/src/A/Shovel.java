package A;

import java.io.PrintWriter;

public class Shovel extends Tool {

	public Shovel(String imageFile, boolean visible, boolean canPickUp) {
		super(imageFile, visible, canPickUp);

	}

	@Override
	public void save(PrintWriter pw) {
		pw.println("Shovel");
	}

}
