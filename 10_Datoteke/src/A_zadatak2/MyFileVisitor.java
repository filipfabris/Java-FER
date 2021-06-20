package A_zadatak2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.TreeSet;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

	private List<String> extensions;
	private long sum = 0;
	private TreeSet<Item> tenBiggest;

	public MyFileVisitor(List<String> extensions) {
		this.extensions = extensions;
		tenBiggest = new TreeSet<Item>();
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		for (String ext : extensions) {
			if (file.toString().endsWith(ext)) {
				long fileSize = attrs.size();
				sum = sum + fileSize;
				if (tenBiggest.size() >= 10) {
					if (tenBiggest.last().getSize() < fileSize) {
						tenBiggest.remove(tenBiggest.last());
						tenBiggest.add(new Item(file, fileSize));
					}
				} else {
					tenBiggest.add(new Item(file, fileSize));
				}
				break;
			}
		}

		return FileVisitResult.CONTINUE;
	}

	public long getSum() {
		return sum;
	}

	public TreeSet<Item> getTenBiggest() {
		return tenBiggest;
	}

}
