package com.test.bilibili.dao.impl;

import com.test.bilibili.dao.ChartDao;
import com.test.bilibili.hdfs.HDFSUtil;
import com.test.bilibili.hdfs.HDFSUtils;
import com.test.thrift.bilibili.ChartInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChartDaoImpl implements ChartDao {
    @Value("${hdfs.url1}")
    String url1;
    @Value("${hdfs.url2}")
    String url2;
    @Value("${hdfs.url3}")
    String url3;
    @Value("${hdfs.url4}")
    String url4;
    @Value("${hdfs.url5}")
    String url5;
    @Value("${hdfs.url6}")
    String url6;
    @Value("${hdfs.url7}")
    String url7;
    @Value("${hdfs.url8}")
    String url8;
    @Value("${hdfs.url9}")
    String url9;
    @Value("${hdfs.url10}")
    String url10;


    @Override
    public ChartInfo getChartInfoPart1() {
        try {
            List<String> key = new ArrayList<>();
            List<Long> value = new ArrayList<>();

            HDFSUtil.getHDFSFileInfoToChart(url1,key,value);
            ChartInfo chartInfo = new ChartInfo(key,value);
            return chartInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ChartInfo getChartInfoPart2() {

        try {
            List<String> key = new ArrayList<>();
            List<Long> value = new ArrayList<>();
            HDFSUtil.getHDFSFileInfoToChart(url2,key,value);
            ChartInfo chartInfo = new ChartInfo(key,value);
            return chartInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ChartInfo getChartInfoPart3() {
        try {
            List<String> key = new ArrayList<>();
            List<Long> value = new ArrayList<>();
            HDFSUtil.getHDFSFileInfoToChart(url3,key,value);
            ChartInfo chartInfo = new ChartInfo(key,value);
            return chartInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChartInfo getChartInfoPart4() {
        try {
            List<String> key = new ArrayList<>();
            List<Long> value = new ArrayList<>();
            HDFSUtil.getHDFSFileInfoToChart(url4,key,value);
            ChartInfo chartInfo = new ChartInfo(key,value);
            return chartInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChartInfo getChartInfoPart5() {
        try {
            List<String> key = new ArrayList<>();
            List<Long> value = new ArrayList<>();
            HDFSUtil.getHDFSFileInfoToChart(url5,key,value);
            ChartInfo chartInfo = new ChartInfo(key,value);
            return chartInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChartInfo getChartInfoPart6() {
        try {
            List<String> key = new ArrayList<>();
            List<Long> value = new ArrayList<>();
            HDFSUtils.getHDFSFileInfoToChart(url6,key,value);
            ChartInfo chartInfo = new ChartInfo(key,value);
            return chartInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChartInfo getChartInfoPart7() {
        try {
            List<String> key = new ArrayList<>();
            List<Long> value = new ArrayList<>();
            HDFSUtil.getHDFSFileInfoToChart(url7,key,value);
            ChartInfo chartInfo = new ChartInfo(key,value);
            return chartInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChartInfo getChartInfoPart8() {
        try {
            List<String> key = new ArrayList<>();
            List<Long> value = new ArrayList<>();
            HDFSUtil.getHDFSFileInfoToChart(url8,key,value);
            ChartInfo chartInfo = new ChartInfo(key,value);
            return chartInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChartInfo getChartInfoPart9() {
        try {
            List<String> key = new ArrayList<>();
            List<Long> value = new ArrayList<>();
            HDFSUtil.getHDFSFileInfoToChart(url9,key,value);
            ChartInfo chartInfo = new ChartInfo(key,value);
            return chartInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChartInfo getChartInfoPart10() {
        try {
            List<String> key = new ArrayList<>();
            List<Long> value = new ArrayList<>();
            HDFSUtil.getHDFSFileInfoToChart(url10,key,value);
            ChartInfo chartInfo = new ChartInfo(key,value);
            return chartInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChartInfo getChartInfoPart11() {
        return null;
    }

    @Override
    public ChartInfo getChartInfoPart12() {
        return null;
    }

    @Override
    public ChartInfo getChartInfoPart13() {
        return null;
    }

    @Override
    public ChartInfo getChartInfoPart14() {
        return null;
    }

    @Override
    public ChartInfo getChartInfoPart15() {
        return null;
    }

    @Override
    public ChartInfo getChartInfoPart16() {
        return null;
    }
}
