package Auditorne8.zadatak4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Grades2 {

	Map<String, List<Integer>> gradesMap;
	// ime studenta i sve njegove ocijene

	public Grades2() {
		gradesMap = new HashMap<>();
	}

	public void add(String name, Integer grade) {
//		gradesMap.containsKey(name);
		List<Integer> values = gradesMap.get(name);
		// ako postoji vec Marko u mapi dobi cemo natrag listu odnosno vrijednost
		// Ako ne postoji dobit cemo null i to nam kaze da trebamo napraviti novi
		// element u mapi s novom listom

		if (values == null) {
			values = new LinkedList<Integer>();
			// stvaramo novi value odnosno listu
			gradesMap.put(name, values);
		}
		values.add(grade);
	}

	public void avgGrades() {
		double sum = 0;
		for (String name : gradesMap.keySet()) {
			double avgStud = 0;
			List<Integer> listaOcjena = gradesMap.get(name);
			for (Integer grade : listaOcjena) {
				avgStud = avgStud + grade;
			}
			avgStud = avgStud / listaOcjena.size();
			System.out.println(name + ": " + listaOcjena + " " + avgStud);
			sum = sum + avgStud;
		}
		System.out.println("Average grade: " + sum / gradesMap.size());
	}

	public static void main(String[] args) {
		Grades2 g = new Grades2();
		g.add("Marko", 5);
		g.add("Iva", 3);
		g.add("Ivana", 5);
		g.add("Mateo", 2);
		g.add("Mario", 1);

		g.avgGrades();
	}
}
