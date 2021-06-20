package zadatak3;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScrambledMain {

	public static void readAndWrite(Path src, Path dst) {

		try (InputStream is = Files.newInputStream(src);
				ScrambeledOutputStream sos = new ScrambeledOutputStream(Files.newOutputStream(dst), (byte) 5)) {

			int b;
			while ((b = is.read()) != -1) {
				sos.write(b);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Path d1 = Path.of("lyrics");
		Path d2 = Path.of("lyricsScrambled");
		Path d3 = Path.of("lyricsUnScrambled");

		readAndWrite(d1, d2);
		readAndWrite(d2, d3);

	}

}
