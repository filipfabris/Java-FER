package zadatak6;

import static java.util.Map.entry;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Examples {

	public static void main(String[] args) {

		Map<Integer, Integer> map = Map.ofEntries(

				entry(1, 2), entry(2, 8), entry(6, 3), entry(4, 2), entry(3, 6), entry(5, 4), entry(7, 7), entry(9, 1),
				entry(10, 6), entry(13, 8), entry(20, 1), entry(11, 3), entry(21, 0), entry(31, -3)

		);

		Set<Integer> set = new HashSet<Integer>() {

			{
				add(1);
				add(0);
				add(4);
				add(6);
			}
		};

		System.out.println(
				"Unutar vrijednosti mape imamo " + LabTaskV3.count(map, set) + " elemenata koji se pojavljuju u set-u");
	}
}
