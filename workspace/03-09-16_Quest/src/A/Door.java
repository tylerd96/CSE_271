package A;

import java.io.PrintWriter;

public class Door extends LockableItem {

	public Door(String lockedImage, String unlockedImage, boolean visible, boolean locked, KeyType keyType) {
		super(lockedImage, unlockedImage, visible, false, locked, keyType);
		
	}

	@Override
	public void save(PrintWriter pw) {
		pw.println("door");
	}



}
