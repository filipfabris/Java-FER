package zadatak7;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class JavaProjectFileVisitor extends SimpleFileVisitor<Path> {

	Map<String, Long> output = new HashMap<>();

	public Map<String, Long> getProjectFileSizeInfo() {
		return output;

	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

		int index = file.toString().lastIndexOf(".");
		String extension = file.toString().substring(index);

//		System.out.println("File name: " + file.toString());
//		System.out.println("Parrent name: " + file.getParent());

		long size = attrs.size();
//		long size = Files.size(file);

		Long data = output.get(extension);
		if (data == null) {
			output.put(extension, size);
		} else {
			output.put(extension, size + data);

		}

		return FileVisitResult.CONTINUE;
	}

}
