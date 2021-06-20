package zadatak3;

import java.util.Comparator;

import zadatak2.DistanceFromOrigin;
import zadatak2.Point;

public class PointComparator implements Comparator<Point> {
	private static DistanceFromOrigin DISTANCE = new DistanceFromOrigin();

	@Override
	public int compare(Point o1, Point o2) {
		double d1 = DISTANCE.apply(o1);
		double d2 = DISTANCE.apply(o2);

		return Double.valueOf(d1).compareTo(d2);

	}

}
