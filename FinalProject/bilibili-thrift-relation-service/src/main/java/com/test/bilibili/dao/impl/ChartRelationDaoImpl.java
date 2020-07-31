package com.test.bilibili.dao.impl;

import com.test.bilibili.dao.ChartRelationDao;
import com.test.bilibili.hdfs.HDFSUtils;
import com.test.thrift.bilibili.ChartInfoRelation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChartRelationDaoImpl implements ChartRelationDao {

    @Value("${hdfs.url1}")
    String url1;
    @Value("${hdfs.url2}")
    String url2;
    @Override
    public ChartInfoRelation getChartInfoRelationPart1() {

        List<String> key = new ArrayList<>();
        List<Long> value = new ArrayList<>();
        List<Integer> category = new ArrayList<>();
        List<String> source = new ArrayList<>();
        List<String> target = new ArrayList<>();
        try {
            HDFSUtils.getHDFSFileInfoToRelationChart(url1,key,value,category,source,target);
            return new ChartInfoRelation(key,value,category,target,source);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ChartInfoRelation getChartInfoRelationPart2() {

        return null;
    }

    @Override
    public ChartInfoRelation getChartInfoRelationPart3() {
        return null;
    }

    @Override
    public ChartInfoRelation getChartInfoRelationPart4() {
        return null;
    }

    @Override
    public ChartInfoRelation getChartInfoRelationByStringPart1(String tag) {
        List<String> key = new ArrayList<>();
        List<Long> value = new ArrayList<>();
        List<Integer> category = new ArrayList<>();
        List<String> source = new ArrayList<>();
        List<String> target = new ArrayList<>();
        try {
            HDFSUtils.getHDFSFileInfoToRelationChartByString(url2,tag,key,value,category,source,target);
            return new ChartInfoRelation(key,value,category,target,source);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChartInfoRelation getChartInfoRelationByStringPart2(String tag) {
        return null;
    }
}
