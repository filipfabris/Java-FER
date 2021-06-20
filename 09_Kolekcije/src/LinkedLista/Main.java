package LinkedLista;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		LinkedList<String> dinPolje = new LinkedList<>();

		dinPolje.add("volim");
		dinPolje.add("programirati");
		dinPolje.add("!");
		dinPolje.add(0, "Ne"); // Na index 0 stavjamo String
		// Dolazi do automatskog pomaka
		dinPolje.remove(0); // Uklonimo index 0;
		dinPolje.set(1, "bananko"); // metoda zamjenjuje element na indexu 0 sa novi

		System.out.println(dinPolje.get(2));
		// Dohvaćamo element na indexu 2

		System.out.println(dinPolje);
		System.out.println(dinPolje.size());

		for (int i = 0; i < dinPolje.size(); i++) {
			System.out.println(dinPolje.get(i));
		}

		for (String s : dinPolje) {
			System.out.println(s);
		}

	}

}
