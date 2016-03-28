package Stahr;

public class Key extends Item {

	private KeyType keyType;
	
	public Key(String imageFile, boolean visible, boolean canPickUp, KeyType keyType) {
		super(imageFile, visible, canPickUp);
		this.keyType = keyType;
	}
	
	public KeyType getKeyType() { return keyType; }

}
