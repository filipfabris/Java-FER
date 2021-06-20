package Labos_zadatak2_Filip;

import java.io.IOException;
import java.nio.file.Path;

public class Examples {

	public static void main(String[] args) {

		Path inputFile = Path.of("exampleLinuxV3.txt");
		Path outputFile = Path.of("Win");

		try {
			FileEditor.processFile(inputFile, outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}