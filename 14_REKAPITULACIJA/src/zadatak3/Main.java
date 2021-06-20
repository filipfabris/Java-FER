package zadatak3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import zadatak2.Point;

public class Main {
	public static void main(String[] args) {

		List<Point> list = new ArrayList<>();
		list.add(new Point(-5, 12));
		list.add(new Point(3, -4));
		list.add(new Point(12, 9));
		list.add(new Point(3, 4));
		list.add(new Point(4, 3));
		list.add(new Point(-9, 12));
		list.add(new Point(-5, -12));

		System.out.println("Original list\n" + list);
		System.out.println();

		Comparator<Point> comp = new PointComparator();
		list.sort(comp);
		System.out.println("Sorted list\n" + list);
		System.out.println();

		list.sort(Comparator.naturalOrder());
		System.out.println("Narural order sorted list\n" + list);
		System.out.println();

	}
}
