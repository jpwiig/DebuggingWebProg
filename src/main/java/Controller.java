package Debugging1700Controller;

import Model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    public List<Movie> movies = new ArrayList<>();
    @GetMapping("/movies")
    public List<Movie>addMovies(){
    movies.add(new Movie("The Shawshank Redemption", "Drama", "1994", "Frank Darabont"));
    movies.add(new Movie("The Godfather", "Crime", "1972", "Francis Ford Coppola"));
    movies.add(new Movie("The Godfather: Part II", "Crime", "1974", "Francis Ford Coppola"));
    movies.add(new Movie("The Dark Knight", "Action", "2008", "Christopher Nolan"));
    movies.add(new Movie("Jaws", "Horror", "1975", "Steven Spielberg"));
    movies.add(new Movie("Jurassic Park", "Adventure", "1993", "Steven Spielberg"));
    return movies;
    }

    @GetMapping("/aDirector")
    public List<Movie>OnlyDirector(String director){
        List<Movie> moviesByDirector = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getDirector().equals(director)) {
                moviesByDirector.add(movie);
            } else {
                System.out.println("No movies found for director " + director);
            }
        }
        return moviesByDirector;
    }
}
