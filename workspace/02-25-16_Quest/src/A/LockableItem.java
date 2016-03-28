package A;

public abstract class LockableItem extends Item implements Lockable {

	private boolean locked;
	private KeyType keyType;

	public LockableItem(String imageFile, boolean visible, boolean canPickUp, boolean locked, KeyType keyType) {
		super(imageFile, visible,canPickUp);
		this.locked = locked;
		this.keyType = keyType;
	}

	@Override
	public KeyType getKeyType() {
		return keyType;
	}

	@Override
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Override
	public boolean isLocked() {
		return locked;
	}
}
