package zadatak4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import zadatak2.Point;
import zadatak3.PointComparator;

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

		Map<Integer, Set<Point>> map = new TreeMap<>();
		Comparator<Point> comp = new PointComparator().thenComparing(Comparator.naturalOrder());
		map.put(1, new TreeSet<>(comp));
		map.put(2, new TreeSet<>(comp));
		map.put(3, new TreeSet<>(comp));
		map.put(4, new TreeSet<>(comp));

		for (Point p : list) {
			int quadrant = detectQuadrant(p);
			if (quadrant != 0) {
				map.get(quadrant).add(p);
			}
		}

		System.out.println(map);

	}

	private static int detectQuadrant(Point pair) {
		int quadrand = 0;
		if (pair.getX().doubleValue() > 0 && pair.getY().doubleValue() > 0) {
			quadrand = 1;
		} else if ((pair.getX().doubleValue() < 0 && pair.getY().doubleValue() > 0)) {
			quadrand = 2;
		} else if ((pair.getX().doubleValue() < 0 && pair.getY().doubleValue() < 0)) {
			quadrand = 3;
		} else if ((pair.getX().doubleValue() > 0 && pair.getY().doubleValue() < 0)) {
			quadrand = 4;
		}
		return quadrand;
	}

}
