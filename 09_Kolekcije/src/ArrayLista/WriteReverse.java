package ArrayLista;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class WriteReverse {

	public static void writeReverseArray(String[] args) {
		for (int i = args.length - 1; i > 0; i--) {
			boolean vecIspisan = false;
			for (int j = i + 1; j < args.length; j++) {
				if (args[i].equals(args[j])) {
					vecIspisan = true;
					break;
				}
			}

			if (!vecIspisan) {
				System.out.print(args[i] + " ");
			}
		}
		System.out.println();
	}

	public static void writeReverseListAndSet(String[] args) {
		List<String> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for (int i = args.length - 1; i > 0; i--) {
			if (set.add(args[i])) {
				list.add(args[i]);
			}
		}
		System.out.println(list);

	}

	public static void writeReverseSetOnly(String[] args) {
		Set<String> set = new LinkedHashSet<>();
		for (int i = args.length - 1; i > 0; i--) {
			set.add(args[i]);
		}
		System.out.println(set);

	}

	public static void main(String[] args) {
		System.out.println("Array:");
		writeReverseArray(args);

		System.out.println();

		System.out.println("Array with Set: ");
		writeReverseListAndSet(args);

		System.out.println();

		System.out.println("LinkedHashSet: ");
		writeReverseSetOnly(args);

	}

}
