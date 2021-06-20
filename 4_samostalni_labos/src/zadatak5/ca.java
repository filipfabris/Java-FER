package zadatak5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ca {
	public static Map<Integer, Set<String>> underpayed(Map<String, Map<Integer, List<Integer>>> salaries) {
		HashMap<Integer, HashMap<String, Integer>> avgSalary = new HashMap<>();
		Map<Integer, Set<String>> underpaid = new HashMap<>();

		for (String worker : salaries.keySet()) {

			for (int year : salaries.get(worker).keySet()) {
				int sum = 0;

				for (int salary : salaries.get(worker).get(year)) {
					sum += salary;
				}

				HashMap<String, Integer> ws = new HashMap<>();
				ws.put(worker, sum / 12);
				if (avgSalary.containsKey(year)) {
					ws.putAll(avgSalary.get(year));
				}
				avgSalary.put(year, ws);
			}
		}

		// ovdje iscitavam iz mape avgSalary i upisujem u underpaid ljude koji su
		// potplaceni
		for (int year : avgSalary.keySet()) {
			int yearSum = 0;
			int cnt = 0;
			for (String worker : avgSalary.get(year).keySet()) {
				yearSum += avgSalary.get(year).get(worker);
				cnt++;
			}

			Set<String> uppl = new HashSet<>();
			for (String worker : avgSalary.get(year).keySet()) {
				if (0.7 * yearSum / cnt > avgSalary.get(year).get(worker)) {
					uppl.add(worker);
				}
			}
			underpaid.put(year, uppl);
		}
		return underpaid;
	}

}
