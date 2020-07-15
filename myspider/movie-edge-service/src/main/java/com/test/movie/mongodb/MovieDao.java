package com.test.movie.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
public interface MovieDao extends MongoRepository<Movie,Object>{
//

    Movie findMovieByRank(String Rank);
    Movie findMovieByName(String name);
    Movie findMovieById(int id);
    List<Movie> findMoviesByIdBetween(int from,int to);
    List<Movie> findMoviesByScoreBetween(double from,double to);
    List<Movie> findMoviesByScore(double score);
    List<Movie> findMoviesByDirector(String director);
    Page<Movie> findAll(Pageable pageable);
    int countMoviesByScoreBetween(double from ,double to);
}
