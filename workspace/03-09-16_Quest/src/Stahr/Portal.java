package Stahr;

public class Portal extends Door {

	private String jumpToFile;
	
	public Portal(	String lockedImage, 
					String unlockedImage, 
					boolean visible, 
					boolean locked, KeyType keyType, 
					String jumpToFile) {
		super(lockedImage, unlockedImage, visible, locked, keyType);
		this.jumpToFile = jumpToFile;
	}
	
	public String getJumpToFile() {
		return jumpToFile;
	}
	

}
