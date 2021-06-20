package zadatak2;

import java.io.IOException;
import java.nio.file.Path;

public class Examples {

	public static void main(String[] args) {

		Path inputFile = Path.of("exampleWindows.txt");
		Path outputFile = Path.of("exampleLinuxV3.txt");

		try {
			FileEditorV2.processFile(inputFile, outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// NOTE: Za provjeru dal ovaj kod radi kako spada odite u root direktorij ovog
		// projekta (direktorij di je src, bin,...) i naci cete tamo file
		// exampleLinux.txt
		// Otvorite ga i otvorite exampleWindows.txt pomocu Windows Notepada ili
		// Notepada++ ili geany-a na Linux-u. U donjem desnom uglu na Windowsima ili
		// donjem sredisnjem
		// dijelu na Linux-u kad usporedite te dvije datoteke cete primjetiti razliku.
		// Za exampleLinux.txt ce pisat Unix(LF) dok ce za exampleWindows.txt pisati
		// Windows(CRLF).
		// Shodno tomu imamo dokaz da ovaj kod funkcionira tj. konvertirao je iz Windows
		// formata u Unix format
	}
}