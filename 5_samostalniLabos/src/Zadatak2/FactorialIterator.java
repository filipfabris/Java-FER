package Zadatak2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FactorialIterator implements Iterator<Integer> {
	int number;
	int generated;
	int num;

	public FactorialIterator(int number) {
		this.number = number;
		if (number < 0) {
			throw new RuntimeException();
		}
		generated = 1;
		num = 1;
	}

	@Override
	public boolean hasNext() {
		if (generated <= number) {
			return true;
		}
		return false;
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		int output = num;
		num = num * (generated++);
		return output;
	}

}
