package zadatak3;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import zadatak2.Point;

public class MainTreeSetComposite {
	public static void main(String[] args) {
		Comparator<Point> comp = new PointComparator().thenComparing(Comparator.naturalOrder());

		Set<Point> set = new TreeSet<>(comp);
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
