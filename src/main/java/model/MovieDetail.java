package model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetail extends Movie {

    private Integer runtime;

    private Long budget;

    private List<Genre> genres;

    @JsonProperty("production_countries")
    private List<Country> countries;

    public String getGenresString() {
        if (genres == null || genres.isEmpty()) return "N/A";
        return genres.stream()
                .map(g -> g.name)
                .collect(java.util.stream.Collectors.joining(", "));
    }

    public String getOrigin() {
        if (countries == null || countries.isEmpty()) return "N/A";
        return countries.get(0).iso_3166_1; // Returns the country code (e.g., US)
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Genre {
        public String name;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Country {
        @JsonProperty("iso_3166_1")
        public String iso_3166_1;
    }
}