package Labos_zadatak1_Filip;

import java.util.HashMap;
import java.util.Map;

public class TataSteel {

	static Map<String, Integer> countAttendance(Map<Integer, Map<String, Double>> tataSteelStandings) {

		Map<String, Integer> output = new HashMap<>();

		for (int year : tataSteelStandings.keySet()) {
			for (String name : tataSteelStandings.get(year).keySet()) {

				if (output.get(name) == null) {
					output.put(name, 1);
				} else {
					int count = output.get(name) + 1;
					output.put(name, count);
				}
			}
		}

		return output;

	}

}
