package zadatak3;

import java.util.Set;
import java.util.TreeSet;

import zadatak2.Point;

public class MainTreeSet {
	public static void main(String[] args) {
		Set<Point> set = new TreeSet<>(new PointComparator());
		addToSet(set);

		System.out.println("With PointComparator");
		System.out.println(set);
		System.out.println();

		System.out.println("With Natural Order");
		set = new TreeSet<>();
		addToSet(set);
		System.out.println(set);

	}

	private static void addToSet(Set<Point> set) {
		set.add(new Point(-5, 12));
		set.add(new Point(3, -4));
		set.add(new Point(12, 9));
		set.add(new Point(3, 4));
		set.add(new Point(4, 3));
		set.add(new Point(-9, 12));
		set.add(new Point(-5, -12));
	}

}
