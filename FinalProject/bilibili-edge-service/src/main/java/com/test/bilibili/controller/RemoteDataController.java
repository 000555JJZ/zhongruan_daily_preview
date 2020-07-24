package com.test.bilibili.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.bilibili.thrift.ServiceProvider;
import com.test.bilibili.util.ConvertDTO;
import com.test.thrift.bilibili.ChartInfo;
import com.test.thrift.bilibili.ChartService;
import com.test.thrift.bilibili.dto.ChartDTO;
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
}
