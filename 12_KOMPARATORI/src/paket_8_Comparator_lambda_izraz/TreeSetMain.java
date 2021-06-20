package paket_8_Comparator_lambda_izraz;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

	// SADA UMJESTO COMPARABLE KORISTIMO COMPARATOR KOJI JE ZAPISAN KAO LAMBDA IZRAZ

	public static void main(String[] args) {
		Set<Student> students = new TreeSet<>(
				(Student s1, Student s2) -> s1.getStudentID().compareTo(s2.getStudentID()));

		// Jako dugacak kod
//		Common.fillStudentsCollection(students,
//				(String lastName, String firstName, String studentID) -> new Student(lastName, firstName, studentID));

		// Pozivako u klasi Student konstruktor jer on u toj klasi implementira to
		// sucelje ::new znaci metoda konstruktora
		Common.fillStudentsCollection(students, Student::new);
		System.out.println("Students: ");

//		Common.<Student>printCollection(students);
		// nije potrebno navesti parametrizaciju jer compailer skuzi iz argumenta jer je
		// isti parametar

		// Mozemo samo ovako
		Common.printCollection(students);

		Student s = new Student("Poe", "Edgar Allan", "2345678901");
		System.out.println("Poe present: " + students.contains(s));

	}
}
