package Uzivo_z1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class CitanjeMain {
	public static void main(String[] args) {

		File f = new File("lyrics");
		Path p = f.toPath();

		try {
			InputStream is = new FileInputStream(f);
			byte[] buff = new byte[1024];
			String text;
			while (true) {
				int r = is.read(buff);
				if (r < 1)
					break;
				text = new String(buff, StandardCharsets.UTF_8);
				System.out.println(text);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
