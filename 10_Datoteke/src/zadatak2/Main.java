package zadatak2;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {

		FileVisitor<Path> visitor = new MySimpleFileVisitor();
//		FileVisitor<Path> visitor = new MyFileVisitor();

		Path dir = Path.of("C:\\OOP");

		try {
			Files.walkFileTree(dir, visitor);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
