package Labos_Queen_zadatak1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayIterator implements Iterator<Integer> {
	private List<Integer> polje;
	private int current;
	private int max;

	public ArrayIterator(int[] array) {

		current = 0;
		max = array.length;
		polje = new ArrayList<>();

		for (int i : array) {
			polje.add(i);
		}

	}

	@Override
	public boolean hasNext() {
		return current < max;
	}

	@Override
	public Integer next() {
		int output = polje.get(current);
		if (!hasNext())
			throw new NoSuchElementException();
		current++;
		return output;
	}

}
