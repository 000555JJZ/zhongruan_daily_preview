package com.test.bilibili.dao;

import com.test.thrift.bilibili.ChartInfoRadar2D;

public interface ChartRadar2DDao {
    ChartInfoRadar2D getChartInfoRadar2DPart1();
    ChartInfoRadar2D getChartInfoRadar2DPart2();
    ChartInfoRadar2D getChartInfoRadar2DPart3();
    ChartInfoRadar2D getChartInfoRadar2DPart4();
    ChartInfoRadar2D getChartInfoRadar2DByStringPart1(String key);
    ChartInfoRadar2D getChartInfoRadar2DByStringPart2(String key);
}
