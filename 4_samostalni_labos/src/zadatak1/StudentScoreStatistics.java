package zadatak1;

import java.util.Collection;

public interface StudentScoreStatistics {
	public void addStudentScores(String student, Integer... scores);

	public Collection<String> getInsertionOrderedStudents();
	// Vraca kolekciju zabiljezenih studenata prema redoslijedu dodavanja.

	public Collection<Integer> getNaturallySortedPointsForStudent(String student);
	// vraca bodove za studenta, sortirane prema prirodnom poretku.

}
