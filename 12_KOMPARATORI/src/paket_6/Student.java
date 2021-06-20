package paket_6;

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

	@Override
	public int compareTo(Student other) {
		return this.studentID.compareTo(other.studentID);
		// usporedujemo po ID-evima
		// pozivamo comparetTo od Stringa jer mozemo
		// zbog toga sto studentID je String

	}

}
