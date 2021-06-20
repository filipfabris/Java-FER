package Uzivo_z1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

		if (file.getFileName().toString().endsWith(".pdf")) {
			System.out.println(file.getFileName() + " Size: " + attrs.size());
		}
		return FileVisitResult.CONTINUE;
	}

//	@Override
//	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//		System.out.println(dir.getFileName());
//
//		return FileVisitResult.CONTINUE;
//	}

}
