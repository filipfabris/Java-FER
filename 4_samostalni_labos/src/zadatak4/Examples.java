package zadatak4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

public class Examples {

	public static void main(String[] args) throws IOException {

		JavaProjectFileVisitor visitor = new JavaProjectFileVisitor(Set.of(".class")); // u trenutancnom direktoriju
																						// (direktoriju di se nalazi
																						// src, bin, classpath...)
																						// sam dodao jedan .pdf da
																						// vidimo da li se kod ponasa u
																						// skladu s ocekivanjima.
		File f = new File("src"); // stavio sam src umjesto folder1 jer nema potrebe da kreiram isti folder ko oni
									// kad i folder src moze
									// posluzit svrsi

		Files.walkFileTree(f.toPath(), visitor);
		// Tbh ne vidim svrhu ove linije i ove prethodne. Apsolutno nista ne
		// rade (ako cemo cisto
		// samo kod gledati). Ove dvije linije se slobodno mogu
		// zakomentirati i nista se nece promjeniti

		Map<String, Set<Path>> map = visitor.getProjectPathsPerExtension();
		for (String key : map.keySet()) {
			Set<Path> list = map.get(key);
			for (Path p : list)
				System.out.println("Key: " + key + " - " + p);
		}
	}
}
