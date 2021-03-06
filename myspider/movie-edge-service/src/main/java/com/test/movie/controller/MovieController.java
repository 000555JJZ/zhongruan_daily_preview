package com.test.movie.controller;


//import com.test.movie.mongodb.Movie;

import com.test.movie.echarts.ScoreData;
import com.test.movie.mongodb.Movie;
import com.test.movie.mongodb.MovieService;
import com.test.movie.response.Response;
import com.test.movie.thrift.ServiceProvider;
import com.test.thrift.spider.SpiderService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Resource
    private ServiceProvider serviceProvider;


    @RequestMapping(value = "/spider",method = RequestMethod.POST)
    @ResponseBody
    public Response runSpider(){
        SpiderService.Iface spiderService = serviceProvider.getSpiderService();

        try {
            boolean result = false;
            result = spiderService.runSpider();
            if (!result){
                return Response.SPIDER_WRONG;
            }
        } catch (TException e) {
            e.printStackTrace();
            return Response.TRANSPORT_WRONG;
        }
        return Response.SUCCESS;
    }

    @GetMapping("/information")
    public String showMovieInfo(){
        return "movie-show";
    }





}
