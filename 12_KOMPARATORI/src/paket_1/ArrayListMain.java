package paket_1;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {

	// POPRAVLJEN EQUALS I RADI

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();

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
