package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> map = new HashMap<>();

		System.out.println("Unesite imena, quit za kraj");

		while (true) {
			String name = sc.nextLine();
			if (name.equals("quit")) {
				break;
			}

			Integer val = map.get(name);
			map.put(name, val == null ? 1 : val + 1);
		}

		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}

		System.out.println();

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

}
