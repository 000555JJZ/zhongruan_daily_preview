package com.test.bilibili.dao.impl;

import com.test.bilibili.dao.ChartRadar2DDao;
import com.test.bilibili.hdfs.HDFSUtils;
import com.test.thrift.bilibili.ChartInfoRadar2D;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChartDaoRadar2DDaoImpl implements ChartRadar2DDao {
    @Value("${hdfs.url1}")
    String url1;
    @Value("${hdfs.url2}")
    String url2;
    @Value("${hdfs.url3}")
    String url3;
    @Override
    public ChartInfoRadar2D getChartInfoRadar2DPart1() {

        try {
            List<String> key = new ArrayList<>();
            List<List<Long>> value = new ArrayList<>();
            HDFSUtils.getHDFSFileInfoToRadarChart(url1,key,value);
            ChartInfoRadar2D chartInfoRadar2D = new ChartInfoRadar2D(key,value);
            return chartInfoRadar2D;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DPart2() {
        try {
            List<String> key = new ArrayList<>();
            List<List<Long>> value = new ArrayList<>();
            HDFSUtils.getHDFSFileInfoToRadarChart(url2,key,value);
            ChartInfoRadar2D chartInfoRadar2D = new ChartInfoRadar2D(key,value);
            return chartInfoRadar2D;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DPart3() {
        try {
            List<String> key = new ArrayList<>();
            List<List<Long>> value = new ArrayList<>();
            HDFSUtils.getHDFSFileInfoToRadarChart(url3,key,value);
            ChartInfoRadar2D chartInfoRadar2D = new ChartInfoRadar2D(key,value);
            return chartInfoRadar2D;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DPart4() {
        return null;
    }

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DByStringPart1(String key) {
        return null;
    }

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DByStringPart2(String key) {
        return null;
    }
}
