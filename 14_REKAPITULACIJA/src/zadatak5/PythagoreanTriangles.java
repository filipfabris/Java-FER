package zadatak5;

import java.util.Iterator;
import java.util.NoSuchElementException;

import zadatak1.Ntuple;

public class PythagoreanTriangles implements Iterable<Ntuple<Integer>> {
	int a;
	int b;

	public PythagoreanTriangles(int a, int b) {
		if (a <= 0)
			throw new IllegalArgumentException("The first range value is not valid: " + a);
		if (b <= 0)
			throw new IllegalArgumentException("The second range value is not valid: " + b);

		this.a = a;
		this.b = b;

	}

	@Override
	public Iterator<Ntuple<Integer>> iterator() {

		return new PythagoreanIterator();
	}

	private class PythagoreanIterator implements Iterator<Ntuple<Integer>> {

		private boolean nextFound = false;
		private Ntuple<Integer> next = null;
		int x = 1;
		int y = 1;

		@Override
		public boolean hasNext() {
			if (nextFound) {
				return true;
			}
			return findNext();

		}

		private boolean findNext() {
			while (x <= a) {
				while (y <= b) {
					double z = Math.sqrt(x * x + y * y);
					if (Math.abs(Math.round(z) - z) < 1e-5) {
						next = new Ntuple<Integer>(x, y, (int) Math.round(z));
						nextFound = true;
					}
					y++;
					if (nextFound) {
						return true;
					}
				}
				x++;
				y = x;
			}
			return false;

		}

		@Override
		public Ntuple<Integer> next() {
			if (hasNext()) {
				nextFound = false;
				return next;
			} else {
				throw new NoSuchElementException();
			}
		}

	}

}
