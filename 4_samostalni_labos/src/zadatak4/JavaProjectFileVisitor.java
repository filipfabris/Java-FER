package zadatak4;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JavaProjectFileVisitor extends SimpleFileVisitor<Path> {

	Set<String> extensionFilter;
	Map<String, Set<Path>> data = new HashMap<>();;

	public JavaProjectFileVisitor(Set<String> extensionFilter) {
		this.extensionFilter = extensionFilter;
	}

	public Map<String, Set<Path>> getProjectPathsPerExtension() throws IOException {

		return data;

	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

		int index = file.getFileName().toString().lastIndexOf(".");
		String extension = file.getFileName().toString().substring(index);

		if (extensionFilter.contains(extension)) {
			return FileVisitResult.CONTINUE;
		}

		if (data.get(extension) == null) {
			data.put(extension, new HashSet<>());
		}

		Set<Path> pathData = data.get(extension);

		pathData.add(file);
		data.put(extension, pathData);

		return FileVisitResult.CONTINUE;
	}

}
