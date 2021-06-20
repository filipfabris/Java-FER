package hr.fer.oop.zadatak2;

public class Main {

	public static void main(String[] args) {
		Student student1 = new Student("Ana", "aaabb", 20);
		Student student5 = new Student("Mario", "bbb", 78);

		Student student2 = new Student("Kušek", "bbb", 15);
		Student student3 = new Student("Nino", "bbb", 56);

		Student student4 = new Student("Leo", "bbb", 55);

		Student students[] = { student1, student5, student2, student3, student4 };

		for (Student x : students) {
			System.out.println(x.toString());
		}

		Student.sortStudentsOnAge(students);
		System.out.println("\n Soritiranje \n");

		for (Student x : students) {
			System.out.println(x.toString());
		}

	}

}
