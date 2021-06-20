package zadatak6;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LabTaskV3 {

	public static int count(Map<Integer, Integer> map, Set<Integer> set) {

		Set<Integer> s1 = set;
		Set<Integer> s2 = new HashSet<>(map.values());

		s2.retainAll(s1);

		return s2.size();
	}
}