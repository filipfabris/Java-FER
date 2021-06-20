package paket_92_reverzni_API;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		int r = s1.getLastName().compareTo(s2.getLastName());
		if (r != 0) {
			return r;
		}

		r = s1.getFirstName().compareTo(s2.getFirstName());
		if (r != 0) {
			return r;
		}

		r = s1.getStudentID().compareTo(s2.getStudentID());
		return r;
	}

}
