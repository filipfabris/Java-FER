package Labos_zadatak1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class JavaProjectFileVisitor extends SimpleFileVisitor<Path> {

	long size = Long.MAX_VALUE;
	Path minFilePath;

	int numberOfFiles = Integer.MAX_VALUE;
	Path directory;

	public Path getMinFilePath() {
		return minFilePath;
	}

	public long getMinFileSize() {
		return size;
	}

	public Path getFewestFilesDirPath() {
		return directory;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

		long data = attrs.size();
		if (data < size) {
			size = data;
			minFilePath = file;
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		int count = 0;
		DirectoryStream<Path> ds = Files.newDirectoryStream(dir);
		for (Path p : ds) {
			count++;
			if (Files.isDirectory(p)) {
				count--;
			}

		}

		if (count >= 1 && count < numberOfFiles) {
			numberOfFiles = count;
			directory = dir;
		}

		return FileVisitResult.CONTINUE;
	}

}
