package paket_93_then_Compaing;

import java.util.Comparator;

public class Student implements Comparable<Student> {
	private String lastName;
	private String firstName;
	private String studentID;

	public Student(String lastName, String firstName, String studentID) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.studentID = studentID;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getStudentID() {
		return studentID;
	}

	@Override
	public String toString() {
		return String.format("(%s) %s %s", studentID, firstName, lastName);
	}

	@Override
	public int compareTo(Student o) {
		return this.studentID.compareTo(o.studentID);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student))
			return false;

		Student other = (Student) obj;
		return this.studentID.equals(other.studentID);
	}

	@Override
	public int hashCode() {
		return studentID.hashCode();
	}

	// Default izrada Comparatora
//	private static final Comparator<Student> BY_LAST_NAME = (Student s1, Student s2) -> s1.lastName
//			.compareTo(s2.lastName);
//	private static final Comparator<Student> BY_FIRST_NAME = (Student s1, Student s2) -> s1.firstName
//			.compareTo(s2.firstName);
//	private static final Comparator<Student> BY_STUDENT_ID = (Student s1, Student s2) -> s1.studentID
//			.compareTo(s2.studentID);

	// Ili ovako, koristimo metodu Compatator.comparing , radi se o default metodi u
	// sucelju comparing
	public static final Comparator<Student> BY_LAST_NAME = Comparator.comparing(Student::getLastName);
	public static final Comparator<Student> BY_FIRST_NAME = Comparator.comparing(Student::getFirstName);
	public static final Comparator<Student> BY_STUDENT_ID = Comparator.comparing(Student::getStudentID);

}
