package zadatak5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class LabTask {
	public static Map<Integer, Set<String>> underpayed(Map<String, Map<Integer, List<Integer>>> salaries) {

		HashMap<Integer, HashMap<String, Integer>> avgSalary = new HashMap<>();

		Map<Integer, Set<String>> underpaid = new HashMap<>();

		for (String worker : salaries.keySet()) {

			for (int year : salaries.get(worker).keySet()) {
				int sum = 0;

				for (int salary : salaries.get(worker).get(year)) {
					sum = sum + salary;
				}

				HashMap<String, Integer> ws = new HashMap<>();
				ws.put(worker, sum / 12);

				if (avgSalary.get(year) == null) {
					avgSalary.put(year, new HashMap<String, Integer>());
				}
				// Dodajem elemente u ws koji su vec u avgSalary mapi da ostali sacuvani
				// Jer novi put brise vačue od postojeceg kljuca
				// Sada kada sam dodao u ws prilikom unosa unosim vrijednost starog kljuca i
				// novu vrijednost ws-a izracunatu
				ws.putAll(avgSalary.get(year));
				avgSalary.put(year, ws);
			}
		}

		for (int year : avgSalary.keySet()) {
			int yearSum = 0;
			int brojac = 0;

			for (String worker : avgSalary.get(year).keySet()) {
				yearSum = yearSum + avgSalary.get(year).get(worker);
				brojac++;
			}
			int avrageSalaryPerYear = yearSum / brojac;

			Set<String> names = new HashSet<>();
			for (String worker : avgSalary.get(year).keySet()) {
				if (avgSalary.get(year).get(worker) < avrageSalaryPerYear * 0.7) {
					names.add(worker);

				}
			}
			underpaid.put(year, names);

		}

		return underpaid;

	}
}