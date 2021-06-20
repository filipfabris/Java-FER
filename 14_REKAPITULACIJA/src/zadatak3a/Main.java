package zadatak3a;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import zadatak2.DistanceFromOrigin;
import zadatak2.Point;
import zadatak2.QuadrantPredicate;
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

		DistanceFromOrigin distance = new DistanceFromOrigin();

		List<String> newList = list.stream().filter(new QuadrantPredicate(true, true, false, true))
				.sorted(new PointComparator().reversed()).map(p -> {
					return String.format("dist(%s) = %.2f", p, distance.apply(p));
				}).collect(Collectors.toList());
		System.out.println(newList);
		// Ispis tocaka u jednom od kavdranata

		double averageQuadrantDistance = list.stream().filter(new QuadrantPredicate(true, false, false, false))
				.mapToDouble(p -> distance.apply(p)).average().getAsDouble();
		// Ispis prosjecne udaljenosti jednog od kvadranata
		System.out.println(averageQuadrantDistance);
		System.out.println();

		// ili
		OptionalDouble averageQuadrantDistanceOPTIONAL = list.stream()
				.filter(new QuadrantPredicate(false, false, false, false)).mapToDouble(p -> distance.apply(p))
				.average();
		// Ispis prosjecne udaljenosti jednog od kvadranata
		// KORISTIM OPCIONAL DOUBLE ZA REZULTAT STREAMA
		// I NA KRAJU KORISTIM IfPresentOrElse NAD TIM OBJEKTOM I VRACAM ISPIS
		averageQuadrantDistanceOPTIONAL.ifPresentOrElse((d) -> System.out.println(d),
				() -> System.out.println("No such element"));

	}

}
