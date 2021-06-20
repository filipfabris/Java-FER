package zadatak1;

public class Examples {

	public static void main(String[] args) {

		Solution stat = new Solution();

		stat.addStudentScores("Luka", 4, 1, 2);
//		stat.addStudentScores("Luka", 1, 4); 	//da sam ovu liniju ostavio odkomentiranu onda bi ova linija izbrisala gornju iz mape
		stat.addStudentScores("Mario", 5, 3, 4);
		stat.addStudentScores("Nika", 2, 5, 5, 3, 4);
		stat.addStudentScores("Matea", 4, 5, 5, 5, 1);
		stat.addStudentScores("Nikola", 3, 3, 3, 3, 3, 3);

		System.out.println("U bazi podataka trenuta�no imamo sljede�e studente (poredani po redoslijedu upisa):");
		for (String name : stat.getInsertionOrderedStudents())
			System.out.println(name);

		System.out.println();

		System.out.println("Za studenticu Mateu bodovi su sljede�i (poredani od najmanjeg prema najvi�em):");

		for (Integer score : stat.getNaturallySortedPointsForStudent("Matea"))
			System.out.println(score);

		System.out.println();

		System.out.println("Za studenta Luku bodovi su sljede�i (poredani od najmanjeg prema najvi�em):");

		for (Integer score : stat.getNaturallySortedPointsForStudent("Luka"))
			System.out.println(score);
	}
}
