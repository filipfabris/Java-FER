package zadatak7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class Examples {

	public static void main(String[] args) throws IOException {

		JavaProjectFileVisitor visitor = new JavaProjectFileVisitor();

		File f = new File("C:\\Users\\filip\\Downloads\\OOP4LabSamostalni\\src\\oop\\lab4\\solutions\\task5");

		Files.walkFileTree(f.toPath(), visitor);

		Map<String, Long> map = visitor.getProjectFileSizeInfo();

		for (String key : map.keySet()) {
			System.out.println("Key: " + key + " - " + map.get(key));
		}
	}
}
