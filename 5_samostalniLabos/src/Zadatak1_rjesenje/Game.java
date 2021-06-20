package Zadatak1_rjesenje;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
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
	public Factory(String game, int rating) {
		super(game);
		this.setRating(rating);
	}

	public static Game createGame(String game, int rating) {
		return new Factory(game, rating);
	}
}

class MyPlayer extends Player implements Iterable<Game> {
	private Map<Game, ArrayList<Integer>> games;

	protected MyPlayer(String name) {
		super(name);
		games = new TreeMap<>(new Comparator<>() {
			public int compare(Game o1, Game o2) {
				return o1.getName().compareTo(o2.getName());
			};
		});
	}

	@Override
	void addGameScore(Game game, int score) {
		if (!games.containsKey(game))
			games.put(game, new ArrayList<>());
		games.get(game).add(score);
	}

//Nasljedena metoda - APSTRAKTNA
	Iterable<Integer> getScores(Game game) {
		return new Iterable<Integer>() {
			@Override
			public Iterator<Integer> iterator() {
				return games.get(game).iterator();
			}

		};
	}

	@Override
	public Iterator<Game> iterator() {
		return games.keySet().iterator();
	}

}
