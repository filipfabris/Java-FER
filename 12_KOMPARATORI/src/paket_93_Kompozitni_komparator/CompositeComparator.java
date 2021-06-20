package paket_93_Kompozitni_komparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompositeComparator<T> implements Comparator<T> {

	private List<Comparator<T>> comparators;

	public CompositeComparator(List<Comparator<T>> comparators) {

		// Ovo je klasika, samo sam mu pridodijelio ArrayList
		this.comparators = new ArrayList<>();

		// Punim ArrayListu sa elementima koje smo dobili
		// Konstruktorom
		this.comparators.addAll(comparators);
	}

	@SafeVarargs
	public CompositeComparator(Comparator<T>... comparators) {

		// Ovo je klasika, samo sam mu pridodijelio ArrayList
		this.comparators = new ArrayList<>();

		// Ovdje sada punim ArrayList sa elementima
		// Koje sam dobio u polju zato korstim posebn metodu
		// Iz collections-a
		Collections.addAll(this.comparators, comparators);

	}

	@Override
	public int compare(T o1, T o2) {
		for (Comparator<T> comparator : comparators) {
			int r = comparator.compare(o1, o2);
			if (r != 0) {
				return r;
			}
		}

		return 0;

	}

}
