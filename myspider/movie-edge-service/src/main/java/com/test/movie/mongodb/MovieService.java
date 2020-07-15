package com.test.movie.mongodb;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findMovieByRank(String rank);
    Movie findMovieById(Integer id);
    Movie findMovieByName(String name);
    List<Movie> findMoviesByIdBetween(int from,int to);
    List<Movie> findMoviesByScore(double score);
    List<Movie> findMoviesByScoreBetween(double from,double to);
    List<Movie> findMoviesByDirector(String director);
    int countMoviesByScoreBetween(double from ,double to);
}
