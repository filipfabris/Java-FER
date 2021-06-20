package Zadatak3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Solution {

	public static Predicate<List<List<Integer>>> allDigitsMatch(double exemplar) {
		return new Predicate<List<List<Integer>>>() {

			@Override
			public boolean test(List<List<Integer>> t) {
				String numAsString = Double.valueOf(exemplar).toString();
				numAsString = numAsString.replace(".", "");

				for (List<Integer> inner : t) {

					// 1) nacin
					int index = inner.get(0);
					if (index < numAsString.length()
							&& inner.get(1).toString().charAt(0) != numAsString.charAt(index)) {
						return false;
					}

//					//2) nacin
//					int index = inner.get(0);
//					//Ako je index dobiven u Listi veći od duljine dobivenoh niza znakova baci FALSE
//					if (index >= numAsString.length()) {
//						return false;
//					}
//					
//					//Index je dobar, radim pretvorbu iz Stringa u int
//					int charNumber = Character.getNumericValue(numAsString.charAt(index));
//
//					//Ako su brojevi razliciti na istim indeksima baci FALSE
//					if (inner.get(1) != charNumber) {
//						return false;
//					}

				}

				// Inace TRUE
				return true;
			}
		};
	}

	public static Predicate<List<List<Integer>>> allDigitsDefined() {

		return new Predicate<List<List<Integer>>>() {

			@Override
			public boolean test(List<List<Integer>> t) {
				String index_counter = "";
				for (List<Integer> inner : t) {
					index_counter = index_counter + inner.get(0);
				}
				char[] polje = index_counter.toCharArray();
				Arrays.sort(polje);
				for (int i = 1; i < polje.length; i++) {
					if ((polje[i - 1] + 1) != polje[i]) {
						return false;
					}
				}
				return true;
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