////package service;
////
////import com.fasterxml.jackson.databind.ObjectMapper;
////import model.Movie;
////import model.MovieResponse;
////
////import java.net.URI;
////import java.net.http.*;
////import java.util.ArrayList;
////import java.util.List;
////
////public class MovieServiceImpl implements MovieService {
////
////    private static final String API_KEY = "YOUR_API_KEY";
////
////    private final HttpClient client = HttpClient.newHttpClient();
//////    private final  mapper = new ObjectMapper();
////    private final ObjectMapper mapper=new ObjectMapper();
////
//////    @Override
//////    public MovieResponse getTMDBMovie(int page) {
//////
//////        String url = "https://api.themoviedb.org/3/movie/popular"
//////                + "?api_key=" + API_KEY
//////                + "&page=" + page;
//////
//////        return fetch(url);
//////    }
////
////
////    public MovieResponse getTMDBMovie(int page) {
////        try {
////            String url = BASE_URL + "?api_key=" + API_KEY + "&page=" + page;
////
////            HttpRequest request = HttpRequest.newBuilder()
////                    .uri(URI.create(url))
////                    .GET()
////                    .build();
////
////            HttpClient client = HttpClient.newHttpClient();
////
////            HttpResponse<String> response = client.send(request,
////                    HttpResponse.BodyHandlers.ofString());
////
////            System.out.println("RAW RESPONSE: " + response.body());
////
////            ObjectMapper mapper = new ObjectMapper();
////            return mapper.readValue(response.body(), MovieResponse.class);
////
////        } catch (Exception e) {
////            e.printStackTrace();
////            return null;
////        }
////    }
////
////    @Override
////    public MovieResponse searchMovie(String query, int page) {
////
////        String url = "https://api.themoviedb.org/3/search/movie"
////                + "?api_key=YOUR_API_KEY"
////                + "&query=" + query
////                + "&page=" + page;
////
////        return fetch(url);
////    }
////
////    @Override
////    public List<Movie> getAllMovies(int maxPages) {
////
////        List<Movie> all = new ArrayList<>();
////
////        for (int i = 1; i <= maxPages; i++) {
////            MovieResponse res = getTMDBMovie(i);
////            if (res.getResults() != null) {
////                all.addAll(res.getResults());
////            }
////        }
////
////        return all;
////    }
////
////    private MovieResponse fetch(String url) {
////        try {
////            HttpRequest request = HttpRequest.newBuilder()
////                    .uri(URI.create(url))
////                    .GET()
////                    .build();
////
////            HttpResponse<String> response = client.send(
////                    request,
////                    HttpResponse.BodyHandlers.ofString()
////            );
////
////            return mapper.readValue(response.body(), MovieResponse.class);
////
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        }
////    }
////}
//
//package service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import model.Movie;
//import model.MovieResponse;
//
//import java.net.URI;
//import java.net.http.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MovieServiceImpl implements MovieService {
//
//    private static final String API_KEY = "6a470e9fe134be6b8dc639d3bca20d9e";
//
//    private static final String BASE_URL =
//            "https://api.themoviedb.org/3/movie/popular";
//
//    private static final String SEARCH_URL =
//            "https://api.themoviedb.org/3/search/movie";
//
//    private final HttpClient client = HttpClient.newHttpClient();
//    private final ObjectMapper mapper = new ObjectMapper();
//
//    @Override
//    public MovieResponse getTMDBMovie(int page) {
//        String url = BASE_URL
//                + "?api_key=" + API_KEY
//                + "&page=" + page;
//
//        return fetch(url);
//    }
//
//    @Override
//    public MovieResponse searchMovie(String query, int page) {
//
//        String url = SEARCH_URL
//                + "?api_key=" + API_KEY
//                + "&query=" + query
//                + "&page=" + page;
//
//        return fetch(url);
//    }
//
//    @Override
//    public List<Movie> getAllMovies(int maxPages) {
//
//        List<Movie> all = new ArrayList<>();
//
//        for (int i = 1; i <= maxPages; i++) {
//            MovieResponse res = getTMDBMovie(i);
//
//            if (res != null && res.getResults() != null) {
//                all.addAll(res.getResults());
//            }
//        }
//
//        return all;
//    }
//
//    private MovieResponse fetch(String url) {
//
//        try {
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(url))
//                    .GET()
//                    .build();
//
//            HttpResponse<String> response = client.send(
//                    request,
//                    HttpResponse.BodyHandlers.ofString()
//            );
//
//            System.out.println("RAW RESPONSE: " + response.body());
//
//            return mapper.readValue(response.body(), MovieResponse.class);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}



package service;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;
import java.net.URI;
import java.net.http.*;

public class MovieServiceImpl implements MovieService {
    private final String KEY = "6a470e9fe134be6b8dc639d3bca20d9e";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public MovieResponse searchMovies(String query, int page) {
        try {
            String url = "https://api.themoviedb.org/3/search/movie?api_key=" + KEY + "&query=" + query.replace(" ", "%20") + "&page=" + page;
            HttpRequest req = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            return mapper.readValue(client.send(req, HttpResponse.BodyHandlers.ofString()).body(), MovieResponse.class);
        } catch (Exception e) { return null; }
    }

    @Override
    public MovieDetail getMovieDetails(int id) {
        try {
            String url = "https://api.themoviedb.org/3/movie/" + id + "?api_key=" + KEY;
            HttpRequest req = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            return mapper.readValue(client.send(req, HttpResponse.BodyHandlers.ofString()).body(), MovieDetail.class);
        } catch (Exception e) { return null; }
    }
}