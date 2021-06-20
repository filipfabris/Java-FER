package Auditorne_zadatak3;

import java.util.Arrays;
import java.util.List;

public class Loader {
	public static List<Person> loadPerson() {
		List<Person> persons = Arrays.asList(new Person("QWE10975", "Ivan", "Horvat", 25, "Student"),
				new Person("ASD11796", "Petra", "Pavlović", 17, "Učenik"),
				new Person("YXC86327", "Sven", "Grgić", 67, "Umirovljenik"),
				new Person("GHJ08548", "Jasna", "Brkić", 20, "Student"),
				new Person("GHJ08543", "Jasna", "Brkić", 45, "Pravnikk"));
		return persons;
	}

	public static List<Bicycle> loadBicycle() {
		List<Person> persons = Loader.loadPerson();
		List<Bicycle> bicycles = Arrays.asList(new Bicycle("Pinarello", 1050, persons.get(0)),
				new Bicycle("Scott", 1200, persons.get(1)), new Bicycle("Rog", 1750, persons.get(2)),
				new Bicycle("Merida", 951, persons.get(3)), new Bicycle("Merida", 950, persons.get(3)));

		return bicycles;
	}
}