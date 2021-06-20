package Zadatak1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

abstract class Game {
	private String name;
	private int rating;

	protected Game(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return name + ":" + rating;
	}
}

abstract class Player {
	private String name;

	protected Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	abstract void addGameScore(Game game, int score);

	abstract Iterable<Integer> getScores(Game game);
}

class Factory extends Game {

	protected Factory(String name, int rating) {
		super(name);
		this.setRating(rating);
	}

	public static Game createGame(String game, int rating) {
		return new Factory(game, rating);
	}

}

class MyPlayer extends Player implements Iterable<Game> {
	private Map<Game, ArrayList<Integer>> games;
	private Comparator<Game> MY_COMPARATOR = (Game g1, Game g2) -> g1.getName().compareTo(g2.getName());

	public MyPlayer(String name) {
		super(name);
		games = new TreeMap<>(MY_COMPARATOR);
	}

	public void addGameScore(Game g, int sc) {
		if (games.get(g) == null) {
			games.put(g, new ArrayList<>());
		}
		games.get(g).add(sc);
	}

	@Override
	public List<Integer> getScores(Game g) {
		return games.get(g);
	}

	@Override
	public Iterator<Game> iterator() {
		return games.keySet().iterator();
	}

}
