package zadatak3;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class DumpBinaryFile {

	public static void main(String[] args) {

		Path p = Path.of("lyrics");

//		InputStream is1 = new FileInputStream(p.toFile());
//		InputStream is2 = Files.newInputStream(p, StandardOpenOption.READ);

//		1) nacin
//		try (InputStream is = Files.newInputStream(p, StandardOpenOption.READ)) {
//
//			int data;
//
//			while ((data = is.read()) != -1) { //read sprema po jedan znak
//				System.out.print(data + " "); // ASCII
//				System.out.printf("%02x ", data); // HEX
//				System.out.println();
//
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		2) nacin

		try (FileInputStream is = new FileInputStream(p.toFile())) {
			// InputStream is = Files.newInputStream(p, StandardOpenOption.READ
			byte[] buff = new byte[1024]; // Koliko byteova od jenom zelimo procitat

			while (true) {
				int r = is.read(buff); // u byte[] sprema procitano
				// vraca broj uspijesno procitanih
				if (r < 1)
					break;
				for (int i = 0; i < r; i++) {
					System.out.print(buff[i] + " ");
					System.out.printf("%02x ", buff[i]);
					System.out.println();
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
