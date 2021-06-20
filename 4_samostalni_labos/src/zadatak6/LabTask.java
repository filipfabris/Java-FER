package zadatak6;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LabTask {
	public static int count(Map<Integer, Integer> map, Set<Integer> set) {
		int counter = 0;
		Set<Integer> brojac = new HashSet<>(set);

		for (Integer i : map.keySet()) {
			if (!brojac.add(i)) {
				counter++;
			}
			brojac.remove(i);
		}

		return counter;

	}
}

class LabTaskV2 {

	public static int count(Map<Integer, Integer> map, Set<Integer> set) {

		int counter = 0;

		Set<Integer> setClone = new HashSet<>(set);

		for (Integer value : map.values()) // map.values() mi dohvaca sve vrijednosti iz mape map

			if (setClone.contains(value)) {
				counter++;
				setClone.remove(value);

			}

		return counter;
	}
}