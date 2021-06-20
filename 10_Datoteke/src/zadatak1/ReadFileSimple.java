package zadatak1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class ReadFileSimple {

	public static void main(String[] args) throws IOException {

		File f = new File("lyrics");
		Path p = Path.of("lyrics");
		// Path p = f.toPath();

		// 1) Scanner();//////////////////////////////////
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			System.out.println(sc.nextLine());
		}

		System.out.println();
		System.out.println("***---------***");
		System.out.println();

		// 2) Files.readAlllines();////////////////////////////////
		List<String> lyricsList = Files.readAllLines(p);
		for (String s : lyricsList) {
			System.out.println(s);
		}

		System.out.println();
		System.out.println("***---------***");
		System.out.println();

		// 3) Files.readString();/////////////////////////////////////
		String lyricsString = Files.readString(p);
		System.out.println(lyricsString);
		// Sve kopira u jedan String

	}

}
