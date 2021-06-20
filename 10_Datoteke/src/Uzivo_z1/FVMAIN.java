package Uzivo_z1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FVMAIN {

	public static void main(String[] args) throws IOException {

		MyFileVisitor visitor = new MyFileVisitor();
		Path root = Path.of("C:\\Fizika");

		Files.walkFileTree(root, visitor);

	}

}
