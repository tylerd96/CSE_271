package A;

public enum Direction {

	UP		(0,-1),
	DOWN	(0, 1),
	LEFT	(-1,0),
	RIGHT	(1, 0),
	NE		(1,-1),
	SE		(1, 1),
	NW		(-1,-1),
	SW		(-1,1);
	
	private int deltaCol, deltaRow;
	
	Direction(int deltaCol, int deltaRow) {
		this.deltaCol = deltaCol;
		this.deltaRow = deltaRow;
	}
	
	public int getDeltaCol()	{	return deltaCol;	}
	public int getDeltaRow()	{	return deltaRow;	}
	
	
}
