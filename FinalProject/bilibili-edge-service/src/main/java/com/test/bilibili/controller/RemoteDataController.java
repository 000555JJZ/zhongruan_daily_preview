package com.test.bilibili.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.bilibili.thrift.ServiceProvider;
import com.test.bilibili.util.ConvertDTO;
import com.test.bilibili.util.ConvertRadar2DDTO;
import com.test.bilibili.util.ConvertRelationDTO;
import com.test.thrift.bilibili.*;
import com.test.thrift.bilibili.dto.ChartDTO;
import com.test.thrift.bilibili.dto.ChartRadar2DDTO;
import com.test.thrift.bilibili.dto.ChartRelationDTO;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/remote")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class RemoteDataController {
    @Resource
    private ServiceProvider serviceProvider;

    @GetMapping("/question1/data1")
    public ChartDTO getChartInfo1(){
        ChartService.Iface chartService = serviceProvider.getChartService();
        ChartInfo chartInfo = null;
        try {
            chartInfo = chartService.getChartInfoPart1();
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }
        ChartDTO chartDTO = ConvertDTO.toChartDTO(chartInfo);
        return chartDTO;
    }
    @GetMapping("/question1/data2")
    public ChartDTO getChartInfo2(){
        ChartService.Iface chartService = serviceProvider.getChartService();
        ChartInfo chartInfo = null;
        try {
            chartInfo = chartService.getChartInfoPart2();
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }
        ChartDTO chartDTO = ConvertDTO.toChartDTO(chartInfo);
        return chartDTO;
    }
    @GetMapping("/question1/data3")
    public ChartDTO getChartInfo3(){
        ChartService.Iface chartService = serviceProvider.getChartService();
        ChartInfo chartInfo = null;
        try {
            chartInfo = chartService.getChartInfoPart3();
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }
        ChartDTO chartDTO = ConvertDTO.toChartDTO(chartInfo);
        return chartDTO;
    }

    @GetMapping("/question1/radar-data1")
    public ChartRadar2DDTO getRadarChartInfo1(){
        ChartServiceRadar2D.Iface chartServiceRadar2D = serviceProvider.getRadarChartService();
        ChartInfoRadar2D chartInfoRadar2D = null;
        try {
            chartInfoRadar2D = chartServiceRadar2D.getChartInfoRadar2DPart1();
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }
        ChartRadar2DDTO chartRadar2DDTO = ConvertRadar2DDTO.toChartRadarDTO(chartInfoRadar2D);
        return chartRadar2DDTO;
    }
    @GetMapping("/question1/radar-data2")
    public ChartRadar2DDTO getRadarChartInfo2(){
        ChartServiceRadar2D.Iface chartServiceRadar2D = serviceProvider.getRadarChartService();
        ChartInfoRadar2D chartInfoRadar2D = null;
        try {
            chartInfoRadar2D = chartServiceRadar2D.getChartInfoRadar2DPart2();
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }
        ChartRadar2DDTO chartRadar2DDTO = ConvertRadar2DDTO.toChartRadarDTO(chartInfoRadar2D);
        return chartRadar2DDTO;
    }
    @GetMapping("/question1/radar-data3")
    public ChartRadar2DDTO getRadarChartInfo3(){
        ChartServiceRadar2D.Iface chartServiceRadar2D = serviceProvider.getRadarChartService();
        ChartInfoRadar2D chartInfoRadar2D = null;
        try {
            chartInfoRadar2D = chartServiceRadar2D.getChartInfoRadar2DPart3();
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }
        ChartRadar2DDTO chartRadar2DDTO = ConvertRadar2DDTO.toChartRadarDTO(chartInfoRadar2D);
        return chartRadar2DDTO;
    }



    @GetMapping("/question2/relation-data1")
    public ChartRelationDTO getRelationChartInfo1(){
        ChartServiceRelation.Iface chartServiceRelation = serviceProvider.getRelationChartService();
        ChartInfoRelation chartInfoRelation = null;
        try {
            chartInfoRelation = chartServiceRelation.getChartInfoRelationPart1();
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }
        ChartRelationDTO chartRelationDTO = ConvertRelationDTO.toChartRelationDTO(chartInfoRelation);
        return  chartRelationDTO;
    }

    @GetMapping("/question3/data4")
    public ChartDTO getChartInfo4(){
        ChartService.Iface chartService = serviceProvider.getChartService();
        ChartInfo chartInfo = null;
        try {
            chartInfo = chartService.getChartInfoPart5();
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }
        ChartDTO chartDTO = ConvertDTO.toChartDTO(chartInfo);
        return chartDTO;
    }

    @GetMapping("/question3/data5")
    public ChartDTO getChartInfo5(){
        ChartService.Iface chartService = serviceProvider.getChartService();
        ChartInfo chartInfo = null;
        try {
            chartInfo = chartService.getChartInfoPart5();
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }
        ChartDTO chartDTO = ConvertDTO.toChartDTO(chartInfo);
        return chartDTO;
    }

    @GetMapping("/question4/data6")
    public ChartDTO getChartInfo6(){
        ChartService.Iface chartService = serviceProvider.getChartService();
        ChartInfo chartInfo = null;
        try {
            chartInfo = chartService.getChartInfoPart6();
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }
        ChartDTO chartDTO = ConvertDTO.toChartDTO(chartInfo);
        return chartDTO;
    }
    @GetMapping("/question4/data7")
    public ChartDTO getChartInfo7(){
        ChartService.Iface chartService = serviceProvider.getChartService();
        ChartInfo chartInfo = null;
        try {
            chartInfo = chartService.getChartInfoPart7();
        } catch (TException e) {
            e.printStackTrace();
            return null;
        }
        ChartDTO chartDTO = ConvertDTO.toChartDTO(chartInfo);
        return chartDTO;
    }

}
