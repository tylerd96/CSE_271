package A;

public abstract class LockableItem extends Item  {

	private boolean locked;
	private KeyType keyType;
	private String unlockedImage, lockedImage;
	
	public LockableItem(String lockedImage, String unlockedImage, boolean visible, boolean canPickUp, boolean locked, KeyType keyType) {
		super((locked ? lockedImage : unlockedImage), visible, canPickUp);
		this.locked = locked;
		this.keyType = keyType;
		this.lockedImage = lockedImage;
		this.unlockedImage = unlockedImage;
	}
	
	public String getImageFile() {
		return (locked ? lockedImage : unlockedImage);
	}
	
	public KeyType getKeyType() {
		return keyType;
	}
	
	public void setLocked(boolean locked) {
		this.locked = locked;
		setImage(getImageFile());
	}
	
	public boolean isLocked() {
		return locked;
	}
}
