package zadatak2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;

public class FileEditor {

	public static void processFile(Path inputFile, Path outputFile) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(inputFile.toFile(), Charset.forName("UTF-8")));
		String s;

		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile.toFile(), Charset.forName("UTF-8")));

		while ((s = br.readLine()) != null) {
			System.out.println(s);
			bw.write(s + "\n");
		}

		br.close();
		bw.close();

	}

}
