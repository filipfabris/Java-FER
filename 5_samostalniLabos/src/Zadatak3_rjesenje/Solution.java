package Zadatak3_rjesenje;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Solution {

	public static Predicate<List<List<Integer>>> allDigitsMatch(double num) {
		return new Predicate<List<List<Integer>>>() {
			@Override
			public boolean test(List<List<Integer>> t) {
				String[] numSplit = Double.valueOf(num).toString().split("\\.");
				String numAsString = numSplit[0].charAt(numSplit[0].length() - 1) + numSplit[1];

				for (List<Integer> it : t) {
					int index = it.get(0);

					if (index < numAsString.length() && numAsString.charAt(index) != it.get(1).toString().charAt(0))
						return false;
				}
				return true;
			}
		};
	}

	public static Predicate<List<List<Integer>>> allDigitsDefined() {
		return new Predicate<List<List<Integer>>>() {
			@Override
			public boolean test(List<List<Integer>> t) {
				int min = 32, max = 0;
				for (List<Integer> it : t) {
					min = Math.min(min, it.get(0));
					max = Math.max(max, it.get(0));
				}
				return (max - min + 1) == t.size();
			}
		};
	}

	public static void main(String[] args) {
		List<List<Integer>> ulaz1 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(0, 3), Arrays.asList(2, 6)); // 3.26
		List<List<Integer>> ulaz2 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(0, 3), Arrays.asList(4, 6)); // 3.2**6
		boolean t1 = Solution.allDigitsMatch(3.266).test(ulaz1); // true
		boolean t2 = Solution.allDigitsDefined().test(ulaz1); // true
		boolean t3 = Solution.allDigitsMatch(3.266).test(ulaz2); // true
		boolean t4 = Solution.allDigitsDefined().test(ulaz2); // false
		System.out.println(t1 + " " + t2);
		System.out.println(t3 + " " + t4);
	}
}
