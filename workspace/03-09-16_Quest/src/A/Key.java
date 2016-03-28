package A;

import java.io.PrintWriter;

public class Key extends Item {
	private KeyType keyType;
	public Key(String imageFile, boolean visible, KeyType keyType) {
		super(imageFile, visible, true);
		this.keyType = keyType;
	}

	public KeyType getKeyType() { return keyType; }

	@Override
	public void save(PrintWriter pw) {
		pw.println("Key");
	}
}
