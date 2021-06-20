package hr.fer.oop.zadatak3;

public class Block {
	public byte[] prevHash;
	public String[] transactions;
	public int size;
	public Hasher hasher;

	public Block(int max) {
		size = 0;
		transactions = new String[max];
		hasher = new SHAHasher();
	}

	public Block(int max, Hasher hasher) {
		size = 0;
		transactions = new String[max];
		this.hasher = hasher;
	}

	public byte[] getPrevHash() {
		return prevHash;
	}

	public void setPrevHash(byte[] prevHash) {
		this.prevHash = prevHash;
	}

	public int add(String transaction) {
		this.transactions[size] = transaction;
		size++;

		return size;
	}

	public void remove(int index) {
		for (int i = index; i < transactions.length - 1; i++) {
			transactions[i] = transactions[i + 1];
		}
		size--;
	}

	public byte[] hash(byte[] prevHash) {
		return hasher.hash(prevHash, this.transactions);
	}

}
