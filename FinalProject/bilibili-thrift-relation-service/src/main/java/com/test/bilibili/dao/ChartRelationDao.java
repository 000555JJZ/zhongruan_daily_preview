package com.test.bilibili.dao;

import com.test.thrift.bilibili.ChartInfoRelation;

public interface ChartRelationDao {
    ChartInfoRelation getChartInfoRelationPart1();
    ChartInfoRelation getChartInfoRelationPart2();
    ChartInfoRelation getChartInfoRelationPart3();
    ChartInfoRelation getChartInfoRelationPart4();
    ChartInfoRelation getChartInfoRelationByStringPart1(String key);
    ChartInfoRelation getChartInfoRelationByStringPart2(String key);
}
