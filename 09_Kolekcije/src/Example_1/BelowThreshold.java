package Example_1;

import java.util.function.Predicate;

public class BelowThreshold implements Predicate<Integer> {

	private double treshold;

	public BelowThreshold(double treshold) {
		this.treshold = treshold;
	}

	@Override
	public boolean test(Integer t) {
		if (t < treshold) {
			return true;
		} else {
			return false;
		}
	}

}
