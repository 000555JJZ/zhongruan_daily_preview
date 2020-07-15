package com.test.movie.mongodb;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
@Document(collection = "movie")
public class Movie implements Serializable {
    @Id
    private Object _id;
    private int id;
    private String rank;
    private String name;
    private double score;
    private String director;
    private List<String> actors;

    public Movie(Object _id, int id, String rank, String name, double score, String director, List<String> actors) {
        this._id = _id;
        this.id = id;
        this.rank = rank;
        this.name = name;
        this.score = score;
        this.director = director;
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "_id=" + _id +
                ", id=" + id +
                ", rank='" + rank + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", director='" + director + '\'' +
                ", actors=" + actors +
                '}';
    }

    public void set_id(Object _id) {
        this._id = _id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public Object get_id() {
        return _id;
    }

    public int getId() {
        return id;
    }

    public String getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getActors() {
        return actors;
    }

    public Movie() {
    }

    public Movie(int id, String rank, String name, double score, String director, List<String> actors) {
        this.id = id;
        this.rank = rank;
        this.name = name;
        this.score = score;
        this.director = director;
        this.actors = actors;
    }
}
