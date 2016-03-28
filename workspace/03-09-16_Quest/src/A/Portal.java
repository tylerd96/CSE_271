package A;

public class Portal extends Door {

	private String fileToLoad;
	
	public Portal(String lockedImage, String unlockedImage, boolean visible, boolean locked,
			KeyType keyType, String fileToLoad) {
		
		super(lockedImage, unlockedImage, visible, locked, keyType);
		
		this.fileToLoad = fileToLoad;
	}
	
	public String getFileToLoad() {
		return fileToLoad;
	}

}
