package Example_1;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

	static double calculateAverage(List<Integer> list) {
		double limit = 0;
		for (Integer i : list) {
			limit = limit + i;
		}
		return limit / list.size();

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Integer> list = Loader.load(sc);
		double avg = calculateAverage(list);
		System.out.println(avg);

		Predicate<Integer> filter = new BelowThreshold(avg);
		list.removeIf(filter);

		Collections.sort(list);
		System.out.println(list);

	}

}
