package com.test.bilibili.service.impl;

import com.test.bilibili.dao.ChartRadar2DDao;
import com.test.thrift.bilibili.ChartInfoRadar2D;
import com.test.thrift.bilibili.ChartServiceRadar2D;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChartRadar2DServiceImpl implements ChartServiceRadar2D.Iface {
    @Resource
    ChartRadar2DDao chartRadar2DDao;

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DPart1() throws TException {
        return chartRadar2DDao.getChartInfoRadar2DPart1();
    }

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DPart2() throws TException {
        return chartRadar2DDao.getChartInfoRadar2DPart2();
    }

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DPart3() throws TException {
        return chartRadar2DDao.getChartInfoRadar2DPart3();
    }

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DPart4() throws TException {
        return chartRadar2DDao.getChartInfoRadar2DPart4();
    }

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DByStringPart1(String key) throws TException {
        return chartRadar2DDao.getChartInfoRadar2DByStringPart1(key);
    }

    @Override
    public ChartInfoRadar2D getChartInfoRadar2DByStringPart2(String key) throws TException {
        return chartRadar2DDao.getChartInfoRadar2DByStringPart2(key);
    }
}
