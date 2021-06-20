package Auditorne_zadatak3;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		List<Person> persons = Loader.loadPerson();
		List<Bicycle> bicycles = Loader.loadBicycle();

//		Collections.sort(persons);
//		for (Person person : persons) {
//			System.out.println(person);
//		}

		Set<Person> sortedPersons = new TreeSet<>(persons);
		for (Person person : sortedPersons) {
			System.out.println(person);
		}

		System.out.println("**************--------------******************");

		Set<Bicycle> sortedBiycles = new TreeSet<>(
				Bicycle.BY_BRAND.thenComparing(Bicycle.BY_OWNER.reversed().thenComparing(Bicycle.BY_PRICE)));
		sortedBiycles.addAll(bicycles);
		for (Bicycle bike : sortedBiycles) {
			System.out.println(bike);
		}

	}
}