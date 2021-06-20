package Zadatak2_rjesenje;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FactorialIterator implements Iterator<Integer> {
	private int maxIt, currIt, num;

	public FactorialIterator(int maxNum) {
		if (maxNum < 0)
			throw new RuntimeException();
		currIt = num = 1;
		this.maxIt = maxNum;
	}

	@Override
	public boolean hasNext() {
		return currIt <= maxIt;
	}

	@Override
	public Integer next() {
		int ret = num;
		if (!hasNext())
			throw new NoSuchElementException();
		num = num * currIt++;
		return ret;
	}
}
