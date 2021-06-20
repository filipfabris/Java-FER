package zadatak2;

import java.util.function.Predicate;

//ILI OVAKO
//public class QuadrantPredicate<T extends Number> implements Predicate<Pair<T>>
//ALI NIGDJE GASNIJE NE KORISTIMO T PA E BOLJE OVA DOLJNJA
public class QuadrantPredicate implements Predicate<Pair<? extends Number>> {

	private boolean[] quadrants;

	public QuadrantPredicate(boolean q1, boolean q2, boolean q3, boolean q4) {
		quadrants = new boolean[4];
		quadrants[0] = q1;
		quadrants[1] = q2;
		quadrants[2] = q3;
		quadrants[3] = q4;
	}

	@Override
	public boolean test(Pair<? extends Number> pair) { // TODO Auto-generated method stub
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

		if (quadrand == 0) {
			return false;
		}

		return quadrants[quadrand - 1];

	}

	@Override
	public String toString() {
		return String.format("Take points from quadrants 1-4? (%b, %b, %b, %b)", quadrants[0], quadrants[1],
				quadrants[2], quadrants[3]);
	}

}
