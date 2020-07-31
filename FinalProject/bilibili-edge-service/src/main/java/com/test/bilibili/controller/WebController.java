package com.test.bilibili.controller;

import com.test.bilibili.thrift.ServiceProvider;
import com.test.bilibili.util.ConvertRelationDTO;
import com.test.thrift.bilibili.ChartInfoRelation;
import com.test.thrift.bilibili.ChartServiceRelation;
import com.test.thrift.bilibili.dto.ChartRelationDTO;
import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/bilibili")
public class WebController {
    //web服务器，调用resources下的html文件

    @Resource
    private ServiceProvider serviceProvider;

//    @GetMapping("/information")
//    public String showMovieInfo(){
//        return "chart-show";
//    }
//
//    @RequestMapping(value = "/question2/search-relation-data", method = RequestMethod.POST)
//    @ResponseBody
//    public ChartRelationDTO searchRelationChartInfo1(@RequestParam("tag") String tag){
//        ChartServiceRelation.Iface chartServiceRelation = serviceProvider.getRelationChartService();
//        ChartInfoRelation chartInfoRelation = null;
//        try {
//            chartInfoRelation = chartServiceRelation.getChartInfoRelationByStringPart1(tag);
//        } catch (TException e) {
//            e.printStackTrace();
//            return null;
//        }
//        ChartRelationDTO chartRelationDTO = ConvertRelationDTO.toChartRelationDTO(chartInfoRelation);
//        return  chartRelationDTO;
//    }

    @GetMapping("/quesion1/all1")
    public String question1all1(){
        return "all1";
    }
    @GetMapping("/quesion1/all2")
    public String question1all2(){
        return "all2";
    }
    @GetMapping("/quesion1/all3")
    public String question1all3(){
        return "all3";
    }
    @GetMapping("/quesion1/average1")
    public String question1average1(){
        return "average1";
    }
    @GetMapping("/quesion1/average2")
    public String question1average2(){
        return "average2";
    }
    @GetMapping("/quesion1/average3")
    public String question1average3(){
        return "average3";
    }
    @GetMapping("/quesion1/radar1")
    public String question1radar1(){
        return "radar1";
    }
    @GetMapping("/quesion1/radar2")
    public String question1radar2(){
        return "radar2";
    }
    @GetMapping("/quesion1/radar3")
    public String question1radar3(){
        return "radar3";
    }
    @GetMapping("/quesion2/relation")
    public String question2relation(){
        return "relation";
    }
    @GetMapping("/quesion3/up")
    public String question3up(){
        return "upsComparedByNumberAndScore";
    }
    @GetMapping("/quesion4/comic")
    public String question4comic(){
        return "animeComparedByNumberAndScore";
    }

}
