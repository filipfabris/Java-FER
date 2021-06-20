package Labos_zadatak1;

import java.util.function.Predicate;

class MovieInfo {
	private String movieName;

	private int IMDBRating;
	private int rottenTomatoesRating;

	private String director;
	private int year;

	public MovieInfo(int IMDBRating, int rottenTomatoesRating, String director, int year, String name) {
		this.IMDBRating = IMDBRating;
		this.rottenTomatoesRating = rottenTomatoesRating;
		this.director = director;
		this.year = year;
		this.movieName = name;
	}

	public String getMovieName() {
		return movieName;
	}

	public int getIMDBRating() {
		return IMDBRating;
	}

	public int getRottenTomatoesRating() {
		return rottenTomatoesRating;
	}

	public String getDirector() {
		return director;
	}

	public int getYear() {
		return year;
	}
}

class Filter {
	public static Predicate<MovieInfo> olderThan(int year) {
		return (t) -> t.getYear() < year;

	}

	public static Predicate<MovieInfo> byDirectorAndYear(int year, String director) {
		return (t) -> t.getYear() > year && t.getDirector().equals(director);
	}

	public static Predicate<MovieInfo> byRating(int score) {
		return (t) -> t.getIMDBRating() > score && t.getRottenTomatoesRating() > score;
	}
}
