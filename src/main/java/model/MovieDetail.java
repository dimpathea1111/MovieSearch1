//package model;
//
//import lombok.*;
//
//import java.util.List;
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//
//public class MovieDetail extends Movie {
//    private Integer id;
//    private Integer runtime;
//    private long budgest;
//    private double vote_average;
//
//}


package model;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetail extends Movie {
    private Integer runtime;
    private Long budget;
    private List<Genre> genres;
    @JsonProperty("production_countries") private List<Country> countries;

    public String getGenresString() {
        return (genres == null) ? "N/A" : genres.stream().map(g -> g.name).collect(Collectors.joining(", "));
    }
    public String getOrigin() {
        return (countries == null || countries.isEmpty()) ? "N/A" : countries.get(0).isoCode;
    }

    @Data static class Genre { public String name; }
    @Data static class Country { @JsonProperty("iso_3166_1") public String isoCode; }
}