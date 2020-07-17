package com.test.movie.mongodb;

import com.test.movie.mongodb.Movie;
import com.test.movie.mongodb.MovieDao;
import com.test.movie.mongodb.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class MovieServiceTest {
    @Resource
    private MovieService movieService;

    @Test
    public void findById(){
        Movie movie = movieService.findMovieById(1);
        System.out.println(movie.toString());
    }

    @Test
    public void findByRank(){
        Movie movie = movieService.findMovieByRank("No.13");
        System.out.println(movie.toString());
    }

    @Test
    public void findAll(){
        List<Movie> movies = movieService.findAll();
        for (Movie movie : movies){
            System.out.println(movie.getRank());
        }
    }

    @Test
    public void findByScore(){
        List<Movie> movies = movieService.findMoviesByScore(9.7);
        for (Movie movie : movies){
            System.out.println(movie.toString());
        }
    }
    @Test
    public void findBetweenScore(){
        List<Movie> movies = movieService.findMoviesByScoreBetween(8,8.35);
        for (Movie movie : movies){
            System.out.println(movie.toString());
        }
    }
    @Test
    public void findBetweenId(){
        List<Movie> movies = movieService.findMoviesByIdBetween(1, 16);
        for (Movie movie : movies){
            System.out.println(movie.toString());
        }
    }
    @Test
    public void countMoviesByScoreBetween(){
        int temp = movieService.countMoviesByScoreBetween(8,8.35);
        System.out.println(temp);
    }
}
