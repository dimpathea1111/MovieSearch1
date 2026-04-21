package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Movie {

    private Integer id;
    private String title;
    private String overview;
    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("vote_average")
    private double voteAverage;
//    private String release_date;
//    private Double vote_average;
//    private Integer runtime;
//    private Long budget;

    private  String trailerUrl;

    public String getFormattedDate() {
        return (releaseDate == null || releaseDate.isEmpty()) ? "Unknown" : releaseDate;
    }
//
//    @JsonProperty("release_date")
//    private String releaseDate;
//
//    @JsonProperty("vote_average")
//    private double voteAverage;
}