package service;

import model.Movie;
import model.MovieResponse;

import java.util.List;

public interface MovieService {
    MovieResponse getTMDBMovie(int page);
    MovieResponse searchMovie(String query, int page);
    List<Movie> getAllMovies(int maxPages);
}