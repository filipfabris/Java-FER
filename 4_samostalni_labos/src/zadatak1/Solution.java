package zadatak1;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution implements StudentScoreStatistics {

	Map<String, List<Integer>> studentDatabase = new LinkedHashMap<>();

	@Override
	public void addStudentScores(String student, Integer... scores) {
		Arrays.sort(scores);
		studentDatabase.put(student, Arrays.asList(scores));

	}

	@Override
	public Collection<String> getInsertionOrderedStudents() {

		Collection<String> names;
		names = studentDatabase.keySet();
		return names;

	}

	@Override
	public Collection<Integer> getNaturallySortedPointsForStudent(String student) {

		Collection<Integer> scores;

		if (studentDatabase.containsKey(student)) {
			scores = studentDatabase.get(student);
			return scores;
		}

		else {
			return null;
		}

	}

}
