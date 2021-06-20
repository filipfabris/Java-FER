package Auditorne_zadatak3;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class Person implements Comparable<Person> {
	private String oib;
	private String lastName;
	private String firstName;
	private int age;
	private String status;

	public Person(String oib, String lastName, String firstName, int age, String status) {
		this.oib = oib;
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Person [oib=" + oib + ", lastName=" + lastName + ", firstName=" + firstName + ", age=" + age
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return oib.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person other = (Person) obj;
			return oib.equals(other.oib);
		}
		return false;
	}

	private static Comparator<Object> hrComparator = Collator.getInstance(Locale.forLanguageTag("hr"));

	@Override
	public int compareTo(Person other) {
		int r = hrComparator.compare(this.lastName, other.lastName);
		if (r != 0) {
			return r;
		}

		r = hrComparator.compare(this.firstName, other.firstName);
		if (r != 0) {
			return r;
		}

		r = this.oib.compareTo(other.oib);
		return r;
	}

}
