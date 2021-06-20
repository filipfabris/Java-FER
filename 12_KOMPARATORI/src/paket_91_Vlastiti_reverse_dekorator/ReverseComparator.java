package paket_91_Vlastiti_reverse_dekorator;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

	private Comparator<T> original;

	public ReverseComparator(Comparator<T> original) {
		this.original = original;
	}

	@Override
	public int compare(T o1, T o2) {
		return -original.compare(o1, o2);
	}

}
