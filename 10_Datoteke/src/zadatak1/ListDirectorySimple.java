package zadatak1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Files;
import java.nio.file.Path;

class FileFilter implements Filter<Path> {

	@Override
	public boolean accept(Path entry) throws IOException {
//		if (entry.toString().endsWith(".java") || entry.toString().endsWith(".class") || Files.isDirectory(entry)) {
//			return true;
//		}

		if (entry.toString().endsWith(".java") || Files.isDirectory(entry)) {
			return true;
		}
		return false;
	}

}

public class ListDirectorySimple {

	public static void listDir(Path dir, int level) throws IOException {

		FileFilter filter = new FileFilter();

		DirectoryStream<Path> ds = Files.newDirectoryStream(dir, filter);

		for (Path p : ds) {
			System.out.printf("|");
			if (Files.isDirectory(p)) {
				for (int i = 0; i < level; i++)
					System.out.printf("-");
				System.out.printf("%s\n", p.getFileName());
				listDir(p, level + 1);
				// Zasto level++ ne radi
			} else {
				for (int i = 0; i < level; i++)
					System.out.printf(" ");
				System.out.printf("%s (%d)\n", p.getFileName(), Files.size(p));

			}
		}

	}

	public static void main(String[] args) throws IOException {
		Path dir = Path.of("C:\\Users\\filip\\Desktop\\FER materijali\\Objektno programiranje\\3. samostalni labos");
		Path dir2 = Path.of(
				"C:\\Users\\filip\\Desktop\\FER materijali\\Objektno programiranje\\Lectures-master\\Lectures-master\\10_InputOutput");

//		DirectoryStream<Path> ds = Files.newDirectoryStream(dir);
//		for (Path p : ds) {
//			System.out.printf("%s %s (%d)\n", Files.isDirectory(p) ? "D" : " ", p.getFileName(), Files.size(p));

		System.out.println(dir.toAbsolutePath());
		listDir(dir2, 0);
	}

}
