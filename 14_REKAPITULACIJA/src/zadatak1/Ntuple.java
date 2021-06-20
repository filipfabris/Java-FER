package zadatak1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ntuple<T extends Comparable<T>> implements Comparable<Ntuple<T>> {
	private List<T> data;

	public Ntuple(T first, T second, @SuppressWarnings("unchecked") T... others) {
		data = new ArrayList<>(others.length + 2);
		data.add(first);
		data.add(second);
		for (int i = 0; i < others.length; i++) {
			data.add(others[i]);
		}

	}

	public T get(int index) {
		return data.get(index - 1);
	}

	public void set(int index, T element) {
		data.set(index - 1, element);
	}

	public int size() {
		return data.size();
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ntuple)) {
			return false;
		}
		Ntuple<?> other = (Ntuple<?>) obj;
		if (size() != other.size()) {
			return false;
		}
		int size = size();
		for (int i = 0; i < size; i++) {
			if (!data.get(i).equals(other.data.get(i))) {
				return false;
				// Ako u if-u dode false !false = true
				// To znaci da je naden razlicit objekt unutra
			}
		}
		return true;

	}

	@Override
	public int compareTo(Ntuple<T> other) {
		int min = Math.min(size(), other.size());

		for (int i = 0; i < min; i++) {
			int r = data.get(i).compareTo(other.data.get(i));
			if (r != 0) {
				return r;
			}
		}

		return size() - other.size();
	}

//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("(");
//		for (int i = 0; i < size(); i++) {
//			sb.append(data.get(i));
//			if (i + 1 != size()) {
//				sb.append(", ");
//			}
//		}
//
//		sb.append(")");
//		return sb.toString();
//	}

	@Override
	public String toString() {
		return data.stream().map(e -> e.toString()).collect(Collectors.joining(", ", "(", ")"));
	}

}
