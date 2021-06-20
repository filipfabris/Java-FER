package hr.fer.oop.zadatak4;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int polje[] = new int[5];

		for (int i = 0; i < polje.length; i++) {
			polje[i] = i;
		}

		System.out.println(Arrays.toString(polje));

		// remove index 3

		int index = 3;

		for (int i = index; i < polje.length - 1; i++) {
			polje[i] = polje[i + 1];
		}

		System.out.println(Arrays.toString(polje));

	}

}
