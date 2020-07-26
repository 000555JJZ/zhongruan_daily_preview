package com.test.bilibili.dao.impl;

import com.test.bilibili.dao.ChartRadar2DDao;
import com.test.thrift.bilibili.ChartInfoRadar2D;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChartDaoRadar2DDaoImpl implements ChartRadar2DDao {
    @Override
    public ChartInfoRadar2D getChartInfoRadar2DPart1() {
        List<String> key = new ArrayList<>();
        List<List<Long>> value = new ArrayList<>();
        key.add("北京");key.add("上海");key.add("天津");
        List<Long> value1 = new ArrayList<>();
        List<Long> value2 = new ArrayList<>();
        List<Long> value3 = new ArrayList<>();
        value1.add((long) 123);value1.add((long) 456);value1.add((long) 789);
        value2.add((long) 147);value2.add((long) 258);value2.add((long) 369);
        value3.add((long) 321);value3.add((long) 654);value3.add((long) 987);
        value.add(value1);value.add(value2);value.add(value3);
        ChartInfoRadar2D test= new ChartInfoRadar2D(key,value);
        return test;
    }

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DPart2() {
        return null;
    }

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DPart3() {
        return null;
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
