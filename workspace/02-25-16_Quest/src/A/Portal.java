package A;

public class Portal extends Door {
	
	private String fileToLoad;

	public Portal(String imageFile, boolean visible, boolean locked, KeyType keyType, String fileToLoad) {
		super(imageFile, visible, locked, keyType);
		this.fileToLoad = fileToLoad;
	}

}
