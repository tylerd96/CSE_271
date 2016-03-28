import java.util.ArrayList;

public class Letter {
	
	private ArrayList<String> lines = new ArrayList<String>();
	private String from, to;
	
	public Letter(String from, String to) {
		super();
		this.from = from;
		this.to= to;
	}
	public void addLine(String line) {
		lines.add(line);
	}
	public String getText() {
		String letter = "Dear "+to+":\n";
		for(String s:lines)
			letter+="\n"+s;
		letter+="\n\nSincerely\n\n"+from;
		return letter;
	}
}
