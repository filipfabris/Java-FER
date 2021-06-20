package zadatak7;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class JavaProjectFileVisitorV2 extends SimpleFileVisitor<Path> {

	Map<String, Long> data = new HashMap<>();;

	public Map<String, Long> getProjectFileSizeInfo() {

		return data;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

		int index = file.getFileName().toString().lastIndexOf('.');
		String extension = file.getFileName().toString().substring(index);

		if (data.get(extension) == null)
			data.put(extension, 0L);

		Long pathData = data.get(extension);
		pathData += Files.size(file);
		data.put(extension, pathData);

		return FileVisitResult.CONTINUE;
	}
}
