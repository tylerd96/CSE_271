
public class Student {
	private String name;
	private double totalQuizScore;
	private int totalQuizes;
	
	public Student(String name, double totalQuizScore, int totalQuizes) {
		super();
		this.name = name;
		this.totalQuizScore = totalQuizScore;
		this.totalQuizes = totalQuizes;
	}
	public String getName() {
		return name;
	}
	public void addScore(int score) {
		totalQuizScore+=score;
		totalQuizes++;
	}
	public double getTotalScore() {
		return totalQuizScore;
	}
	public double getAverageScore() {
		return totalQuizScore/totalQuizes;
	}
	
}