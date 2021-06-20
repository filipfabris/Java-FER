package zadatak4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;

public class DumpBinarryFileAsText {
	public static void main(String[] args) {

		Path p = Path.of("lyrics");

//		try (InputStream is = Files.newInputStream(p, StandardOpenOption.READ)) {
//
//			byte[] buff = new byte[1024];
//
//			while (true) {
//				int r = is.read(buff);
//				if (r < 1)
//					break;
////				String s = new String(buff, StandardCharsets.UTF_8);
//				String s = new String(buff, Charset.forName("UTF-8"));
//				System.out.printf("%s", s);
//
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		// TIPICNI IDIOM #1
//		try (BufferedReader br = new BufferedReader(
//				new InputStreamReader(new BufferedInputStream(new FileInputStream(p.toFile())), "UTF-8"))) {
//
//			String s;
//			while ((s = br.readLine()) != null) {
//				System.out.println(s);
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		// TIPICNI IDIOM #2 - FileReader
		try (BufferedReader br = new BufferedReader(new FileReader(p.toFile(), Charset.forName("UTF-8")))) {

			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
