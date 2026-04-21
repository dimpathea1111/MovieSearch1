package model;

import lombok.*;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MovieDetail {
    private Integer id;
    private String title;
    private  String overview;
    private String releaseDate;
    private Integer runtime;
    private long budgest;
    private double voteAverage;

}