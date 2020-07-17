package com.test.movie.echarts;

import java.io.Serializable;

public class ScoreData implements Serializable {
    String score;
    Integer count;

    public ScoreData() {
    }

    public ScoreData(String score, int count) {
        this.score = score;
        this.count = count;
    }

    public String getScore() {
        return score;
    }

    public Integer getCount() {
        return count;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
