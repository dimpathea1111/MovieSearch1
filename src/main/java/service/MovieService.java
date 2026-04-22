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

    MovieResponse searchMovies(String query, int page);


    MovieDetail getMovieDetails(int id);
}