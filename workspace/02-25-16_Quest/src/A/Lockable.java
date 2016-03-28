package A;

public interface Lockable {
	
	public KeyType getKeyType();
	public void setLocked(boolean locked);
	public boolean isLocked();
}
