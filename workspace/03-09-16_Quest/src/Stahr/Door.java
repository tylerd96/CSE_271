package Stahr;

public class Door extends LockableItem {

	public Door(String lockedImage, String unlockedImage, boolean visible, boolean locked, KeyType keyType) {
		super(lockedImage, unlockedImage, visible, false, locked, keyType);	
	}

}
