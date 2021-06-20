package Auditorne8.zadatak1;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

	public static <T> Set<T> setUnion(Set<T> set1, Set<T> set2) {
		Set<T> set = new HashSet<>(set1);
		set.addAll(set2);
		// dodaje sve u set i ne moze biti duplikata -> unija

		return set;

	}

	public static <T> Set<T> setIntersection(Set<T> set1, Set<T> set2) {
		Set<T> set = new HashSet<>(set1);
		set.retainAll(set2);
		// zadrzava elemente samo one elemente koji se nalaze i u
		// parametru set2, oni koji su zajednicki

		return set;
	}

	public static <T> Set<T> setDifference(Set<T> set1, Set<T> set2) {
		Set<T> set = new HashSet<>(set1);
		set.removeAll(set2);

		return set;
	}

	public static void main(String[] args) {
		var set1 = Set.of(1, 2, 3, 4, 5);
		var set2 = Set.of(3, 4, 5, 6, 7);

		System.out.println(setUnion(set1, set2));
		System.out.println(setIntersection(set1, set2));
		System.out.println(setDifference(set1, set2));
	}

}
