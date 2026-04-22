
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