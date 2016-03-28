package OddStuff;

public enum enuBlockType {
	
	WALL		("w","Wall","wall.png",false),
	FAKE_WALL	("f","Wall","wall.png",true),
	GUN			("g","Gun","gun.png",true);
	
	
	private String className, imageFile, symbol;
	private boolean allowVisitors;
	
	enuBlockType (String symbol, String className, String imageFile, boolean allowVisitors) {
		this.symbol = symbol;
		this.className = className;
		this.imageFile = imageFile;
		this.allowVisitors = allowVisitors;		
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	public String getClassName(){
		return this.className;
	}
	
	public String getImageFile() {
		return this.imageFile;
	}
	
	public boolean getAllowVisitors() {
		return this.allowVisitors;
	}
	
	public <T> T getClassObject() throws Exception {
		return ((Class<T>) Class.forName(className)).newInstance();
	}  

	
}
