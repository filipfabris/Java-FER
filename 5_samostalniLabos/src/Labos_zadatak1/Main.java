package Labos_zadatak1;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
	public static void main(String[] args) {
		ArrayList<MovieInfo> movies = new ArrayList<MovieInfo>();

		movies.add(new MovieInfo(8, 9, "Guy Ritchie", 2000, "Snatch"));
		movies.add(new MovieInfo(7, 8, "Guy Ritchie", 2019, "The Gentlemen"));
		movies.add(new MovieInfo(7, 7, "Guy Ritchie", 2009, "Sherlock Holmes"));
		movies.add(new MovieInfo(7, 6, "Guy Ritchie", 2015, "The Man From U.N.C.L.E"));
		movies.add(new MovieInfo(8, 9, "Christopher Nolan", 2000, "Memento"));
		movies.add(new MovieInfo(7, 6, "Robert Rodriguez", 1996, "From dusk till dawn"));
		movies.add(new MovieInfo(7, 8, "Robert Zemeckis", 2000, "Cast Away"));

		Stream<MovieInfo> filtered1 = movies.stream().filter(Filter.olderThan(2009));

		ArrayList<MovieInfo> filtered_list = filtered1.collect(Collectors.toCollection(ArrayList::new));

		for (MovieInfo movieInfo : filtered_list) {
			System.out.println(movieInfo.getMovieName());
		}

		Stream<MovieInfo> filtered2 = movies.stream().filter(Filter.byDirectorAndYear(2010, "Guy Ritchie"));

		ArrayList<MovieInfo> filtered_list2 = filtered2.collect(Collectors.toCollection(ArrayList::new));

		for (MovieInfo movieInfo : filtered_list2) {
			System.out.println(movieInfo.getMovieName());
		}

		Stream<MovieInfo> filtered3 = movies.stream().filter(Filter.byRating(8));

		ArrayList<MovieInfo> filtered_list3 = filtered3.collect(Collectors.toCollection(ArrayList::new));

		for (MovieInfo movieInfo : filtered_list3) {
			System.out.println(movieInfo.getMovieName());
		}
	}
}