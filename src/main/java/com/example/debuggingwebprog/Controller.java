package com.example.debuggingwebprog;

import com.example.debuggingwebprog.Model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    public List<Movie> movies = new ArrayList<>();
    private Logger log = LoggerFactory.getLogger(Movie.class);
    @PostMapping("/movies")
    public List<Movie> addMovies() {
        movies.add(new Movie("The Shawshank Redemption", "Drama", "1994", "Frank Darabont"));
        movies.add(new Movie("The Godfather", "Crime", "1972", "Francis Ford Coppola"));
        movies.add(new Movie("The Godfather: Part II", "Crime", "1974", "Francis Ford Coppola"));
        movies.add(new Movie("The Dark Knight", "Action", "2008", "Christopher Nolan"));
        movies.add(new Movie("Jaws", "Horror", "1975", "Steven Spielberg"));
        movies.add(new Movie("Jurassic Park", "Adventure", "1993", "Steven Spielberg"));
        movies.add(new Movie("Dead Snow", "Horror", "2009", "Tommy Wirkola"));
        movies.add(new Movie("Hansel & Gretel: Witch Hunters", "Action", "2013", "Tommy Wirkola"));
        return movies;
    }

    @GetMapping("/aDirector")
    public List<Movie> OnlyDirector(String director) {
        List<Movie> moviesByDirector = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getDirector().equals(director)) {
                moviesByDirector.add(movie);
            }
        }
        if (moviesByDirector.size() > 0) throw new IndexOutOfBoundsException("No directors");
        return moviesByDirector;
    }

    @GetMapping("/searchformovie")
    public Movie findMovie(String tittle) {
        Movie results = null;
        for (Movie movie : movies) {
            if (movie.getTitle() == tittle) {
                results = movie;
            }
        }
        return results;
    }
}

