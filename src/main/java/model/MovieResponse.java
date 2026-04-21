package model;//package model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.*;
//import java.util.List;
//
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class MovieResponse {
//    private Integer page;
//    private List<Movie> results;
//    private Integer totalPages;
//    private Integer totalResults;
//}

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import model.Movie;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieResponse {

    private Integer page;

//    private List<Movie>results;
//    private Integer total_page;
//    private  Integer total_results;
//
//

    @JsonProperty("results")
    private List<Movie> results;

    @JsonProperty("total_pages")
    private Integer totalPages;

    @JsonProperty("total_results")
    private Integer totalResults;
}