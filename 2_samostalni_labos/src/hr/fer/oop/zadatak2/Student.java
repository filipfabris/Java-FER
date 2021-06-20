package hr.fer.oop.zadatak2;

class Student {
	private String name, surname;
	private int age;

	public Student(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;

	}

	@Override
	public String toString() {
		return "ime = " + name + ", godine =" + age;
	}

	static void sortStudentsOnAge(Student[] students) {

		int n = students.length;
		Student temp = null;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (students[j].getAge() < students[i].getAge()) {
					temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}

			}
		}
	}

}