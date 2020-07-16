package com.test.movie.mongodb;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MovieServiceImpl implements MovieService{
    @Resource
    private MovieDao movieDao;
    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    @Override
    public Movie findMovieByRank(String rank) {
        return  movieDao.findMovieByRank(rank);
    }

    @Override
    public Movie findMovieById(Integer id) {
        return movieDao.findMovieById(id);
    }

    @Override
    public Movie findMovieByName(String name) {
        return movieDao.findMovieByName(name);
    }

    @Override
    public List<Movie> findMoviesByIdBetween(int from, int to) {
        return  movieDao.findMoviesByIdBetween(from, to);
    }

    @Override
    public List<Movie> findMoviesByScore(double score) {
        return movieDao.findMoviesByScore(score);
    }


    @Override
    public List<Movie> findMoviesByScoreBetween(double from, double to) {
        return movieDao.findMoviesByScoreBetween(from, to);
    }

    @Override
    public List<Movie> findMoviesByDirector(String director) {
        return movieDao.findMoviesByDirector(director);
    }

    @Override
    public int countMoviesByScoreBetween(double from, double to) {
        return movieDao.countMoviesByScoreBetween(from, to);
    }

    @Override
    public int countMoviesByScore(double score) {
        return movieDao.countMoviesByScore(score);
    }

}
