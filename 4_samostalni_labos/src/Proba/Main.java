package Proba;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		File f = new File("Auto.txt");
		OutputStream os = new FileOutputStream(f);
		String txt = "BMV, Audi";
		byte[] bytes = txt.getBytes();
		os.write(bytes);
	}

}
