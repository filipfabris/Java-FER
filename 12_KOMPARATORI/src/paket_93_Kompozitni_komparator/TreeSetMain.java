package paket_93_Kompozitni_komparator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

	// Kompozitni komparator

	public static void main(String[] args) {

		Comparator<Student> comparator = new CompositeComparator<>(Student.BY_FIRST_NAME.reversed(),
				Student.BY_FIRST_NAME, Comparator.naturalOrder()); // za comparator.naturalOrder() moramo imati u
																	// Student implmentiranu
		// comparable, ono radi natural order po studentId, pogledaj compareTo u STudent
		// klasi

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
