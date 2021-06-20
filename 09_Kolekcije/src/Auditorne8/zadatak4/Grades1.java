package Auditorne8.zadatak4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Grades1 {

	Map<String, Integer> gradesMap;

	public Grades1() {
		gradesMap = new HashMap<>();
	}

	public void add(String name, Integer grade) {
		gradesMap.put(name, grade);
	}

	public void averageGrades() {
		double sum = 0;

		for (Entry<String, Integer> entry : gradesMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
			sum = sum + entry.getValue();
		}
		System.out.println("Average grade : " + sum / gradesMap.size());

	}

	public static void main(String[] args) {
		Grades1 g = new Grades1();
		g.add("Marko", 5);
		g.add("Ivan", 5);
		g.add("Ivana", 3);
		g.add("Mateo", 2);
		g.add("Mario", 1);

		g.averageGrades();

	}

}
