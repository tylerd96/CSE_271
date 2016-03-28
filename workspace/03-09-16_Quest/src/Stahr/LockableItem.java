package Stahr;

public abstract class LockableItem extends Item {

	private KeyType keyType;
	private boolean locked;
	private String lockedImage, unlockedImage;
	
	
	public LockableItem(String lockedImage,
						String unlockedImage,
						boolean visible, 
						boolean canPickUp,
						boolean locked,
						KeyType keyType) {
		super((locked ? lockedImage : unlockedImage), visible, canPickUp);

		this.keyType = keyType;
		this.setLocked(locked);	
		this.lockedImage = lockedImage;
		this.unlockedImage = unlockedImage;	
	}

	private String getImageFile() {
		return isLocked() ? lockedImage : unlockedImage;
	}
	
	public KeyType getKeyType() { return keyType; }
	public boolean isLocked() { return locked; }
	public void setLocked(boolean locked) 	{ 
		this.locked = locked; 
		setImage(getImageFile()); 
	}
	
}
