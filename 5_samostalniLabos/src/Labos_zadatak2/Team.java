package Labos_zadatak2;

import java.util.Map;

public class Team {
	private String name;
	private Map<String, Integer> playersPower;
	private int lostGames;
	private int fans;

	public Team(String name, Map<String, Integer> playersPower, int lostGames, int fans) {
		this.name = name;
		this.playersPower = playersPower;
		this.lostGames = lostGames;
		this.fans = fans;
	}

	public String getName() {
		return name;
	}

	public Map<String, Integer> getPlayersPower() {
		return playersPower;
	}

	public int getLostGames() {
		return lostGames;
	}

	public int getFans() {
		return fans;
	}

	public Integer ScoreSum() {
		int sum = 0;
		for (String player : playersPower.keySet()) {
			sum = sum + playersPower.get(player);
		}

		return sum;

	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Team))
			return false;

		Team other = (Team) obj;
		return this.name.equals(other.name);
	}

}
