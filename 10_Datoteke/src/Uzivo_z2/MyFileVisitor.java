package Uzivo_z2;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

	Map<String, Integer> map = new HashMap<>();

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		String fileName = file.getFileName().toString();

		String extString;
		int index = fileName.lastIndexOf(".");
		extString = fileName.substring(index + 1).toUpperCase();
//		System.out.println(extString);

		Integer value = map.get(extString);
		map.put(extString, value == null ? 1 : value + 1);

		if (extString.equals("JAVA")) {
			Writer bw = new BufferedWriter(
					new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file.toFile())), "UTF-8"));
//			String line = bw.write(line);
		}

		return FileVisitResult.CONTINUE;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

}
