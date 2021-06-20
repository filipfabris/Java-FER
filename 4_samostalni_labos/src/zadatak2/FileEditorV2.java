package zadatak2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileEditorV2 {

	public static void processFile(Path inputFile, Path outputFile) throws IOException {

		List<String> allLinesInFile = Files.readAllLines(inputFile, StandardCharsets.UTF_8);

		BufferedWriter writer = Files.newBufferedWriter(outputFile, StandardCharsets.UTF_8);

		for (String line : allLinesInFile) {
			writer.write(line + "\n");
		}

		writer.close();

	}
}
