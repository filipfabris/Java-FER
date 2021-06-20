package A_zadatak2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// dohvacamo preko args, prvi podatak je putanja, ostali
		// ekstenzije

		List<String> extensions = new ArrayList<String>(List.of(args));
//		extensions.remove(0);
		MyFileVisitor visitor = new MyFileVisitor(extensions);

		try {
			Files.walkFileTree(Path.of(args[0]), visitor);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Ukupna velicina: " + visitor.getSum() / 1024 / 1024 + "MB");

		System.out.println("Najvecih 10 datoteka");
		for (Item i : visitor.getTenBiggest()) {
			System.out.println(i.getPath() + " : " + i.getSize());
		}

	}

}
