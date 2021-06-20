package Auditorne8.zadatak2;

public class Score {

	private String name;
	private double score;

	public Score(String name, double score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", score=" + score + "]";
	}

}
