package Labos_zadatak2;

import java.util.Comparator;

public class TeamComparator implements Comparator<Team> {

	@Override
	public int compare(Team o1, Team o2) {

		if (o1.getName().equals(o2.getName())) {
			return 0;
		}

		int r;
		r = o1.ScoreSum().compareTo(o2.ScoreSum());
		if (r != 0) {
			return r;
		}

		r = -Integer.valueOf(o1.getLostGames()).compareTo(o2.getLostGames());
		if (r != 0) {
			return r;
		}

		r = Integer.valueOf(o1.getFans()).compareTo(o2.getFans());
		return r;

	}

}
