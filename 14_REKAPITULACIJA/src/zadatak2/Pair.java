package zadatak2;

import zadatak1.Ntuple;

public class Pair<T extends Comparable<T>> extends Ntuple<T> {

	@SuppressWarnings("unchecked")
	public Pair(T first, T second) {
		super(first, second);

	}

	public T getX() {
		return get(1);
	}

	public void setX(T value) {
		set(1, value);
	}

	public T getY() {
		return get(2);
	}

	public void setY(T value) {
		set(2, value);
	}
}
