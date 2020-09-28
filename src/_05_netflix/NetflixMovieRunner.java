package _05_netflix;

public class NetflixMovieRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie MontyPython = new Movie("Monty Python and the Holy Grail", 7);
		Movie Spaceballs = new Movie("Spaceballs", 5);
		Movie Weird = new Movie("The Man Who Killed Hitler and Then the Bigfoot", 0);
		Movie JupiterAcending = new Movie("Jupiter Ascending", 1);
		Movie Interstellar = new Movie("Interstellar", 4);
		
		System.out.println(Spaceballs.getTicketPrice());
		
		NetflixQueue que = new NetflixQueue();
		que.addMovie(MontyPython);
		que.addMovie(Spaceballs);
		que.addMovie(Weird);
		que.addMovie(JupiterAcending);
		que.addMovie(Interstellar);
		
		que.printMovies();
		System.out.println("The best movie is: " + que.getBestMovie().getTitle());
		System.out.println("The second best movie is: " + que.getMovie(1).getTitle());
	}

}
