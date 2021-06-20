package Labos_zadatak2;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Map<String, Integer> playersPowerFirst = new TreeMap<>();
		playersPowerFirst.put("Jasna", 60);
		playersPowerFirst.put("Petra", 70);
		Team first = new Team("First", playersPowerFirst, 10, 200);

		Map<String, Integer> playersPowerBest = new TreeMap<>();
		playersPowerBest.put("Marica", 1);
		playersPowerBest.put("Matea", 55);
		Team theBest = new Team("theBest", playersPowerBest, 10, 200);

		TeamComparator teamComparator = new TeamComparator();
		TreeSet<Team> teams = new TreeSet<>(teamComparator);
		teams.add(first);
		teams.add(theBest);

		System.out.println(teams.last().equals(first)); // 130 > 56
		System.out.println(teams.size());
		System.out.println(teams.add(new Team("theBest", new TreeMap<>(), 11, 30)));
		System.out.println(teams.size());

	}

}
