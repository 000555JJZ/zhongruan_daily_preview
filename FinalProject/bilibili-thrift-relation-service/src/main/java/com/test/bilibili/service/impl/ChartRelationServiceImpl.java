package com.test.bilibili.service.impl;

import com.test.bilibili.dao.ChartRelationDao;
import com.test.thrift.bilibili.ChartInfoRelation;
import com.test.thrift.bilibili.ChartServiceRelation;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChartRelationServiceImpl implements ChartServiceRelation.Iface {
    @Resource
    private ChartRelationDao chartRelationDao;

    @Override
    public ChartInfoRelation getChartInfoRelationPart1() throws TException {
        return chartRelationDao.getChartInfoRelationPart1();
    }

    @Override
    public ChartInfoRelation getChartInfoRelationPart2() throws TException {
        return chartRelationDao.getChartInfoRelationPart2();
    }

    @Override
    public ChartInfoRelation getChartInfoRelationPart3() throws TException {
        return chartRelationDao.getChartInfoRelationPart3();
    }

    @Override
    public ChartInfoRelation getChartInfoRelationPart4() throws TException {
        return chartRelationDao.getChartInfoRelationPart4();
    }

    @Override
    public ChartInfoRelation getChartInfoRelationByStringPart1(String key) throws TException {
        return chartRelationDao.getChartInfoRelationByStringPart1(key);
    }

    @Override
    public ChartInfoRelation getChartInfoRelationByStringPart2(String key) throws TException {
        return chartRelationDao.getChartInfoRelationByStringPart2(key);
    }
}
