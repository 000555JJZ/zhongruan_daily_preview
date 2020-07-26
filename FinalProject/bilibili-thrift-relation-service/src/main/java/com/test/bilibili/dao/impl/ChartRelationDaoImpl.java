package com.test.bilibili.dao.impl;

import com.test.bilibili.dao.ChartRelationDao;
import com.test.thrift.bilibili.ChartInfoRelation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChartRelationDaoImpl implements ChartRelationDao {
    @Override
    public ChartInfoRelation getChartInfoRelationPart1() {
        List<String> key = new ArrayList<>();
        List<String> value = new ArrayList<>();
        List<Integer> category = new ArrayList<>();
        List<String> source = new ArrayList<>();
        List<String> target = new ArrayList<>();
        key.add("aa");
        ChartInfoRelation chartInfoRelation = new ChartInfoRelation(key,value,category,source,target);
        return chartInfoRelation;
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
    public ChartInfoRelation getChartInfoRelationByStringPart1(String key) {
        return null;
    }

    @Override
    public ChartInfoRelation getChartInfoRelationByStringPart2(String key) {
        return null;
    }
}
