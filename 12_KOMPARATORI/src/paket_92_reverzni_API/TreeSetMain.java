package paket_92_reverzni_API;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

	// Izradujem ReverseComparatot tj. DEKORATOR
	// Reverse comparatoru predajemu refeencu orginanog comparatora
	// Pogledaj new TreeSet<>(......);

	public static void main(String[] args) {

		// Koristim default metodu iz Comparator sucelja
//		Set<Student> students = new TreeSet<>(new StudentComparator().reversed());

		// Koristim staticku metodu iz Collections
		Set<Student> students = new TreeSet<>(Collections.reverseOrder(new StudentComparator()));

		// Ako ovako koritim u Students mora biti implementirana Comparable sučelje!
//		Set<Student> students = new TreeSet<>(Collections.reverseOrder());

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
