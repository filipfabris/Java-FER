package zadatak3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LogProcessor {

	Path file;
	List<LogEntry> logs = new ArrayList<>();

	public LogProcessor(Path file) {
		this.file = file;
	}

	public void load() throws IOException {

		LogEntry entry;
		for (String line : Files.readAllLines(file)) {
			entry = parseLog(line);
			logs.add(entry);
		}

	}

	public List<LogEntry> getLogs() {
		return logs;
	}

	public static LogEntry parseLog(String line) {
		String[] polje = line.split("\\s+");

		return new LogEntry(polje[0] + " " + polje[1], polje[2], polje[7].substring(0, polje[7].length() - 1),
				polje[10] + " " + polje[11] + " " + polje[12]);

		// return new LogEntry(splittedLine[0] + " " + splittedLine[1], splittedLine[2],
		// splittedLine[7].substring(0, splittedLine[7].length()-1), line.split(" :
		// ")[1]);

	}

}
