package zadatak3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		Path inputFile = Path.of("log.txt");
		LogProcessor processor = new LogProcessor(inputFile);
		processor.load();
		List<LogEntry> logs = processor.getLogs();

		for (LogEntry entry : logs)
			System.out.println(entry);

	}

}
