package Labos_zadatak1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
	public static void main(String[] args) throws IOException {
		JavaProjectFileVisitor visitor = new JavaProjectFileVisitor();
		File f = new File("C:\\Users\\filip\\Documents\\folder1");
		Files.walkFileTree(f.toPath(), visitor);
		System.out.println(visitor.getMinFilePath()); // folder1/a.txt
		System.out.println(visitor.getMinFileSize()); // 10
		System.out.println(visitor.getFewestFilesDirPath()); // folder1

	}
}
