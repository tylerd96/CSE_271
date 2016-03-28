package Stahr;

public class Gun extends Weapon {

	public Gun(String imageFile, boolean visible, boolean canPickUp) {
		super(imageFile, visible, canPickUp);

	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Weapon-Gun";
	}

}
