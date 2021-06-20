package zadatak2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FileEditorV3 {

	public static void processFile(Path inputFile, Path outputFile) throws IOException {

		BufferedInputStream input = new BufferedInputStream(new FileInputStream(inputFile.toFile()));
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile.toFile()));

		// Ne cita retke ne radi
		int i = input.read();
		while (i != -1) {
			output.write(i);
			i = input.read();
		}
		output.flush();
		input.close();
		output.close();

	}

}
