package ArrayLista;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String[] polje = new String[3];

		ArrayList<String> dinPolje = new ArrayList<>(3);
		// Koristi polje

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

	}

}
