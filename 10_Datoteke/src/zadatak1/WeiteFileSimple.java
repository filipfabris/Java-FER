package zadatak1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class WeiteFileSimple {

	public static void main(String[] args) throws IOException {
		Path p = Path.of("newFile");
		Path p2 = Path.of("newFile2");

		// 1) PrintWriter
		// PrintWriter writer = new PrintWriter(p.toFile());
		// Ne moze appendat tekst ovako

		PrintWriter writer = new PrintWriter(new FileWriter("newFile", true));
		// Ovako se svaki put dodaje novi tekst na karj
		writer.println("Hello world!");
		writer.close();

		PrintWriter fileWriter = new PrintWriter(p2.toFile());
		fileWriter.write("Hello filewriter");
		fileWriter.close();

		// 2) FilesWriteString
//		Files.writeString(p2, "Hello World!!");

	}

}
