package Auditorne8.zadatak3;

import java.util.HashSet;
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

	public void printBest() {
		var printed = new HashSet<String>(); // pomocni ste
		for (Score score : scoreSet) {
			// poukusvamo ubaciti name u printed
			if (printed.add(score.getName())) {
				// idemo po vec sortiranom setu
				// pa prvi ispis je najbolji
				System.out.println(score);
			}

		}
	}

	public static void main(String[] args) {
		JavelinScores js = new JavelinScores();

		js.addSet("Sara", 68.43);
		js.addSet("Sara", 66.18);
		js.addSet("Steffi", 68.34);

		js.printSet();

		System.out.println();

		js.printBest();

	}

}
