package com.test.movie.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.movie.echarts.ScoreData;
import com.test.movie.mongodb.Movie;
import com.test.movie.mongodb.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/remote")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class RemoteDataController {

    @Resource
    private MovieService movieService;
    @GetMapping("/scoredata1")
    public List<ScoreData> getMongoMovieDataByScore1(){
        int data1=movieService.countMoviesByScoreBetween(8,8.35);
        int data2=movieService.countMoviesByScoreBetween(8.35,8.65);
        int data3=movieService.countMoviesByScoreBetween(8.65,8.95);
        int data4=movieService.countMoviesByScoreBetween(8.95,9.25);
        int data5=movieService.countMoviesByScoreBetween(9.25,9.55);
        int data6=movieService.countMoviesByScoreBetween(9.55,10);
        ScoreData scoreData1 = new ScoreData("8.0-8.3",data1);
        ScoreData scoreData2 = new ScoreData("8.4-8.6",data2);
        ScoreData scoreData3 = new ScoreData("8.7-8.9",data3);
        ScoreData scoreData4 = new ScoreData("9.0-9.3",data4);
        ScoreData scoreData5 = new ScoreData("9.3-9.6",data5);
        ScoreData scoreData6 = new ScoreData("9.6-10.0",data6);
        List<ScoreData> scoreData= new ArrayList<>();
        scoreData.add(scoreData1);
        scoreData.add(scoreData2);
        scoreData.add(scoreData3);
        scoreData.add(scoreData4);
        scoreData.add(scoreData5);
        scoreData.add(scoreData6);
        return scoreData;
    }

    @GetMapping("/scoredata2")
    public List<ScoreData> getMongoMovieDataByScore2(){
        int data1= movieService.countMoviesByScore(9.0);
        int data2= movieService.countMoviesByScore(9.1);
        int data3= movieService.countMoviesByScore(9.2);
        int data4= movieService.countMoviesByScore(9.3);
        int data5= movieService.countMoviesByScore(9.4);
        int data6= movieService.countMoviesByScore(9.5);
        int data7= movieService.countMoviesByScore(9.6);
        int data8= movieService.countMoviesByScore(9.7);
        ScoreData scoreData1 = new ScoreData("9.0",data1);
        ScoreData scoreData2 = new ScoreData("9.1",data2);
        ScoreData scoreData3 = new ScoreData("9.2",data3);
        ScoreData scoreData4 = new ScoreData("9.3",data4);
        ScoreData scoreData5 = new ScoreData("9.4",data5);
        ScoreData scoreData6 = new ScoreData("9.5",data6);
        ScoreData scoreData7 = new ScoreData("9.6",data7);
        ScoreData scoreData8 = new ScoreData("9.7",data8);
        List<ScoreData> scoreData= new ArrayList<>();
        scoreData.add(scoreData1);
        scoreData.add(scoreData2);
        scoreData.add(scoreData3);
        scoreData.add(scoreData4);
        scoreData.add(scoreData5);
        scoreData.add(scoreData6);
        scoreData.add(scoreData7);
        scoreData.add(scoreData8);
        return scoreData;
    }

}
