package paket_93_then_Compaing;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import paket_93_Kompozitni_komparator.Student;

public class TreeSetMain {

	// Kompozitni komparator

	public static void main(String[] args) {

		Comparator<Student> comparator = Student.BY_FIRST_NAME.reversed().thenComparing(Student.BY_LAST_NAME)
				.thenComparing(Comparator.naturalOrder());

		Set<Student> students = new TreeSet<>(comparator);

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
