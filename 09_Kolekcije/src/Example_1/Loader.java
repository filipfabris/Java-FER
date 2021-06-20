package Example_1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Loader {

	public static List<Integer> load(Scanner sc) {
		LinkedList<Integer> list = new LinkedList<>();
		System.out.println("Unesite cijele brojeve");

		while (true) {
			Integer broj = sc.nextInt();
			if (broj < 0) {
				break;
			}
			list.add(broj);
		}

		return list;

	}

}
