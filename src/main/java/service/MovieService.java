//package service;
//
//import model.Movie;
//import model.MovieDetail;
//import model.MovieResponse;
//
//import java.util.List;
//
//public interface MovieService {
//    MovieResponse getTMDBMovie(int page);
//    MovieResponse searchMovie(String query, int page);
//    List<Movie> getAllMovies(int maxPages);
////    MovieDetail getMovieDetail(int id);
//
//}

package service;

import model.MovieDetail;
import model.MovieResponse;

public interface MovieService {
    /**
     * Searches for movies based on a title string and page number.
     */
    MovieResponse searchMovies(String query, int page);

    /**
     * Fetches full details for a single movie using its unique ID.
     */
    MovieDetail getMovieDetails(int id);
}