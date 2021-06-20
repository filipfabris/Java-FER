package Auditorne8.zadatak2;

import java.util.LinkedList;
import java.util.List;

public class JavelinScores {

	List<Score> scoreList;

	public JavelinScores() {
		scoreList = new LinkedList<>();
	}

	public void add(String name, double score) {
		Score s = new Score(name, score);
		int i;
		for (i = 0; i < scoreList.size(); i++) {
			if (score > scoreList.get(i).getScore()) {
				break;
			}
		}
		scoreList.add(i, s);
	}

	public void print() {
		for (Score s : scoreList) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		JavelinScores js = new JavelinScores();
		js.add("Sara", 68.43);
		js.add("Sara", 66.18);
		js.add("Steffi", 68.34);

		js.print();

	}

}
