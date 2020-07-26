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

    @GetMapping("/data1")
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
    @GetMapping("/data2")
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


    @GetMapping("/radar-data1")
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

    @GetMapping("/relation-data1")
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
}
