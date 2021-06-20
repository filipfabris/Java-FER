package hr.fer.oop.zadatak3;

public interface Hasher {
	public byte[] hash(byte[] prevHash, String[] transactions);
}
