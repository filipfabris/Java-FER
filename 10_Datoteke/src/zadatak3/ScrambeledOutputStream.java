package zadatak3;

import java.io.IOException;
import java.io.OutputStream;

public class ScrambeledOutputStream extends OutputStream {

	private OutputStream stream;
	private byte x;

	public ScrambeledOutputStream(OutputStream stream, byte x) {
		this.stream = stream;
		this.x = x;
	}

	@Override
	public void write(int b) throws IOException {
		stream.write(b ^ x); // XOR

	}

	@Override
	public void close() throws IOException {
		stream.close();
	}

}
