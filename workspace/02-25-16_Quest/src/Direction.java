
public enum Direction {
	UP		(0,-1),
	RIGHT	(1,0),
	DOWN	(0,1),
	LEFT	(-1,0);
	
	int dc, dr;
	Direction(int col, int row) {
		dc = col;
		dr = row;
	}
	public int getDeltaCol() { return dc; }
	public int getDeltaRow() { return dr; }
}
