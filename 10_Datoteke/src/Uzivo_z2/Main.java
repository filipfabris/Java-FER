package Uzivo_z2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
	public static void main(String[] args) throws IOException {
		Path p = Path.of("C:\\Fizika");

		MyFileVisitor vistitor = new MyFileVisitor();
		Files.walkFileTree(p, vistitor);

		System.out.println(vistitor.getMap());

	}

}
