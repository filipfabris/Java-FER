package zadatak3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class LogProcessorV3 {

	private Path file;
	private List<LogEntry> logs;

	LogProcessorV3(Path file) {

		this.file = file;
		logs = new ArrayList<>();
	}

	public void load() throws IOException {

		for (String line : Files.readAllLines(file))
			logs.add(parseLog(line));
	}

	public List<LogEntry> getLogs() {

		return logs;
	}

	public static LogEntry parseLog(String line) {

		String[] splittedLine = line.split("\s++"); // Ovo je regex komanda pomocu koje JVM-u kazem da makne jedan ili
													// vise space i
													// tamo gdje su bili ti space-ovi tu splita i pospremi u array
													// splittedLine.
													// Npr. Imamo "Luka voli Marinu". Ovo ce se pohraniti u splittedLine
													// u obliku
													// ["Luka", "voli", "Marinu"].

		String[] splittedText = line.split(" : "); // Ovo cemo koristiti za text atribut. Primjetite da svaki redak
													// sadrzi " : " taman
													// prije pocetka argumenta text. Moguce je zatim da unutar samog
													// atributa text cemo imati
													// vise " : " i metoda split ce i to splitat (sto ne zelimo). U
													// iducim programskim
													// linijama cu napisati StringBuilder koji ce ovo popraviti

		String text; // Ovdje cemo pohraniti ispravno parsirani atribut text

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < splittedText.length; i++) {
			if (i < splittedText.length - 1)
				sb.append(splittedText[i] + " : ");
			else
				sb.append(splittedText[i]); // Ovdje osiguravamo da kad smo na zadnjem elementu liste splittedText JVM
											// ne doda jos jedan " : "
		}
		text = sb.toString();

		return new LogEntry(splittedLine[0] + " " + splittedLine[1], splittedLine[2],
				splittedLine[7].substring(0, splittedLine[7].length() - 1), text); // Za treci argument ide substring da
																					// se rijesimo zatvarajuce zagrade
	}
}
