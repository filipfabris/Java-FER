package zadatak2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MySimpleFileVisitor extends SimpleFileVisitor<Path> {

	int level = 0;

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		for (int i = 0; i < level; i++)
			System.out.printf("-");
		System.out.println(dir.getFileName());
		level++;
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (file.toString().endsWith(".java") || Files.isDirectory(file)) {
			for (int i = 0; i < level; i++)
				System.out.printf(" ");
			System.out.printf("%s (%d bytes) [%s]\n", file.getFileName(), attrs.size(),
					// Files.size(file)
					attrs.creationTime());
		}

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		level--;
		return FileVisitResult.CONTINUE;
	}

}
