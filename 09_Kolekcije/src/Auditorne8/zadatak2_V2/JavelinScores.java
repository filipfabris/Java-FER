package Auditorne8.zadatak2_V2;

import java.util.Set;
import java.util.TreeSet;

public class JavelinScores {

	Set<Score> scoreSet;

	public JavelinScores() {
		this.scoreSet = new TreeSet<>();
		// zbog treeseta se podaci sortiraju
	}

	public void addSet(String name, double score) {
		scoreSet.add(new Score(name, score));
	}

	public void printSet() {
		for (Score s : scoreSet)
			System.out.println(s);
	}

	public static void main(String[] args) {
		JavelinScores js = new JavelinScores();

		js.addSet("Sara", 68.43);
		js.addSet("Sara", 66.18);
		js.addSet("Steffi", 68.34);

		js.printSet();

	}

}
